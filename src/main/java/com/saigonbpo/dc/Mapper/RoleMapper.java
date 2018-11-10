package com.saigonbpo.dc.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.saigonbpo.dc.Model.DcComponent;
import com.saigonbpo.dc.Model.DcRole;

public interface RoleMapper {

	List<Map<String,Object>> getRoleNames(long user_id);

	List<String> getComponent(long role_id);

	List<DcRole> getRoles();

	List<DcComponent> getComponents();

	void insert(DcRole dcRole);







}
