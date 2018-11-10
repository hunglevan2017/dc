package com.saigonbpo.dc.Mapper;

import com.saigonbpo.dc.Model.DcAddrCity;
import com.saigonbpo.dc.Model.DcAddrCityExample;
import com.saigonbpo.dc.Model.DcMasterdata;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcAddrCityMapper {
    long countByExample(DcAddrCityExample example);

    int deleteByExample(DcAddrCityExample example);

    int insert(DcAddrCity record);

    int insertSelective(DcAddrCity record);

    List<DcAddrCity> selectByExample(DcAddrCityExample example);

    int updateByExampleSelective(@Param("record") DcAddrCity record, @Param("example") DcAddrCityExample example);

    int updateByExample(@Param("record") DcAddrCity record, @Param("example") DcAddrCityExample example);

	List<DcAddrCity> getAll();
}