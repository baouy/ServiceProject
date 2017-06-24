package com.tudou.oa.dao.mapper;

import com.tudou.oa.dao.model.OaUserDetails;
import com.tudou.oa.dao.model.OaUserDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaUserDetailsMapper {
    long countByExample(OaUserDetailsExample example);

    int deleteByExample(OaUserDetailsExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(OaUserDetails record);

    int insertSelective(OaUserDetails record);

    List<OaUserDetails> selectByExample(OaUserDetailsExample example);

    OaUserDetails selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") OaUserDetails record, @Param("example") OaUserDetailsExample example);

    int updateByExample(@Param("record") OaUserDetails record, @Param("example") OaUserDetailsExample example);

    int updateByPrimaryKeySelective(OaUserDetails record);

    int updateByPrimaryKey(OaUserDetails record);
}