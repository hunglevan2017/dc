package com.saigonbpo.dc.Mapper;

import com.saigonbpo.dc.Model.DcComponent;
import com.saigonbpo.dc.Model.DcComponentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcComponentMapper {
    long countByExample(DcComponentExample example);

    int deleteByExample(DcComponentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DcComponent record);

    int insertSelective(DcComponent record);

    List<DcComponent> selectByExample(DcComponentExample example);

    DcComponent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DcComponent record, @Param("example") DcComponentExample example);

    int updateByExample(@Param("record") DcComponent record, @Param("example") DcComponentExample example);

    int updateByPrimaryKeySelective(DcComponent record);

    int updateByPrimaryKey(DcComponent record);

	List<DcComponent> getComponents();
}