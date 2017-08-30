package com.tudou.oa.dao.mapper;

import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.dao.model.OaLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaLeaveMapper {
    long countByExample(OaLeaveExample example);

    int deleteByExample(OaLeaveExample example);

    int deleteByPrimaryKey(String id);

    int insert(OaLeave record);

    int insertSelective(OaLeave record);

    List<OaLeave> selectByExample(OaLeaveExample example);

    OaLeave selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OaLeave record, @Param("example") OaLeaveExample example);

    int updateByExample(@Param("record") OaLeave record, @Param("example") OaLeaveExample example);

    int updateByPrimaryKeySelective(OaLeave record);

    int updateByPrimaryKey(OaLeave record);
}