package database;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;
import database.TrkDatabaseConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import persistent.*;
public class Rundb {

	public static void main(String[] args) throws SQLException {
		
		
		
		
		
		
		//ALTER TABLE `schedule`  ADD `ID` INT(100) UNSIGNED NOT NULL  FIRST,  ADD   UNIQUE  (`ID`);
		/*LocalDate date = LocalDate.now();
		System.out.println("2021-01-01");
	    WeekFields weekFields = WeekFields.of(Locale.getDefault());
	    System.out.println( date.get(weekFields.weekOfWeekBasedYear()));*/
		/*try {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2021-03-30");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println(week);*/
        
       /* String id="tabl#123";
        String date="2021-04-28";
        String query="SELECT r.Total_Quantity-sum(quantity) AS remain FROM upcomingrequest ur JOIN upcomingschedule "
				+"us ON ur.EventID=us.EventID JOIN resource r ON r.EquipmentID=ur.EquipmentID WHERE ur.EquipmentID='"+id+"' AND YEARWEEK(us.Start_Date)=YEARWEEK('"+date+"')";
		
        System.out.println( query);
        ResultSet result;
		try {
			result =new TrkDatabaseConnect().getStmt().executeQuery(query);
			int totalremain=0;
			while(result.next()){
				totalremain = result.getInt("remain");
			} 
			System.out.println( totalremain);
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now).toString());*/
		//System.out.println(ChronoField.DAY_OF_WEEK.range().getMinimum());
		/*String query="select sum(ur.quantity) as remain from upcomingrequest ur join upcomingschedule us ON ur.EventID=us.EventID join resource r on r.EquipmentID=ur.EquipmentID"
				+ " WHERE ur.EquipmentID=? and YEARWEEK(us.Start_Date)=YEARWEEK(?) or (ur.EquipmentID=? and (YEARWEEK(us.Start_Date)=YEARWEEK(?) and YEARWEEK(us.End_Date)=YEARWEEK(?)))";
		PreparedStatement statement = new TrkDatabaseConnect().getDbconn().prepareStatement(query);
		statement.setString(1, "tent#556"); 
		statement.setString(2, "2021-04-28"); 
		statement.setString(3, "tent#556");
		statement.setString(4, "2021-04-22");
		statement.setString(5, "2021-04-28");
		
		ResultSet r=statement.executeQuery();
		r.next();
		System.out.println(r.getInt("remain"));*/
		String query="SELECT r.Total_Quantity as total,sum(quantity) as emptycheck ,r.Total_Quantity-sum(quantity) AS remain from contains ur join schedule us ON ur.EventID=us.EventID join resource r on r.EquipmentID=ur.EquipmentID"
				+ " WHERE ur.EquipmentID=? and YEARWEEK(us.Start_Date)=YEARWEEK(?) and ur.Status='pending' or (ur.Status='pending' and ur.EquipmentID=? and (YEARWEEK(us.Start_Date)<YEARWEEK(?) and YEARWEEK(us.End_Date)>=YEARWEEK(?)))";
		PreparedStatement statement = new TrkDatabaseConnect().getDbconn().prepareStatement(query);
		statement.setString(1, "Cha#tcn"); 
		statement.setString(2, "2021-04-28"); 
		statement.setString(3, "Cha#tcn");
		statement.setString(4, "2021-04-28");
		statement.setString(5, "2021-04-28");
		
		ResultSet result;
		
		ResultSet r=statement.executeQuery();
		r.next();
		System.out.println(r.getInt("remain"));
		
	
		 //new Rundb().schedulePending();
		
	}
	public void schedulePending() {
		LocalDateTime now = LocalDateTime.now();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	}

}
