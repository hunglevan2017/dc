package com.saigonbpo.dc.Controller;

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

import com.saigonbpo.dc.Common.WebUtils;
import com.saigonbpo.dc.Mapper.DcAddrCityMapper;
import com.saigonbpo.dc.Mapper.DcAddrDistrictMapper;
import com.saigonbpo.dc.Mapper.DcAddrWardMapper;
import com.saigonbpo.dc.Mapper.DcComponentMapper;
import com.saigonbpo.dc.Mapper.DcGroupMapper;
import com.saigonbpo.dc.Mapper.DcProductMapper;
import com.saigonbpo.dc.Mapper.RoleMapper;
import com.saigonbpo.dc.Model.DcAddrCity;
import com.saigonbpo.dc.Model.DcAddrDistrict;
import com.saigonbpo.dc.Model.DcAddrWard;
import com.saigonbpo.dc.Model.DcComponent;
import com.saigonbpo.dc.Model.DcGroup;
import com.saigonbpo.dc.Model.DcMasterdata;
import com.saigonbpo.dc.Model.DcProduct;
import com.saigonbpo.dc.Model.DcRole;

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
@RequestMapping(value = "/group")
public class GroupRestCtrl {

	public static double getRandomIntegerBetweenRange(double min, double max) {
		double x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}

	// Log
	Logger logger = LoggerFactory.getLogger(GroupRestCtrl.class);

	@Autowired
	DcGroupMapper mapper;

	// Select
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<DcGroup> getGroups() {
		return mapper.getAll();
	}



}
