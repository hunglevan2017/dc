package com.saigonbpo.dc.Common;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
	
	public static final String SUCCESS = "success";
	public static final String FAIL = "failure";
	
	public static List<Map<String,Object>> resultSetToArrayList(ResultSet rs) throws SQLException{
		  ResultSetMetaData md = rs.getMetaData();
		  int columns = md.getColumnCount();
		  List<Map<String,Object>> maps = new ArrayList<>();
		  while (rs.next()){
		    // HashMap row = new HashMap(columns);
		     Map<String,Object> row = new HashMap<>();
		     for(int i=1; i<=columns; ++i){           
		      row.put(md.getColumnName(i),rs.getObject(i));
		     }
		     maps.add(row);
		  }

		 return maps;
	}
	
	public static  String getPrefix(String key) {
        switch(key)
        {
            case "tenkhachhang":
                return "Tên KH:";
            case "so_cmnd":
                return "Số CMND:";
            case "ngaycap_cmnd":
                return "Ngày cấp CMND:";
                
            case "noicap_cmnd":
                return "Nơi cấp CMND:";
                
            case "branch_code":
                return "Brand code:";   
                
            case "kenh_giai_ngan":
                return "Kênh giải ngân:";   
                
            case "sotienvay":
                return "Số tiền vay:";   
                
            case "thoihanvay":
                return "Thời hạn vay:";   
                
            case "name_dsa":
                return "Tên DSA:";   
                
            case "code_dsa":
                return "Mã DSA:";   
                
            case "name_tsa":
                return "Tên TSA:";
                
            case "cc_code":
                return "Mã TSA:";
                
            case "cc_name":
                return "Tên CC:";
                
            case "sodienthoai_tsa":
                return "Số ĐT TSA:";
                
            case "date_of_closure":
                return "Date Of Closure:";
                
            case "baohiem_vay":
                return "Bảo hiểm vay:";
                
            case "insurance_plus":
                return "Insurance Plus:";
                
            case "insurance_name":
                return "Insuarance Name:";
                
            case "dia_chi_thuong_tru":
                return "Địa chỉ thường trú:";
                
            case "sdt_thamchieu1":
                return "SĐT tham chiếu 1:";
                
            case "sdt_thamchieu2":
                return "SĐT tham chiếu 2:";
                
            case "thongtin_vochong":
                return "Thông tin vợ chồng:";
                
            case "thunhap_kh_bsung":
                return "Thu nhập KH bổ sung:";
                
            case "chiphi_kh_bsung":
                return "Chi phí KH bổ sung:";
                
            case "sdt_kh_bsung":
                return "SĐT KH bổ sung:";
                
            case "monthly_income_family":
                return "Thu nhập gia đình:";
                
            case "monthly_costs_family":
                return "Chi phí gia đình:";
                
                /*
            case "no_modified_fields":
                return "Số trường thay đổi:";
                
            case "modified_fields":
                return "Trường thay đổi:";
                */
                
            case "description":
                return "Mô tả:";
                
            case "birthday":
                return "Ngày sinh:";
            
            case "delivery_option":
                return "Statement Type:";
            
            case "email_id":
                return "Email Address:";
                
                
                
            default:
            	 return "";
        }

	}

}
