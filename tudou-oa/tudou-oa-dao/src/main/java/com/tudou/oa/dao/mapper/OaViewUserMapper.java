package com.tudou.oa.dao.mapper;

import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OaViewUserMapper {
    long countByExample(OaViewUserExample example);

    int deleteByExample(OaViewUserExample example);

    int insert(OaViewUser record);

    int insertSelective(OaViewUser record);

    List<OaViewUser> selectByExample(OaViewUserExample example);

    int updateByExampleSelective(@Param("record") OaViewUser record, @Param("example") OaViewUserExample example);

    int updateByExample(@Param("record") OaViewUser record, @Param("example") OaViewUserExample example);
}