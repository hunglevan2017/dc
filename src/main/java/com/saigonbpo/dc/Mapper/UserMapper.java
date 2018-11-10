package com.saigonbpo.dc.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.saigonbpo.dc.Model.DcUser;

public interface UserMapper {

	DcUser findByUserName(String username);

	DcUser login(String username, String password);

	void update_password(String username, String newPassword);

	void update_last_login(String username);



}
