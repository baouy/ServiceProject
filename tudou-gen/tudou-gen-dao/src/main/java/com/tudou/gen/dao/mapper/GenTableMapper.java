package com.tudou.gen.dao.mapper;

import com.tudou.gen.dao.model.GenTable;
import com.tudou.gen.dao.model.GenTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenTableMapper {
    long countByExample(GenTableExample example);

    int deleteByExample(GenTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(GenTable record);

    int insertSelective(GenTable record);

    List<GenTable> selectByExample(GenTableExample example);

    GenTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GenTable record, @Param("example") GenTableExample example);

    int updateByExample(@Param("record") GenTable record, @Param("example") GenTableExample example);

    int updateByPrimaryKeySelective(GenTable record);

    int updateByPrimaryKey(GenTable record);
}