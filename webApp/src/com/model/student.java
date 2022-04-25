package com.model;

public class student {
	private int sid;
	private String sname;
	private String semail;
	private String spassword;
	private String sgender;
	private String saddress;
	private double spercentage;
	private String shobbies;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public double getSpercentage() {
		return spercentage;
	}
	public void setSpercentage(double spercentage) {
		this.spercentage = spercentage;
	}
	public String getShobbies() {
		return shobbies;
	}
	public void setShobbies(String shobbies) {
		this.shobbies = shobbies;
	}
	@Override
	public String toString() {
		return "student [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", spassword=" + spassword
				+ ", sgender=" + sgender + ", saddress=" + saddress + ", spercentage=" + spercentage + ", shobbies="
				+ shobbies + "]";
	}

	
}
