package com.saigonbpo.dc.Service.Impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.wstx.util.StringUtil;
import com.saigonbpo.dc.Common.Constants;
import com.saigonbpo.dc.Mapper.AppMapper;
import com.saigonbpo.dc.Mapper.UserMapper;
import com.saigonbpo.dc.Model.CndLoginMobible;
import com.saigonbpo.dc.Model.DcUser;
import com.saigonbpo.dc.Service.AppService;
import com.saigonbpo.dc.Service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	


	@Override
	public DcUser findByUserName(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUserName(username);
	}


	boolean isEmptyValue( String value  )
	{
		if( "".equals(value) )
			return true;
		return false;
	}

	@Override
	public Map<String, Object> login( CndLoginMobible cndLoginMobible ) {
		// TODO Auto-generated method stub
		Map<String,Object> output =  new HashMap<>();
		output.put("status", Constants.FAIL);
		
		//Check data input
		if( isEmptyValue(cndLoginMobible.getUsername()) ||  isEmptyValue(cndLoginMobible.getPasword()) || isEmptyValue(cndLoginMobible.getPasword()) )
		{
			output.put("message", "Data invalid");
			return output;
		}
		
		/*
		//Check account is android
		try
		{
			DcUser dcUser = userMapper.login(username,password);
			if(dcUser!=null) {
				output.put("data", dcUser);
				update_last_login(username);
			}
			else
			{
				output.put("status", Constants.FAIL);
				output.put("message", "Password invalid" );
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error(e.toString());
		}*/
		return null;
	}




	@Override
	public void update_last_login(String username) {
		// TODO Auto-generated method stub
		 userMapper.update_last_login(username);
	}

	@Override
	public void update_password(String username, String NewPassword) {
		// TODO Auto-generated method stub
		userMapper.update_password(username,NewPassword);
	}
	
	

	

}
