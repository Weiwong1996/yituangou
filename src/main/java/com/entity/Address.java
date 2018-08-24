package com.entity;
/**
 * 地址address类
 * @author Administrator
 *
 */
public class Address {
	  public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	 private int aid; //收货地址编号 
	  private String aaddress; //收货地址
	  private String aname; //用户姓名
	  private String aphone; //用户手机号
	  private String aidentify; //用户身份证号
	  private String amail; //地址邮编
	  private int uid; //用户
	public Address(String aaddress, String aname, String aphone, String aidentify, String amail, int uid) {
		super();
		this.aaddress = aaddress;
		this.aname = aname;
		this.aphone = aphone;
		this.aidentify = aidentify;
		this.amail = amail;
		this.uid = uid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAphone() {
		return aphone;
	}
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}
	public String getAidentify() {
		return aidentify;
	}
	public void setAidentify(String aidentify) {
		this.aidentify = aidentify;
	}
	public String getAmail() {
		return amail;
	}
	public void setAmail(String amail) {
		this.amail = amail;
	}
	public Address() {
		super();
	}
	
	public Address(String aaddress, String aname, String aphone, String aidentify, String amail) {
		super();
		this.aaddress = aaddress;
		this.aname = aname;
		this.aphone = aphone;
		this.aidentify = aidentify;
		this.amail = amail;
	}
	public Address(int aid, String aaddress, String aname, String aphone, String aidentify, String amail) {
		super();
		this.aid = aid;
		this.aaddress = aaddress;
		this.aname = aname;
		this.aphone = aphone;
		this.aidentify = aidentify;
		this.amail = amail;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", aaddress=" + aaddress + ", aname=" + aname + ", aphone=" + aphone
				+ ", aidentify=" + aidentify + ", amail=" + amail + "]";
	}
	  
}
