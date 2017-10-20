package com.tudou.gen.dao.mapper;

import com.tudou.gen.dao.model.GenScheme;
import com.tudou.gen.dao.model.GenSchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenSchemeMapper {
    long countByExample(GenSchemeExample example);

    int deleteByExample(GenSchemeExample example);

    int deleteByPrimaryKey(String id);

    int insert(GenScheme record);

    int insertSelective(GenScheme record);

    List<GenScheme> selectByExample(GenSchemeExample example);

    GenScheme selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GenScheme record, @Param("example") GenSchemeExample example);

    int updateByExample(@Param("record") GenScheme record, @Param("example") GenSchemeExample example);

    int updateByPrimaryKeySelective(GenScheme record);

    int updateByPrimaryKey(GenScheme record);
}