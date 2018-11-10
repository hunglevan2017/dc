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
import com.saigonbpo.dc.Mapper.DcMasterdataMapper;
import com.saigonbpo.dc.Mapper.DcProductMapper;
import com.saigonbpo.dc.Model.DcMasterdata;
import com.saigonbpo.dc.Model.DcProduct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/masterdata")
public class MasterRestCtrl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DcMasterdataMapper mapper;

	// Select
	@RequestMapping(value = "/{category}", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<DcMasterdata> selectByPrimaryKey(@PathVariable("category") String category) {
		logger.info(category);
		return mapper.getAllMasterDataByCategory(category);
	}

	/*
	 * 
	 * @RequestMapping(value = "", method = RequestMethod.GET, produces = {
	 * "application/json;charset=UTF-8" }) public String selectByPrimary(){ return
	 * "111"; }
	 */

}
