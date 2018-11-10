package com.saigonbpo.dc.Service.Impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.wstx.util.StringUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.saigonbpo.dc.Common.Constants;
import com.saigonbpo.dc.Mapper.AppMapper;
import com.saigonbpo.dc.Mapper.DcRoleComponentMapper;
import com.saigonbpo.dc.Mapper.RoleMapper;
import com.saigonbpo.dc.Mapper.UserMapper;
import com.saigonbpo.dc.Model.DcComponent;
import com.saigonbpo.dc.Model.DcRole;
import com.saigonbpo.dc.Model.DcRoleComponent;
import com.saigonbpo.dc.Service.AppService;
import com.saigonbpo.dc.Service.RoleService;
import com.saigonbpo.dc.Service.UserService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private DcRoleComponentMapper dcRoleComponentMapper;

	private static final ObjectMapper objectMapper = new ObjectMapper(); // jackson's objectmapper
	private static final Gson gson = new Gson();

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void insertAccessRight(Map<String, Object> InputData) {


			// Parse To 2 Objects

			DcRole dcRole = objectMapper.convertValue(InputData.get("role"), DcRole.class);
			List<Map<String,Object>> dcComponents = gson.fromJson(gson.toJson(InputData.get("component")),
					new TypeToken<List<Map<String, Object>>>(){}.getType()
					);
			//List<DcRoleComponent> dcComponents = Arrays.asList(objectMapper.readValue(InputData.get("component").toString(), DcRoleComponent[].class));
			roleMapper.insert(dcRole);
			//int a = 4/0;

			for (Map<String,Object> dcComponent : dcComponents) {
				DcRoleComponent temp = new DcRoleComponent();
				temp.setRoleId( dcRole.getRole_id() );
				temp.setComponentCode(dcComponent.get("code").toString());
				temp.setPublish((Boolean) dcComponent.get("published"));
				dcRoleComponentMapper.insertSelective(temp);
			}



	}

}
