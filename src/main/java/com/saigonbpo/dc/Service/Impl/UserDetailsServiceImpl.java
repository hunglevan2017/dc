package com.saigonbpo.dc.Service.Impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saigonbpo.dc.Controller.HomeCtrl;
import com.saigonbpo.dc.Mapper.RoleMapper;
import com.saigonbpo.dc.Mapper.UserMapper;
import com.saigonbpo.dc.Model.DcUser;

 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserMapper userMapper;
 
    @Autowired
    private RoleMapper roleMapper;

	
	// Log
	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        DcUser dcUser = this.userMapper.findByUserName(userName);
 
        if (dcUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + dcUser.getUser_name() );
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<Map<String,Object>> roleNames = roleMapper.getRoleNames( dcUser.getUser_id() );
      
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (Map<String,Object> role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +  role.get("role_name").toString().toUpperCase() );
                grantList.add(authority);
                //Access Button View
                List<String> components =  roleMapper.getComponent( (long) role.get("role_id")  );
                for (String string : components) {
                	   authority = new SimpleGrantedAuthority("ROLE_" +  string.toUpperCase() );
                       grantList.add(authority);
				}
                
            }
        }

        
        logger.info( "" + grantList);
 
        UserDetails userDetails = (UserDetails) new User(dcUser.getUser_name(), //
        		dcUser.getUser_password(), grantList);
 
        return userDetails;
    }
 
}