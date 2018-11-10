package com.saigonbpo.dc.Controller;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.saigonbpo.dc.Common.WebUtils;
import com.saigonbpo.dc.Mapper.DcAddrCityMapper;
import com.saigonbpo.dc.Mapper.DcAddrDistrictMapper;
import com.saigonbpo.dc.Mapper.DcAddrWardMapper;
import com.saigonbpo.dc.Mapper.DcComponentMapper;
import com.saigonbpo.dc.Mapper.DcProductMapper;
import com.saigonbpo.dc.Mapper.RoleMapper;
import com.saigonbpo.dc.Model.DcAddrCity;
import com.saigonbpo.dc.Model.DcAddrDistrict;
import com.saigonbpo.dc.Model.DcAddrWard;
import com.saigonbpo.dc.Model.DcComponent;
import com.saigonbpo.dc.Model.DcMasterdata;
import com.saigonbpo.dc.Model.DcProduct;
import com.saigonbpo.dc.Model.DcRole;
import com.saigonbpo.dc.Service.RoleService;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/role")
public class RoleRestCtrl {

	public static double getRandomIntegerBetweenRange(double min, double max) {
		double x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}

	// Log
	Logger logger = LoggerFactory.getLogger(RoleRestCtrl.class);

	
	@Autowired
	RoleMapper mapper;

	@Autowired
	RoleService service;

	@Autowired
	DcComponentMapper dcComponentMapper;

	// List Role For Datatable
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<DcRole> getRoles() {
		return mapper.getRoles();
	}

	// List Access Right
	@RequestMapping(value = "/component", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<DcComponent> getComponents() {
		return dcComponentMapper.getComponents();
	}

	// List Access Right
	@RequestMapping(value = "", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public boolean insert(@RequestBody Map<String,Object> data) {
		try {
			service.insertAccessRight(data);
			return true;
		}
		catch(Exception e) {
			// Log the error somehow\
			e.printStackTrace();
			logger.error(e.toString());
			return false;
		}
	}

}
