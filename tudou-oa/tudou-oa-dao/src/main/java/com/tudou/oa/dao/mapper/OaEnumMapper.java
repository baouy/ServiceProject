package com.tudou.oa.dao.mapper;

import com.tudou.oa.dao.model.OaEnum;
import com.tudou.oa.dao.model.OaEnumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaEnumMapper {
    long countByExample(OaEnumExample example);

    int deleteByExample(OaEnumExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(OaEnum record);

    int insertSelective(OaEnum record);

    List<OaEnum> selectByExample(OaEnumExample example);

    OaEnum selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") OaEnum record, @Param("example") OaEnumExample example);

    int updateByExample(@Param("record") OaEnum record, @Param("example") OaEnumExample example);

    int updateByPrimaryKeySelective(OaEnum record);

    int updateByPrimaryKey(OaEnum record);
}