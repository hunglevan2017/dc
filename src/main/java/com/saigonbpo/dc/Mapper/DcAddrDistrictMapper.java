package com.saigonbpo.dc.Mapper;

import com.saigonbpo.dc.Model.DcAddrDistrict;
import com.saigonbpo.dc.Model.DcAddrDistrictExample;
import com.saigonbpo.dc.Model.DcMasterdata;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcAddrDistrictMapper {
    long countByExample(DcAddrDistrictExample example);

    int deleteByExample(DcAddrDistrictExample example);

    int insert(DcAddrDistrict record);

    int insertSelective(DcAddrDistrict record);

    List<DcAddrDistrict> selectByExample(DcAddrDistrictExample example);

    int updateByExampleSelective(@Param("record") DcAddrDistrict record, @Param("example") DcAddrDistrictExample example);

    int updateByExample(@Param("record") DcAddrDistrict record, @Param("example") DcAddrDistrictExample example);

	List<DcAddrDistrict> getDistrictByCityId(long city_id);


}