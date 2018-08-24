package com.entity;
/**
 * 商品Goods类
 * @author Administrator
 *
 */
public class Goods {
	private int gid;//商品编号
	private String gname; //商品名 
	private String gpicpath; // 商品图片路径 
	private String gtime; //   商品团购结束时间  
	private int goriprice; // 商品原价  
	private int gnowprice; // 商品现价 
	private String gdiscount; // 商品折扣
	private String gbrand; //商品品牌
	private int gattention; // 参团人数 
	private String gtype; //商品类型
	public Goods(String gname, String gpicpath, String gtime, int goriprice, int gnowprice, String gdiscount,
			String gbrand, String gtype) {
		super();
		this.gname = gname;
		this.gpicpath = gpicpath;
		this.gtime = gtime;
		this.goriprice = goriprice;
		this.gnowprice = gnowprice;
		this.gdiscount = gdiscount;
		this.gbrand = gbrand;
		this.gtype = gtype;
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
	public String getGpicpath() {
		return gpicpath;
	}
	public void setGpicpath(String gpicpath) {
		this.gpicpath = gpicpath;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
	}
	public int getGoriprice() {
		return goriprice;
	}
	public void setGoriprice(int goriprice) {
		this.goriprice = goriprice;
	}
	public int getGnowprice() {
		return gnowprice;
	}
	public void setGnowprice(int gnowprice) {
		this.gnowprice = gnowprice;
	}
	public String getGdiscount() {
		return gdiscount;
	}
	public void setGdiscount(String gdiscount) {
		this.gdiscount = gdiscount;
	}
	public String getGbrand() {
		return gbrand;
	}
	public void setGbrand(String gbrand) {
		this.gbrand = gbrand;
	}
	public int getGattention() {
		return gattention;
	}
	public void setGattention(int gattention) {
		this.gattention = gattention;
	}
	public String getGtype() {
		return gtype;
	}
	public void setGtype(String gtype) {
		this.gtype = gtype;
	}
	public Goods() {
		super();
	}
	public Goods(int gid, String gname, String gpicpath, String gtime, int goriprice, int gnowprice,
			String gdiscount, String gbrand, int gattention, String gtype) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gpicpath = gpicpath;
		this.gtime = gtime;
		this.goriprice = goriprice;
		this.gnowprice = gnowprice;
		this.gdiscount = gdiscount;
		this.gbrand = gbrand;
		this.gattention = gattention;
		this.gtype = gtype;
	}	
	public Goods(String gname, String gpicpath, String gtime, int goriprice, int gnowprice, String gdiscount,
			String gbrand, int gattention, String gtype) {
		super();
		this.gname = gname;
		this.gpicpath = gpicpath;
		this.gtime = gtime;
		this.goriprice = goriprice;
		this.gnowprice = gnowprice;
		this.gdiscount = gdiscount;
		this.gbrand = gbrand;
		this.gattention = gattention;
		this.gtype = gtype;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gpicpath=" + gpicpath + ", gtime=" + gtime + ", goriprice="
				+ goriprice + ", gnowprice=" + gnowprice + ", gdiscount=" + gdiscount + ", gbrand=" + gbrand
				+ ", gattention=" + gattention + ", gtype=" + gtype + "]";
	}
	
}
