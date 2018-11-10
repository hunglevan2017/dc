package com.saigonbpo.dc.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.saigonbpo.dc.Model.CndLoginMobible;
import com.saigonbpo.dc.Model.DcUser;


public interface UserService {

	DcUser findByUserName(String username);
	
	Map<String,Object> login(CndLoginMobible cndLoginMobible);
	void update_last_login (String username);
	void update_password (String username,String NewPassword);
	
}
