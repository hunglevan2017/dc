package com.saigonbpo.dc.Mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.saigonbpo.dc.Model.DcMasterdata;
import com.saigonbpo.dc.Model.DcProduct;
import com.saigonbpo.dc.Model.DcProductExample;



public interface DcProductMapper {
    long countByExample(DcProductExample example);

    int deleteByExample(DcProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DcProduct record);

    int insertSelective(DcProduct record);

    List<DcProduct> selectByExample(DcProductExample example);

    DcProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DcProduct record, @Param("example") DcProductExample example);

    int updateByExample(@Param("record") DcProduct record, @Param("example") DcProductExample example);

    int updateByPrimaryKeySelective(DcProduct record);

    int updateByPrimaryKey(DcProduct record);
    
    List<DcProduct> getAll();


}