package com.saigonbpo.dc.Mapper;

import com.saigonbpo.dc.Model.DcRoleComponent;
import com.saigonbpo.dc.Model.DcRoleComponentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcRoleComponentMapper {
    long countByExample(DcRoleComponentExample example);

    int deleteByExample(DcRoleComponentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcRoleComponent record);

    int insertSelective(DcRoleComponent record);

    List<DcRoleComponent> selectByExample(DcRoleComponentExample example);

    DcRoleComponent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcRoleComponent record, @Param("example") DcRoleComponentExample example);

    int updateByExample(@Param("record") DcRoleComponent record, @Param("example") DcRoleComponentExample example);

    int updateByPrimaryKeySelective(DcRoleComponent record);

    int updateByPrimaryKey(DcRoleComponent record);
}