package com.entity;
/**
 * 用户Users类
 * @author Administrator
 *
 */
public class Users {
	private int uid; //用户编号
	private String uname; //用户名
	private String upwd; //密码
	private String urealName; //真实姓名
	private String uidentify; //身份证号码
	private String uphone; //用户号码
	public int getUid() {
		return uid;
	}
	public Users(String upwd, String uphone,int uid) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.uphone = uphone;
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
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUrealName() {
		return urealName;
	}
	public void setUrealName(String urealName) {
		this.urealName = urealName;
	}
	public String getUidentify() {
		return uidentify;
	}
	public void setUidentify(String uidentify) {
		this.uidentify = uidentify;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public Users() {
		super();
	}
	public Users(int uid, String uname, String upwd, String urealName, String uidentify, String uphone) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.urealName = urealName;
		this.uidentify = uidentify;
		this.uphone = uphone;
	}
	
	public Users(String uname, String upwd, String urealName, String uidentify, String uphone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.urealName = urealName;
		this.uidentify = uidentify;
		this.uphone = uphone;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", urealName=" + urealName + ", uidentify="
				+ uidentify + ", uphone=" + uphone + "]";
	}
	
}
