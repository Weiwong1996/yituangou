package com.entity;

import java.util.Date;

/**
 * 订单Orders类
 * 
 * @author Administrator
 *
 */
public class Orders {
	private int oid; // 订单编号
	private Date otime; // 订单时间
	private int gid; // 商品编号
	private String gname; // 商品名
	private String gnowprice; // 商品现价
	private int uid; // 下单用户编号
	private String uname; // 下单用户名
	private String aname; // 下单地址
	
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Orders(int oid, Date otime, int gid, String gname, String gnowprice, int uid, String uname, String aname) {
		super();
		this.oid = oid;
		this.otime = otime;
		this.gid = gid;
		this.gname = gname;
		this.gnowprice = gnowprice;
		this.uid = uid;
		this.uname = uname;
		this.aname = aname;
	}

	public Orders() {
		super();
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", otime=" + otime + ", gid=" + gid + ", gname=" + gname + ", gnowprice="
				+ gnowprice + ", uid=" + uid + ", uname=" + uname + ", aname=" + aname + "]";
	}

}
