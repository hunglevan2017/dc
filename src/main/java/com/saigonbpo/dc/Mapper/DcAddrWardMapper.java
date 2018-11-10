package com.saigonbpo.dc.Mapper;

import com.saigonbpo.dc.Model.DcAddrWard;
import com.saigonbpo.dc.Model.DcAddrWardExample;
import com.saigonbpo.dc.Model.DcMasterdata;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcAddrWardMapper {
    long countByExample(DcAddrWardExample example);

    int deleteByExample(DcAddrWardExample example);

    int insert(DcAddrWard record);

    int insertSelective(DcAddrWard record);

    List<DcAddrWard> selectByExample(DcAddrWardExample example);

    int updateByExampleSelective(@Param("record") DcAddrWard record, @Param("example") DcAddrWardExample example);

    int updateByExample(@Param("record") DcAddrWard record, @Param("example") DcAddrWardExample example);

	List<DcAddrWard> getWardByDistrictId(long district_id);
}