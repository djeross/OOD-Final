package business;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DBControl.DatabaseManager;
import persistent.ItemRequest;
import persistent.Schedule;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScheduleManager {
	DatabaseManager dbmanager=new DatabaseManager();
	
	public ScheduleManager() {
		this.dbmanager = new DatabaseManager();
	}
	
	
	private int getCurrentWeek(String inputdate) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = df.parse(inputdate);
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.setFirstDayOfWeek(Calendar.SUNDAY);
	        int week = cal.get(Calendar.WEEK_OF_YEAR);
	        return week-1;
		}catch(Exception e) {
			return -1;
		}
				  
	}
	
	private String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now).toString();
	}
	
	
	public String scheduleEquipment(String eventid, String location, String sdate,String edate, String s_time, String e_time, ArrayList<String[]> list){
		String response="";
		if (getCurrentWeek(getCurrentDate())==getCurrentWeek(sdate)) {
			response=areValidSelections(list);
			if (response.isBlank()){
				response=dbmanager.addEquipmentSchedule(eventid, location, sdate, edate, s_time, e_time, list);
				return response;
			}else {
				return response;
			}
		}else {
			response=areValidUpcomingSelections(list,sdate);
			if (response.isBlank()){
				response=dbmanager.addEquipmentUpcomingSchedule(eventid, location, sdate, edate, s_time, e_time, list);
				return response;
			}else {
				return response;
			}
		}
			
	}
	
	
	private String areValidSelections(ArrayList<String[]>list){
		String response="";
		for(String[] request: list) {
			String resourceid= request[0];
			int requestedamount= Integer.parseInt(request[1]);
			int remainingquantity=Integer.parseInt(dbmanager.getResourceDB(resourceid)[3].toString());
			if(requestedamount>remainingquantity) {
				response+="Equipment ID: "+resourceid+"     Available Quantity: "+remainingquantity+"\n";
			}	
		}
		return response;
	}
	
	private String areValidUpcomingSelections(ArrayList<String[]>list, String date){
		int remain,total,check;
		String response="";
		for(String[] request: list) {
			String resourceid= request[0];
			int requestedamount= Integer.parseInt(request[1]);
			int[] values=dbmanager.areValidUpcomingRequest(resourceid,date);
			total=values[0];
			check=values[1];
			remain=values[2];
			
			if(check==0 && remain==0){
				if(requestedamount>total) {
					response+="Equipment ID: "+resourceid+"     Available Quantity: "+total+"\n";
				}	
			}else if(check!=0 && requestedamount>remain){
				response+="Equipment ID: "+resourceid+"     Available Quantity: "+remain+"\n";
			}
		}
		return response;
	}
	

	
	public void modifySchedule(String id, ArrayList<Object> previousSchedule, ArrayList<Object> updatedSchedule, ArrayList<Object[]> itemRequests){
		ArrayList<ItemRequest> requests = new ArrayList<ItemRequest>();
		ArrayList<Object[]> dbrequest=dbmanager.getScheduledEquipment(id);
		ArrayList<Object[]> slist=dbmanager.getSchedule(id);
		Schedule cschedule;
		for(Object[] req:dbrequest){
			requests.add(new ItemRequest(req[1].toString(), Integer.parseInt(req[3].toString())));
		}
		Object[] sch=slist.get(0);
		cschedule = new Schedule(sch[0].toString(),sch[1].toString(),sch[2].toString(),sch[3].toString(),sch[4].toString(),sch[5].toString(), requests);
		cschedule=updateSchedule(cschedule,updatedSchedule,itemRequests);

		if (getCurrentWeek(getCurrentDate())==getCurrentWeek(cschedule.getStart_date())) {
			 resourcechange(cschedule.getEquipment_list(),dbrequest);
			 ArrayList<String[]> req = new ArrayList<String[]>();
			 for(ItemRequest ir:cschedule.getEquipment_list()) {
				 req.add(new String[]{ir.getResourceid(),((Integer)ir.getQuantity()).toString()});
			 }
			 dbmanager.modifySchedule(cschedule.getEventid(), cschedule.getLocation(), cschedule.getStart_date(),cschedule.getEnd_date(), cschedule.getS_time(), cschedule.getE_time(), req);
			
		}else {
			 ArrayList<String[]> req = new ArrayList<String[]>();
			 for(ItemRequest ir:cschedule.getEquipment_list()) {
				 req.add(new String[]{ir.getResourceid(),((Integer)ir.getQuantity()).toString()});
			 }
			 dbmanager.modifySchedule(cschedule.getEventid(), cschedule.getLocation(), cschedule.getStart_date(),cschedule.getEnd_date(), cschedule.getS_time(), cschedule.getE_time(), req);
		}
		
	}
	
	private void resourcechange(ArrayList<ItemRequest> requestslist,ArrayList<Object[]> itemRequests){
		for(Object[] ireq: itemRequests) {
			for(ItemRequest reqst:requestslist ) {
				if(reqst.getResourceid().equals(ireq[0].toString())) {
					Object[]dbresource=dbmanager.getResourceDB(reqst.getResourceid());
					if(reqst.getQuantity()>Integer.parseInt(ireq[3].toString())){
						dbmanager.modifyEquipment(reqst.getResourceid(), dbresource[1].toString() , Integer.parseInt(dbresource[2].toString()),Integer.parseInt(dbresource[3].toString())-(reqst.getQuantity()-Integer.parseInt(ireq[3].toString())));
						
					}
					else if(reqst.getQuantity()<Integer.parseInt(ireq[3].toString())){
						dbmanager.modifyEquipment(reqst.getResourceid(), dbresource[1].toString() , Integer.parseInt(dbresource[2].toString()),Integer.parseInt(dbresource[3].toString())+(Integer.parseInt(ireq[3].toString())-reqst.getQuantity()));
					}
					else {
						dbmanager.modifyEquipment(reqst.getResourceid(), dbresource[1].toString() , Integer.parseInt(dbresource[2].toString()),Integer.parseInt(dbresource[3].toString()));
					}
				}
			}
		}
		
	}
	
	private Schedule updateSchedule(Schedule schedule,ArrayList<Object> updatedSchedule,ArrayList<Object[]> itemRequests){
		schedule.setLocation(updatedSchedule.get(0).toString());
		schedule.setStart_date(updatedSchedule.get(1).toString());
		schedule.setEnd_date(updatedSchedule.get(2).toString());
		schedule.setS_time(updatedSchedule.get(3).toString());
		schedule.setE_time(updatedSchedule.get(4).toString());
		for(Object[] ireq: itemRequests) {
			for(ItemRequest reqst: schedule.getEquipment_list()) {
				if(reqst.getResourceid().equals(ireq[0].toString())) {
					reqst.setQuantity(Integer.parseInt(ireq[0].toString()));
				}
			}
		}
		return schedule;
	}
	
	
	public ArrayList<Object[]> viewAllEquipmentSchedules(String equip_id){
		return dbmanager.getAllEquipmentSchedules(equip_id);
	}
	
	public ArrayList<Object[]> viewAllSchedules(){
		return dbmanager.getAllSchedules();
	}
	

	public ArrayList<String> getContainsIdList() {
		return dbmanager.getContainsIDs();
	}
	
	public ArrayList<Object[]> viewSchedule(String eventId){
		return dbmanager.getSchedule(eventId);
	}
	
	public ArrayList<Object[]> getScheduledEquipment(String eventId){
		return dbmanager.getScheduledEquipment(eventId);
	}
	
	public ArrayList<Object[]> getScheduledEquipment(){
		return dbmanager.getScheduledEquipment();
	}
	
	public String returnEquipment(String event_id, ArrayList<Object[]> equipment){
		return dbmanager.returnEquipment(event_id, equipment);
	}
	
	public ArrayList<Object[]> viewScheduledSchedules(){
		return dbmanager.getSchedeuledSchedules();
	}
	
	public ArrayList<Object[]> getPendingAndScheduledSchedules(){
		return dbmanager.PendingAndScheduled();
	}
	
	
}