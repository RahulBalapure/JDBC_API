package com.model;

public class product {
	private int pid;
	private String pname;
	private String ptype;
	private String pdescription;
	private double pprice;
	private byte[] pimage;
	public byte[] getPimage() {
		return pimage;
	}
	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pdescription=" + pdescription
				+ ", pprice=" + pprice + "]";
	}

}
