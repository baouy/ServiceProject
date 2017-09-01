package com.tudou.gen.dao.mapper;

import com.tudou.gen.dao.model.GenTableColumn;
import com.tudou.gen.dao.model.GenTableColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenTableColumnMapper {
    long countByExample(GenTableColumnExample example);

    int deleteByExample(GenTableColumnExample example);

    int deleteByPrimaryKey(String id);

    int insert(GenTableColumn record);

    int insertSelective(GenTableColumn record);

    List<GenTableColumn> selectByExample(GenTableColumnExample example);

    GenTableColumn selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GenTableColumn record, @Param("example") GenTableColumnExample example);

    int updateByExample(@Param("record") GenTableColumn record, @Param("example") GenTableColumnExample example);

    int updateByPrimaryKeySelective(GenTableColumn record);

    int updateByPrimaryKey(GenTableColumn record);
}