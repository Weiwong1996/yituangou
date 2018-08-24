package com.entity;
/**
 * 广告advertisement类
 * @author Administrator
 *
 */
public class Advertisement {
	  private int adid; //广告编号 
	  private String adname; //广告名称
	  private String adpicpath; //广告图片路径 
	public int getAdid() {
		return adid;
	}
	public void setAdid(int adid) {
		this.adid = adid;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getAdpicpath() {
		return adpicpath;
	}
	public void setAdpicpath(String adpicpath) {
		this.adpicpath = adpicpath;
	}
	public Advertisement() {
		super();
	}
	public Advertisement(int adid, String adname, String adpicpath) {
		super();
		this.adid = adid;
		this.adname = adname;
		this.adpicpath = adpicpath;
	}
	@Override
	public String toString() {
		return "Advertisement [adid=" + adid + ", adname=" + adname + ", adpicpath=" + adpicpath + "]";
	}
	  
}
