package persistent;

import java.util.Comparator;

public class Resource implements Comparable<Resource>,Comparator<Resource>{
	private String Ename;
	private String ID;
	private int T_Qty;
	private int R_Qty;

	
	public Resource(String iD,String ename, int t_Qty,int r_Qty) {
		this.Ename = ename;
		this.ID = iD;
		this.T_Qty = t_Qty;
		this.R_Qty = t_Qty;
	}
	
	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		this.Ename = ename;
	}

	public String getID() {
		return ID;
	}

	public int getT_Qty() {
		return T_Qty;
	}

	public void setT_Qty(int t_Qty) {
		this.T_Qty = t_Qty;
	}

	public int getR_Qty() {
		return R_Qty;
	}

	public void setR_Qty(int r_Qty) {
		this.R_Qty = r_Qty;
	}

	//updateresourcedetails(name.tq,r,)
	///this.setrqty();
	
	
	
	@Override
	public int compareTo(Resource resource) {
		return this.getID().compareTo(resource.getID());
	}
	
	@Override
	public int compare(Resource res1, Resource res2 ) {
		return res1.getID().compareTo(res2.getID());
	}

		
}