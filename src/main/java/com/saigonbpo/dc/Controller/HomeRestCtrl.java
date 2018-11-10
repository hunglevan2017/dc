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
import com.saigonbpo.dc.Mapper.DcProductMapper;
import com.saigonbpo.dc.Model.DcAddrCity;
import com.saigonbpo.dc.Model.DcAddrDistrict;
import com.saigonbpo.dc.Model.DcAddrWard;
import com.saigonbpo.dc.Model.DcMasterdata;
import com.saigonbpo.dc.Model.DcProduct;

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
@RequestMapping(value = "/app")
public class HomeRestCtrl {
	
	public static double getRandomIntegerBetweenRange(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}

	// Log
	Logger logger = LoggerFactory.getLogger(HomeRestCtrl.class);
	
	@Autowired
	DcProductMapper dcProductMapper;
	
	@Autowired
	DcAddrCityMapper cityMapper;
	
	@Autowired
	DcAddrDistrictMapper districtMapper;
	
	@Autowired
	DcAddrWardMapper wardMapper;
	
	
	@RequestMapping(value = "/getContracts", method = {RequestMethod.POST,RequestMethod.GET}, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Map<String, Object>> getEmployeesPOST(@RequestBody Map<String,Object> input) {
		// return appService.getEmployees();
		
		logger.info("input:" + input);
		List<Map<String, Object>> result = new ArrayList<>();

		for(int i=0;i<500;i++)
		{
			Map<String, Object> temp = new HashMap<>();
			temp.put("no", i+1);
			temp.put("id", getRandomIntegerBetweenRange(0,5000) + 1 );
			temp.put("customer_name", "Nguyen Van A " + i);
			temp.put("current_address", "384 Hoàng Diệu, Phường 6, Quận 4, TPHCM");
			temp.put("dc_in_change", "Nguyen Van A");
			temp.put("tsa", "TSA");
			temp.put("status", "Watting Allocate");
			temp.put("pending_tat", "2.1");
	
			result.add(temp);
		}

		return result;
	}
	
	// Select
	@RequestMapping(value = "/getProducts", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<DcProduct> selectByPrimaryKey(){
		return dcProductMapper.getAll();
	}
	

	// Select
	@RequestMapping(value = "api/city", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<DcAddrCity> getCities() {
		return cityMapper.getAll();
	}
	
	@RequestMapping(value = "api/city/{id}/district", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<DcAddrDistrict> getDistricts(@PathVariable("id") long city_id) {
		
		return districtMapper.getDistrictByCityId(city_id);
		
	}
	
	@RequestMapping(value = "api/district/{id}/ward", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public List<DcAddrWard> getWards(@PathVariable("id") long district_id) {

		return wardMapper.getWardByDistrictId(district_id);
	}
	
	


}
