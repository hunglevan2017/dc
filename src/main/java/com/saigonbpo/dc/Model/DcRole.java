package com.saigonbpo.dc.Model;

import java.util.Date;

public class DcRole {
	
	  private long role_id ;
	  private String role_name ;
	  private boolean  is_enable ;
	  private Date insert_date;
	  private String description ;
	  private int group_id ;
	  
	  
	  
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public boolean isIs_enable() {
		return is_enable;
	}
	public void setIs_enable(boolean is_enable) {
		this.is_enable = is_enable;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	  
}
