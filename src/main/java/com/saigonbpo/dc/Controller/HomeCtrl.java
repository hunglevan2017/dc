package com.saigonbpo.dc.Controller;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.saigonbpo.dc.Common.WebUtils;
import com.saigonbpo.dc.Mapper.DcProductMapper;
import com.saigonbpo.dc.Model.DcProduct;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/app")
public class HomeCtrl {

	
	@Autowired
	DcProductMapper dcProductMapper;
	
	// Log
	Logger logger = LoggerFactory.getLogger(HomeCtrl.class);
	
	Type typeListMap = new TypeToken<List<Map<String, String>>>(){}.getType();
	

	@RequestMapping(value = "/ManualAllocate", method = RequestMethod.GET)
	public ModelAndView manual(Model model, Principal principal) {

		ModelAndView mav = new ModelAndView("component/allocate/ManualAllocate");
		return mav;
	}
	
	
	@RequestMapping(value = { "/AllocateToDC" }, method = RequestMethod.POST)
	public ModelAndView qdeCRC_POST(@RequestParam Map<String, Object> map, Model model, HttpSession session,
			HttpServletRequest request) {


		Gson gson = new Gson();
		List<Map<String,Object>> Contracts = gson.fromJson(map.get("data").toString(),typeListMap);
		
		// Init View Return
		ModelAndView mav = new ModelAndView("component/allocate/AllocateToDC");
		mav.addObject("Contracts", Contracts);
		
		return mav;
	}
	
	@RequestMapping(value = { "/AllocateToDC" }, method = RequestMethod.GET)
	public ModelAndView qdeCRC_GET(Model model, Principal principal) {
		// Init View Return
		ModelAndView mav = new ModelAndView("component/allocate/AllocateToDC");
		return mav;
	}
	
	@RequestMapping(value = { "/CustomerDataValidation" }, method = RequestMethod.GET)
	public ModelAndView CustomerDataValidation(Model model, Principal principal) {
		// Init View Return
		List<DcProduct> products  = dcProductMapper.getAll();
		ModelAndView mav = new ModelAndView("component/customer_validation/CustomerDataValidation");
		mav.addObject("products", products);
		return mav;
	}
	
	@RequestMapping(value = { "/ValidateDocument" }, method = RequestMethod.POST)
	public ModelAndView ValidateDocument(@ModelAttribute(value="data") Map<String,Object> data ) {
		// Init View Return
		
		logger.info("" + data);
		
		List<DcProduct> products  = dcProductMapper.getAll();
		ModelAndView mav = new ModelAndView("component/customer_validation/ValidateDocument");
		mav.addObject("products", products);
		return mav;
	}

	@RequestMapping(value = { "/ValidateDocument" }, method = RequestMethod.GET)
	public ModelAndView ValidateDocument( ) {
		// Init View Return
		ModelAndView mav = new ModelAndView("component/customer_validation/ValidateDocument");
		return mav;
	}
	
	@RequestMapping(value = { "/DcMonitoring" }, method = RequestMethod.GET)
	public ModelAndView DcMonitoring( ) {
		// Init View Return
		ModelAndView mav = new ModelAndView("component/monitoring/HistoryCustomerData");
		return mav;
	}
	

	@RequestMapping(value = "/CustomerDataMonitoring", method = RequestMethod.GET)
	public ModelAndView CustomerDataMonitoring(Model model, Principal principal) {

		ModelAndView mav = new ModelAndView("component/monitoring/CustomerDataMonitoring");
		return mav;
	}
	

}
