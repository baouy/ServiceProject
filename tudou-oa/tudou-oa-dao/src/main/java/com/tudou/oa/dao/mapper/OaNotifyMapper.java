package com.tudou.oa.dao.mapper;

import com.tudou.oa.dao.model.OaNotify;
import com.tudou.oa.dao.model.OaNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaNotifyMapper {
    long countByExample(OaNotifyExample example);

    int deleteByExample(OaNotifyExample example);

    int deleteByPrimaryKey(String id);

    int insert(OaNotify record);

    int insertSelective(OaNotify record);

    List<OaNotify> selectByExample(OaNotifyExample example);

    OaNotify selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OaNotify record, @Param("example") OaNotifyExample example);

    int updateByExample(@Param("record") OaNotify record, @Param("example") OaNotifyExample example);

    int updateByPrimaryKeySelective(OaNotify record);

    int updateByPrimaryKey(OaNotify record);
}