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
@RequestMapping(value = "/role")
public class RoleCtrl {

	
	@Autowired
	DcProductMapper dcProductMapper;
	
	// Log
	Logger logger = LoggerFactory.getLogger(RoleCtrl.class);
	
	Type typeListMap = new TypeToken<List<Map<String, String>>>(){}.getType();
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView manual(Model model, Principal principal) {

		ModelAndView mav = new ModelAndView("component/role_management/role");
		return mav;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addRole(Model model, Principal principal) {

		ModelAndView mav = new ModelAndView("component/role_management/role_add");
		return mav;
	}
	
	

}
