package com.saigonbpo.dc.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saigonbpo.dc.Common.WebUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginCtrl {
	
	
	
		// Log
		Logger logger = LoggerFactory.getLogger(HomeCtrl.class);
	
	   @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	    public String login(Model model) {
	        return "component/login";
	    }
	   
	   
	   @RequestMapping(value = { "/homepage111"}, method = RequestMethod.GET)
	    public String HomePage(Model model) {
	        
		   //return "component/home";
		   
		  // return "component/customer_validation/CustomerDataValidation";
		  // return "component/customer_validation/ValidateDocument";
		  // return "component/monitoring_dc/HistoryCustomerData";
		   return "component/role_management/role";
		  
	    }
	   
	   @RequestMapping(value = { "/homepage"}, method = RequestMethod.GET)
	    public String HomePage1(Model model) {
		   return "component/home";
	    }
	   
	   
	   
	   
	   /*
	   @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage(Model model) {
	 
	        return "loginPage";
	    }
	    */
	   
	    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	    public String logoutSuccessfulPage(Model model) {
	        model.addAttribute("title", "Logout");
	        return "component/login";
	    }
	 
	    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	    public String userInfo(Model model, Principal principal) {
	 
	        // (1) (en)
	        // After user login successfully.
	        // (vi)
	        // Sau khi user login thanh cong se co principal
	        String userName = principal.getName();
	 
	        System.out.println("User Name: " + userName);
	 
	        User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	        String userInfo = WebUtils.toString(loginedUser);
	        model.addAttribute("userInfo", userInfo);
	 
	        return "userInfoPage";
	    }
	 
	    @RequestMapping(value = "/403", method = RequestMethod.GET)
	    public String accessDenied(Model model, Principal principal) {
	 
	        if (principal != null) {
	            User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	            String userInfo = WebUtils.toString(loginedUser);
	 
	            model.addAttribute("userInfo", userInfo);
	 
	            String message = "Hi " + principal.getName() //
	                    + "<br> You do not have permission to access this page!";
	            
	            logger.warn("user: " + principal.getName() + " >>> has been access denied page");
	            model.addAttribute("message", message);
	 
	        }
	 
	        return "403Page";
	    }
	   
}
