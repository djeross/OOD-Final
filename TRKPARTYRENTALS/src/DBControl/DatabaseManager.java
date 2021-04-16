package DBControl;
import database.TrkDatabaseConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DatabaseManager{
	private TrkDatabaseConnect trkconnect;
	/**
	 * 
	 */
	public DatabaseManager() {
		this.trkconnect= new TrkDatabaseConnect();
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public TrkDatabaseConnect getTrkconnect() {
		return trkconnect;
	}
	
	
	public ArrayList<String> getReosurceIDs(){
		ArrayList<String>list=new ArrayList<String>();
		String query="SELECT DISTINCT EquipmentID FROM resource order by EquipmentID asc";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String equipid="";
			while(result.next()){
				equipid = result.getString("EquipmentID");
				list.add(equipid);
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
	}
	
	public ArrayList<Object[]> getReosurceTable(){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		String query="SELECT DISTINCT * FROM resource order by EquipmentID asc";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String equipid,name;
			int totalqty,remainqty;
			equipid=name="";
			totalqty=remainqty=0;
			while(result.next()){
				equipid = result.getString("EquipmentID");
				name = result.getString("EquipmentName");
				totalqty = Integer.parseInt(result.getString("Total_Quantity"));
				remainqty = Integer.parseInt(result.getString("Remaining_Quantity"));
				list.add(new Object[]{equipid, name, totalqty, remainqty});
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Used to get the table fields of a Reseource object from the database.
	 * @param trkconn
	 * @param rid
	 * @return Object[]
	 */
	public Object[] getResourceDB(String rid){
		String query="SELECT DISTINCT EquipmentID, EquipmentName, Total_Quantity, Remaining_Quantity FROM resource where EquipmentID='"+rid+"'";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String equipid,name;
			int totalqty,remainqty;
			equipid=name="";
			totalqty=remainqty=0;
			while(result.next()){
				equipid = result.getString("EquipmentID");
				name = result.getString("EquipmentName");
				totalqty = Integer.parseInt(result.getString("Total_Quantity"));
				remainqty = Integer.parseInt(result.getString("Remaining_Quantity"));
			}
			return new Object[]{equipid, name, totalqty, remainqty};
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	
	public int[] areValidUpcomingRequest(String id, String date){
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String query="SELECT r.Total_Quantity as total,sum(quantity) as emptycheck ,r.Total_Quantity-sum(quantity) AS remain from contains ur join schedule us ON ur.EventID=us.EventID join resource r on r.EquipmentID=ur.EquipmentID"
					+ " WHERE ur.EquipmentID=? and YEARWEEK(us.Start_Date)=YEARWEEK(?) and ur.Status='pending' or (ur.Status='pending' and ur.EquipmentID=? and (YEARWEEK(us.Start_Date)<YEARWEEK(?) and YEARWEEK(us.End_Date)=YEARWEEK(?)))";
			PreparedStatement statement = trkconn.getDbconn().prepareStatement(query);
			statement.setString(1, id); 
			statement.setString(2, date); 
			statement.setString(3, id);
			statement.setString(4, date);
			statement.setString(5, date);
			
			ResultSet result;
			
			result = statement.executeQuery();
			int remain,total,check;
			remain=total=check=0;
			while(result.next()){
				total = result.getInt("total");
				check = result.getInt("emptycheck");
				remain = result.getInt("remain");
			} 
			return new int[] {total,check,remain};
		}
		catch (SQLException e) {
			e.printStackTrace();
			return new int[]{-1};
		}
	}
	
	
	public String addEquipmentUpcomingSchedule(String eventid, String location, String sdate,String edate, String s_time, String e_time, ArrayList<String[]> equipment_list){
		String response="";
		int query1 = addUpcomingSchedulingDetails(eventid, location, sdate, edate, s_time, e_time);
		if(query1 >0){
			String add_eqp_response=addEquipmentUpcomingRequestsList(eventid,equipment_list);
			if(add_eqp_response.equals("")){
				response="success";
			}else{
				response="Error in Scheduling Equipment, Failure To Schedule equipment";
			}
		}else {
			response="Error in Scheduling Details, Failure To Schedule equipment";
		}
		return response;
	}
	
	private int addUpcomingSchedulingDetails(String eventid, String location, String sdate,String edate, String s_time, String e_time){
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String status="pending";
			String query="INSERT INTO schedule (EventID,Location,Start_Date,End_Date,Start_Time,End_Time,Status)VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			statement.setString(1, eventid); 
			statement.setString(2, location); 
			statement.setString(3, sdate);
			statement.setString(4, edate);
			statement.setString(5, s_time); 
			statement.setString(6, e_time);
			statement.setString(7, status);
			return statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
			return -1;
		}
	}
	
	private String addEquipmentUpcomingRequestsList(String eventid,ArrayList<String[]> equipment_list){
		String response="";
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String status="pending";
			for(String[] pair:equipment_list) {
				String query="INSERT INTO contains (EventID,EquipmentID,Quantity,Status)VALUES (?, ?, ?, ?)";
				PreparedStatement statement2 =trkconn.getDbconn().prepareStatement(query);
				String equipid=pair[0];
				int requested_quantity= Integer.parseInt(pair[1]);
				statement2.setString(1, eventid);
				statement2.setString(2, equipid);
				statement2.setInt(3, requested_quantity);
				statement2.setString(4, status);
				int query2 = statement2.executeUpdate();
				if(query2 >0){
					response="";
				}
				else {
					response+="Fail to Schedule "+equipid+" for Event ID: "+eventid;
				}
			}
			return response;
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Error in Scheduling Equipment, Failure To Schedule equipment";
		}
	}
	
	


	/**
	 * Schedule an equipment for an event.
	 * @param schedule schedule object from which the attribute will be used to update database. 
	 */
	public String addEquipmentSchedule(String eventid, String location, String sdate,String edate, String s_time, String e_time, ArrayList<String[]> equipment_list){
			String response="";
			int query1 = addSchedulingDetails(eventid, location, sdate, edate, s_time, e_time);
			if(query1 >0){
				String add_eqp_response=addEquipmentRequestsList(eventid,equipment_list);
				if(add_eqp_response.equals("")){
					response="success";
				}else{
					response="Error in Scheduling Equipment, Failure To Schedule equipment";
				}
			}else {
				response="Error in Scheduling Details, Failure To Schedule equipment";
			}
			return response;
	}
	
	
	private int addSchedulingDetails(String eventid, String location, String sdate,String edate, String s_time, String e_time){
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String status="scheduled";
			String query="INSERT INTO schedule (EventID,Location,Start_Date,End_Date,Start_Time,End_Time,Status)VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			statement.setString(1, eventid); 
			statement.setString(2, location); 
			statement.setString(3, sdate);
			statement.setString(4, edate);
			statement.setString(5, s_time); 
			statement.setString(6, e_time);
			statement.setString(7, status);
			return statement.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
			return -1;
		}
	}
	
	private String addEquipmentRequestsList(String eventid,ArrayList<String[]> equipment_list){
		String status="scheduled";
		String response="";
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			for(String[] pair:equipment_list) {
				String query="INSERT INTO contains (EventID,EquipmentID,Quantity,Status)VALUES (?, ?, ?, ?)";
				PreparedStatement statement2 =trkconn.getDbconn().prepareStatement(query);
				String equipid=pair[0];
				int requested_quantity= Integer.parseInt(pair[1]);
				statement2.setString(1, eventid);
				statement2.setString(2, equipid);
				statement2.setInt(3, requested_quantity);
				statement2.setString(4, status);
				int query2 = statement2.executeUpdate();
				if(query2 >0){
					int remaining_quantity=Integer.parseInt(getResourceDB(equipid)[3].toString());
					remaining_quantity=remaining_quantity-requested_quantity;
					query="UPDATE resource SET Remaining_Quantity='"+remaining_quantity+"' WHERE EquipmentID ='"+equipid+"'";
					trkconn.getStmt().executeUpdate(query);
				}
				else {
					response+="Fail to Schedule "+equipid+" for Event ID: "+eventid;
				}
			}
			return response;
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Error in Scheduling Equipment, Failure To Schedule equipment";
		}
	}
	
	
	/*Dahalia addEqp delete eqp*/
	public String addEquipmentDetails(String id,String name, int t_qty, int r_qty){
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String query="INSERT INTO resource (EquipmentID,EquipmentName,Total_Quantity,Remaining_Quantity) VALUES (?, ?, ?, ?)";
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			statement.setString(1, id); 
			statement.setString(2, name); 
			statement.setInt(3, t_qty);
			statement.setInt(4, r_qty);
			int rtval=statement.executeUpdate();
			if (rtval>-1) {
				return "";
			}else {
				return "Faliure to add New Equipment to Inventory";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return "Faliure to add New Equipment to Inventory";
		}
	}
	
	
	public String deleteEquipment(String equip_id){
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String query="DELETE FROM resource WHERE EquipmentID='" + equip_id + "'";

			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			int rtval=statement.executeUpdate();
			if (rtval>-1) {
				return "";
			}else {
				return "Faliure to delete Equipment from Inventory";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return "Faliure to delete Equipment from Inventory";
		}
	}
	
	public String returnEquipment(String event_id, ArrayList<Object[]> equipment){
		
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			
			String query1="UPDATE schedule SET Status='completed' WHERE EventID ='"+ event_id +"'";

			PreparedStatement statement1 =trkconn.getDbconn().prepareStatement(query1);
			
			statement1.executeUpdate();
			
			for(Object[] r : equipment) {
				
				Object[] resource = getResourceDB((String) r[1]);
				int remaining_quantity = (int) resource[3];
				int qty = Integer.parseInt(r[3].toString());
				
				String query="UPDATE resource SET Remaining_Quantity='"+ (remaining_quantity + qty) +"' WHERE EquipmentID ='"+ (String) r[1] +"'";

				PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
				
				statement.executeUpdate();
				
				String query2="UPDATE contains SET Status='returned' WHERE EquipmentID ='"+ (String) r[1] +"' and EventID ='"+ event_id +"'";

				PreparedStatement statement2 =trkconn.getDbconn().prepareStatement(query2);
				
				statement2.executeUpdate();
			}
			
			return "";
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			return "Failure to return Equipment";
		}
	}
	
	public ArrayList<Object[]> getEquipmentByID(String equip_id){
		ArrayList<Object[]> list= new ArrayList<Object[]>();
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String query = ("SELECT * FROM resource WHERE EquipmentID LIKE '%" + equip_id + "%';");
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			ResultSet result = statement.executeQuery(query);
			
			String equipid,name;
			int totalqty,remainqty;
			equipid=name="";
			totalqty=remainqty=0;
			
			while(result.next()){
				equipid = result.getString("EquipmentID");
				name = result.getString("EquipmentName");
				totalqty = Integer.parseInt(result.getString("Total_Quantity"));
				remainqty = Integer.parseInt(result.getString("Remaining_Quantity"));
				list.add(new Object[]{equipid, name, totalqty, remainqty});
			}
			
			return list;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Object[]> getEquipmentByName(String equip_name){
		ArrayList<Object[]> list= new ArrayList<Object[]>();
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String query = ("SELECT * FROM resource WHERE EquipmentName LIKE '%" + equip_name + "%';");
			
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			ResultSet result = statement.executeQuery(query);
			
			String equipid,name;
			int totalqty,remainqty;
			equipid=name="";
			totalqty=remainqty=0;
			
			while(result.next()){
				equipid = result.getString("EquipmentID");
				name = result.getString("EquipmentName");
				totalqty = Integer.parseInt(result.getString("Total_Quantity"));
				remainqty = Integer.parseInt(result.getString("Remaining_Quantity"));
				list.add(new Object[]{equipid, name, totalqty, remainqty});
			}
			return list;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Object[]> getScheduledEquipment(){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		String query="SELECT contains.EventID, contains.EquipmentID, resource.EquipmentName, contains.Quantity FROM resource JOIN contains ON resource.EquipmentID = contains.EquipmentID";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String eventId, equipId, equipName, qty;
			eventId = equipId = equipName = qty = "";
			while(result.next()) {
				eventId = result.getString("EventID");
				equipId = result.getString("EquipmentID");
				equipName = result.getString("EquipmentName");
				qty = result.getString("Quantity");
				
				list.add(new Object[]{eventId, equipId, equipName, qty});
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public ArrayList<Object[]> getScheduledEquipment(String eventID){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		String query="SELECT contains.EventID, contains.EquipmentID, resource.EquipmentName, contains.Quantity FROM resource JOIN contains ON resource.EquipmentID = contains.EquipmentID WHERE EventID='" + eventID + "'";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String eventId, equipId, equipName, qty;
			eventId = equipId = equipName = qty = "";
			while(result.next()) {
				eventId = result.getString("EventID");
				equipId = result.getString("EquipmentID");
				equipName = result.getString("EquipmentName");
				qty = result.getString("Quantity");
				
				list.add(new Object[]{eventId, equipId, equipName, qty});
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	

	///////////////////////////nazhon//////////////////////////////
	public ArrayList<Object[]> getAllEquipmentSchedules(String equipid){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		String query="SELECT * FROM schedule WHERE EventID in (SELECT DISTINCT EventID FROM contains WHERE EquipmentID='"+equipid+"')";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String eventid,location,start_date, end_date,start_time,end_time;
			eventid = location = start_date = end_date  = start_time = end_time = "";
			
			while(result.next()) {
				eventid = result.getString("EventID");
				location = result.getString("Location");
				start_date = result.getString("Start_Date");
				end_date = result.getString("End_Date");
				start_time = result.getString("Start_Time");
				end_time = result.getString("End_Time");
				
				list.add(new Object[] {eventid, location, start_date, end_date, start_time, end_time});
			}
			
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public ArrayList<Object[]> getSchedule(String eventId){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		String query="SELECT * FROM schedule WHERE EventID='"+eventId+"'";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String eventid,location,start_date, end_date,start_time,end_time;
			eventid = location = start_date = end_date  = start_time = end_time = "";
			
			while(result.next()) {
				eventid = result.getString("EventID");
				location = result.getString("Location");
				start_date = result.getString("Start_Date");
				end_date = result.getString("End_Date");
				start_time = result.getString("Start_Time");
				end_time = result.getString("End_Time");
				
				list.add(new Object[] {eventid, location, start_date, end_date, start_time, end_time});
			}
			
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public ArrayList<Object[]> getAllSchedules(){
		
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			
			String query = ("SELECT * FROM schedule;");
			
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			ResultSet result = statement.executeQuery(query);
			
			String eventid,location,start_date, end_date,start_time,end_time,status;
			eventid = location = start_date = end_date  = start_time = end_time = status = "";
			
			while(result.next()) {
				eventid = result.getString("EventID");
				location = result.getString("Location");
				start_date = result.getString("Start_Date");
				end_date = result.getString("End_Date");
				start_time = result.getString("Start_Time");
				end_time = result.getString("End_Time");
				status = result.getString("Status");
				
				list.add(new Object[] {eventid, location, start_date, end_date, start_time, end_time, status});
			}
			
			return list;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Object[]> getSchedeuledSchedules(){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			
			String query = ("SELECT * FROM schedule where Status='scheduled';");
			
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			ResultSet result = statement.executeQuery(query);
			
			String eventid,location,start_date, end_date,start_time,end_time,status;
			eventid = location = start_date = end_date  = start_time = end_time = status = "";
			
			while(result.next()) {
				eventid = result.getString("EventID");
				location = result.getString("Location");
				start_date = result.getString("Start_Date");
				end_date = result.getString("End_Date");
				start_time = result.getString("Start_Time");
				end_time = result.getString("End_Time");
				status = result.getString("Status");
				
				list.add(new Object[] {eventid, location, start_date, end_date, start_time, end_time, status});
			}
			
			return list;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Object[]> PendingAndScheduled(){
		ArrayList<Object[]>list=new ArrayList<Object[]>();
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			
			String query = ("SELECT * FROM schedule where Status='scheduled' or  Status='pending' order by Start_Date desc;");
			
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			ResultSet result = statement.executeQuery(query);
			
			String eventid,location,start_date, end_date,start_time,end_time,status;
			eventid = location = start_date = end_date  = start_time = end_time = status = "";
			
			while(result.next()) {
				eventid = result.getString("EventID");
				location = result.getString("Location");
				start_date = result.getString("Start_Date");
				end_date = result.getString("End_Date");
				start_time = result.getString("Start_Time");
				end_time = result.getString("End_Time");
				status = result.getString("Status");
				
				list.add(new Object[] {eventid, location, start_date, end_date, start_time, end_time, status});
			}
			
			return list;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	public ArrayList<String> getContainsIDs(){
		ArrayList<String>list=new ArrayList<String>();
		String query="SELECT DISTINCT EquipmentID FROM contains ";
		ResultSet result;
		try {
			result = getTrkconnect().getStmt().executeQuery(query);
			String equipid="";
			while(result.next()){
				equipid = result.getString("EquipmentID");
				list.add(equipid);
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
	}
	
	
	public String modifyEquipment(String equip_id, String equip_name, int t_qty, int r_qty){
		try {
			TrkDatabaseConnect trkconn=this.getTrkconnect();
			String query;
			
			query = "UPDATE resource SET EquipmentName='" + equip_name + "', Total_Quantity='" + t_qty + "', Remaining_Quantity='" + r_qty + "' WHERE EquipmentID='" + equip_id+ "'";
			
			PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
			
			int rtval=statement.executeUpdate();
			
			if (rtval>-1) {
				return "";
			} else {
				return "Faliure to modify equipment";
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
			return "Faliure to modify equipment";
		}
	}
	
	public void modifySchedule(String eventid, String location, String sdate,String edate, String s_time, String e_time, ArrayList<String[]> equipment_list){
		TrkDatabaseConnect trkconn=this.getTrkconnect();
		String query="UPDATE schedule SET Location='"+location+"', SET Start_Date='"+sdate+"', SET End_Date='"+edate+"', "
				+ " SET Start_Time='"+s_time+"', SET End_Time='"+e_time+"' WHERE EventID ='"+eventid+"'";
		try {
			trkconn.getStmt().executeUpdate(query);
			for(String[] x: equipment_list){
				String q="UPDATE contains set Quantity='" +Integer.parseInt(x[1])+ "' WHERE EquipmentID='" + x[0]+ "' and EventID ='"+eventid+"'";
				PreparedStatement statement =trkconn.getDbconn().prepareStatement(query);
				statement.executeUpdate();	
			}
		} catch (SQLException e) {
			
		}
		
	}
	
	
	
	
	
	
}