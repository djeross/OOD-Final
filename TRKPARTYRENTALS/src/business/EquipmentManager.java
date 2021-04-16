package business;
import persistent.Resource;

import java.util.ArrayList;

import DBControl.DatabaseManager;

public class EquipmentManager {
	DatabaseManager dbmanager;
	
	
	
	
	public EquipmentManager(){
		this.dbmanager = new DatabaseManager();
	}

	
	

	public ArrayList<Object[]> getEquipmentByID(String equip_id) {
		return dbmanager.getEquipmentByID(equip_id);
	}
	
	public ArrayList<Object[]>getEquipmentByName(String equip_name) {
		return dbmanager.getEquipmentByName(equip_name);
	}


	public ArrayList<String> getIdList(){
		return dbmanager.getReosurceIDs();
	}
	
	public ArrayList<Object[]> getResourceList(){
		return dbmanager.getReosurceTable();
	}
	
	public void addEquipment(String equip_id, String equip_name, int t_qty, int r_qty){
		dbmanager.addEquipmentDetails(equip_id, equip_name, t_qty, r_qty);
	}
	
	//remember to deal with reponse in gui
	public String deleteEquipment(String equip_id){
		return dbmanager.deleteEquipment(equip_id);
	}
	
	/*function(0)
	 * name tq rq id ##ui details that will updat object
	 * Obect[] dd=getResourceDB(String rid); database to create resource
	 * rqty=dd[3].toString();
	 * r=Resource(String iD,String ename, Integer.parseInt(rqty))
	 * r.modfy(dsafsgh)
	 * dmanngere(r,getname)
	 * 
	 * 
	 */
	
	public void modifyEquipment(String id, String name, String t_qty, String r_qty) {
		
		Object[] match = dbmanager.getResourceDB(id);
		
		String match_id = match[0].toString();
		String match_name = match[1].toString();
		String match_Tqty = match[2].toString();
		String match_Rqty = match[3].toString();
		
		Resource resource = new Resource(match_id, match_name, Integer.parseInt(match_Tqty), Integer.parseInt(match_Rqty));
		System.out.println(id+resource.getEname()+resource.getT_Qty()+resource.getR_Qty());
		resource = updateResourceDetails(resource, name, Integer.parseInt(t_qty), Integer.parseInt(r_qty));
		System.out.println(id+resource.getEname()+resource.getT_Qty()+resource.getR_Qty());
		dbmanager.modifyEquipment(id, resource.getEname(), resource.getT_Qty(), resource.getR_Qty());
		
	}
	
	private Resource updateResourceDetails(Resource resource,String name,int total,int remain) {
		resource.setEname(name);
		resource.setR_Qty(remain);
		resource.setT_Qty(total);
		return resource;
	}
	
		

}