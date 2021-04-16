package business;

import java.util.ArrayList;


public class TrkAPP {
	EquipmentManager equipmentmanager;
	ScheduleManager schedulemanager;
	ReportManager reportmanager;
	ArrayList<String> list_of_resource_ids;
	
	public TrkAPP(){
		this.reportmanager=new ReportManager(); 
		this.equipmentmanager=new EquipmentManager();
		this.schedulemanager=new ScheduleManager();
		this.list_of_resource_ids=loadIDs();
	}
	
	
	public ArrayList<String> loadIDs(){
		return equipmentmanager.getIdList();
	}
	
	public ArrayList<Object[]> loadResourceList(){
		return equipmentmanager.getResourceList();
	}
	


	/**
	 * Schedule an equipment for an event.
	 * @param schedule schedule object from which the attribute will be used to update database. 
	 */
	public String callScheduleEquipment(String eventid, String location, String sdate,String edate, String s_time, String e_time, ArrayList<String[]> list){
		return schedulemanager.scheduleEquipment(eventid, location, sdate,edate, s_time, e_time, list);
	}
	
	/////////////////////////////Equipment related stuff.////////////////////
	
	public void callAddEquipment(String equip_id, String equip_name, int t_qty, int r_qty){
		equipmentmanager.addEquipment(equip_id, equip_name, t_qty, r_qty);
	}
	
	public void callDeleteEquipment(String equip_id){
		equipmentmanager.deleteEquipment(equip_id);
	}
	
	public ArrayList<Object[]> callGetEquipmentByID(String equip_id) {
		return equipmentmanager.getEquipmentByID(equip_id);
	}
	
	public ArrayList<Object[]>callGetEquipmentByName(String equip_name) {
		return equipmentmanager.getEquipmentByName(equip_name);
	}
	
	public void callModifyEquipment(String id, String name, String t_qty, String r_qty){
		equipmentmanager.modifyEquipment(id, name, t_qty, r_qty);
	}
	
	public Boolean isValidQty(String qty) {
		try {
			int intQty = Integer.parseInt(qty);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	

	
	///////////////////////////////////schedule related stuff//////////////////
	
	public ArrayList<Object[]> callViewAllEquipmentSchedules(String equip_id){
		return schedulemanager.viewAllEquipmentSchedules(equip_id);
	}
	
	public ArrayList<Object[]> callViewAllSchedules(){
		return schedulemanager.viewAllSchedules();
	}
	
	public ArrayList<String> loadContainsIDs(){
		return schedulemanager.getContainsIdList();
	}
	
	public ArrayList<Object[]> callViewSchedule(String eventId){
		return schedulemanager.viewSchedule(eventId);
	}
	
	public ArrayList<Object[]> callGetScheduledEquipment(String eventId){
		return schedulemanager.getScheduledEquipment(eventId);
	}
	
	public ArrayList<Object[]> callGetScheduledEquipment(){
		return schedulemanager.getScheduledEquipment();
	}
	
	public void callModifySchedule(String id, ArrayList<Object> previousSchedule, ArrayList<Object> updatedSchedule, ArrayList<Object[]> itemRequests){
		schedulemanager.modifySchedule(id,previousSchedule,updatedSchedule,itemRequests);
	}
	
	public String callReturnEquipment(String event_id, ArrayList<Object[]> equipment){
		return schedulemanager.returnEquipment(event_id, equipment);
	}
	
	public ArrayList<Object[]> callViewScheduledSchedules(){
		return schedulemanager.viewScheduledSchedules();
	}
	
	public ArrayList<Object[]> callPendingAndScheduledSchedules(){
		return schedulemanager.getPendingAndScheduledSchedules();
	}
	
	
	
}

	
	