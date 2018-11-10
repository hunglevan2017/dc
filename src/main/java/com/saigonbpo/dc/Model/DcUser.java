package com.saigonbpo.dc.Model;

import java.util.Date;

public class DcUser {
	
	  private long user_id ;
	  private String user_name ;
	  private String user_password ;
	  private long parent_id ;
	  
	  private String channel ;
	  private String province ;
	  private String pos_code ;
	  private String pos_name ;
	  private String company ;
	  private String email ;
	  private String phone ;
	  private String security_key ;
	  private String reg_id ;
	  private boolean  is_android ;
	  
	  private String remark_01 ;
	  private String remark_02 ;
	  private String remark_03 ;
	  private String remark_04 ;
	  
	  private boolean is_pwd_change;
	  private Date last_pwd_change;
	  private Date last_login ;
	  private Date  insert_date;
	  private String  insert_user ;
	  private Date  modify_date;
	  private String  modify_user ;
	  private boolean is_enable;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public long getParent_id() {
		return parent_id;
	}
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPos_code() {
		return pos_code;
	}
	public void setPos_code(String pos_code) {
		this.pos_code = pos_code;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSecurity_key() {
		return security_key;
	}
	public void setSecurity_key(String security_key) {
		this.security_key = security_key;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public boolean isIs_android() {
		return is_android;
	}
	public void setIs_android(boolean is_android) {
		this.is_android = is_android;
	}
	public String getRemark_01() {
		return remark_01;
	}
	public void setRemark_01(String remark_01) {
		this.remark_01 = remark_01;
	}
	public String getRemark_02() {
		return remark_02;
	}
	public void setRemark_02(String remark_02) {
		this.remark_02 = remark_02;
	}
	public String getRemark_03() {
		return remark_03;
	}
	public void setRemark_03(String remark_03) {
		this.remark_03 = remark_03;
	}
	public String getRemark_04() {
		return remark_04;
	}
	public void setRemark_04(String remark_04) {
		this.remark_04 = remark_04;
	}
	public boolean isIs_pwd_change() {
		return is_pwd_change;
	}
	public void setIs_pwd_change(boolean is_pwd_change) {
		this.is_pwd_change = is_pwd_change;
	}
	public Date getLast_pwd_change() {
		return last_pwd_change;
	}
	public void setLast_pwd_change(Date last_pwd_change) {
		this.last_pwd_change = last_pwd_change;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	public String getInsert_user() {
		return insert_user;
	}
	public void setInsert_user(String insert_user) {
		this.insert_user = insert_user;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public boolean isIs_enable() {
		return is_enable;
	}
	public void setIs_enable(boolean is_enable) {
		this.is_enable = is_enable;
	}
	  

}
