package persistent;

//import java.sql.Connection;
import java.util.ArrayList;
;


public class Schedule {
	private String eventid;
	private String location;
	private String start_date;
	private String end_date;
	private String s_time;
	private String e_time;
	private String status;
	//private ItemRequest IRQ;
	public ArrayList<ItemRequest> equipment_list = new ArrayList<ItemRequest>();

	public Schedule(String eventid, String location, String sdate,String edate, String s_time, String e_time,ArrayList<ItemRequest> equipment_list) {
		this.eventid = eventid;
		this.location = location;
		this.start_date = sdate;
		this.end_date = edate;
		this.s_time = s_time;
		this.e_time = e_time;
		this.equipment_list = equipment_list;
		this.status="pending";
	}

	public String getLocation() {
		return location;
	}

	public void updateLocation(String location) {
		this.location = location;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setS_time(String s_time) {
		this.s_time = s_time;
	}

	public String getS_time() {
		return s_time;
	}

	public void updateStartTime(String s_time) {
		this.s_time = s_time;
	}

	public ArrayList<ItemRequest> getEquipment_list() {
		return equipment_list;
	}

	public void setEquipment_list(ArrayList<ItemRequest> equipment_list) {
		this.equipment_list = equipment_list;
	}

	public String getE_time() {
		return e_time;
	}

	public void setE_time(String e_time) {
		this.e_time = e_time;
	}

	public String getEventid() {
		return eventid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	



}
