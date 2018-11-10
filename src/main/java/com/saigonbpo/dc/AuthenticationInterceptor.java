package com.saigonbpo.dc;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;



import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hunglv on 11/07/2017.
 */

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

		Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

	 
	 private boolean isResourceHandler(Object handler)
     {
         return handler instanceof ResourceHttpRequestHandler;
     }
	 

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	if(isResourceHandler(handler))
    		return true;
    
        String uri = request.getRequestURI();
        
        logger.info(uri);

    	/*
        Map<String,Object> loginInfo = (Map<String,Object>) request.getSession().getAttribute("loginInfo");
        
    
        
        	
        		
        if (!uri.endsWith("/login") && !uri.endsWith("/homepage") && !uri.endsWith("/logout") && !uri.endsWith("/forgotPassword")  && !uri.endsWith("/")  && !uri.endsWith("/changePasswordFirstLogin")  && !uri.endsWith("/changePassword") ) {

        	
        	
            if (loginInfo == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            }
            else
            {
            	Date dateExpire = (Date)loginInfo.get("expire_in");
            	
            	//Check expire Data
            	if(dateExpire.before(new Date()))
            	{
            		
            		
            	      response.sendRedirect(request.getContextPath() + "/login");
            	      request.getSession().removeAttribute("loginInfo");
                      return false;
                      
            	}
            	
            	if ( !((boolean)loginInfo.get("is_pwd_changed")) ) 
     	        {
     	        	 response.sendRedirect(request.getContextPath() + "/user/changePasswordFirstLogin");
     	   	      	 //request.getSession().removeAttribute("loginInfo");
     	             return false;
     	        }
            	
            	
            	
            	
            }
        }
        */
        





        return true;

    }


}
