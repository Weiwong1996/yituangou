package com.entity;

import java.util.Date;

public class GoodsAndOrders {
	private int oid; //订单编号  
	  private Date otime; //订单时间 
	  private int gid; //商品编号 
	  private String gname; //商品名  
	  private String gnowprice; //商品现价 
	  private String gpicpath; // 商品图片路径 
	  private int aid; //收货地址编号 
	  private String aaddress; //收货地址
	  private String urealName;//下单人姓名
	  private String aname; //收件人姓名
	  private String aphone; //收件人号码
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGnowprice() {
		return gnowprice;
	}
	public void setGnowprice(String gnowprice) {
		this.gnowprice = gnowprice;
	}
	public String getGpicpath() {
		return gpicpath;
	}
	public void setGpicpath(String gpicpath) {
		this.gpicpath = gpicpath;
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
	public String getUrealName() {
		return urealName;
	}
	public void setUrealName(String urealName) {
		this.urealName = urealName;
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
	public GoodsAndOrders() {
		super();
	}
	public GoodsAndOrders(int oid, Date otime, int gid, String gname, String gnowprice, String gpicpath, int aid,
			String aaddress, String urealName, String aname, String aphone) {
		super();
		this.oid = oid;
		this.otime = otime;
		this.gid = gid;
		this.gname = gname;
		this.gnowprice = gnowprice;
		this.gpicpath = gpicpath;
		this.aid = aid;
		this.aaddress = aaddress;
		this.urealName = urealName;
		this.aname = aname;
		this.aphone = aphone;
	}
	public GoodsAndOrders(int oid, Date otime, int gid, String gname, String gnowprice, String gpicpath, int aid,
			String aaddress,String urealName) {
		super();
		this.oid = oid;
		this.otime = otime;
		this.gid = gid;
		this.gname = gname;
		this.gnowprice = gnowprice;
		this.gpicpath = gpicpath;
		this.aid = aid;
		this.aaddress = aaddress;
		this.urealName = urealName;
	}
	public GoodsAndOrders(Date otime, int gid, int aid) {
		super();		
		this.otime = otime;
		this.gid = gid;
		this.aid = aid;
	}
	  
	
}
