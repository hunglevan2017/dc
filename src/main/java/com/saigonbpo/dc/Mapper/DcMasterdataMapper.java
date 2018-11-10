package com.saigonbpo.dc.Mapper;

import com.saigonbpo.dc.Model.DcMasterdata;
import com.saigonbpo.dc.Model.DcMasterdataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcMasterdataMapper {
    long countByExample(DcMasterdataExample example);

    int deleteByExample(DcMasterdataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DcMasterdata record);

    int insertSelective(DcMasterdata record);

    List<DcMasterdata> selectByExample(DcMasterdataExample example);

    DcMasterdata selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DcMasterdata record, @Param("example") DcMasterdataExample example);

    int updateByExample(@Param("record") DcMasterdata record, @Param("example") DcMasterdataExample example);

    int updateByPrimaryKeySelective(DcMasterdata record);

    int updateByPrimaryKey(DcMasterdata record);
	List<DcMasterdata> getAllMasterDataByCategory(String category);
}