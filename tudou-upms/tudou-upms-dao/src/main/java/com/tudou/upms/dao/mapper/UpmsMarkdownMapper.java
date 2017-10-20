package com.tudou.upms.dao.mapper;

import com.tudou.upms.dao.model.UpmsMarkdown;
import com.tudou.upms.dao.model.UpmsMarkdownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsMarkdownMapper {
    long countByExample(UpmsMarkdownExample example);

    int deleteByExample(UpmsMarkdownExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(UpmsMarkdown record);

    int insertSelective(UpmsMarkdown record);

    List<UpmsMarkdown> selectByExampleWithBLOBs(UpmsMarkdownExample example);

    List<UpmsMarkdown> selectByExample(UpmsMarkdownExample example);

    UpmsMarkdown selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("record") UpmsMarkdown record, @Param("example") UpmsMarkdownExample example);

    int updateByExampleWithBLOBs(@Param("record") UpmsMarkdown record, @Param("example") UpmsMarkdownExample example);

    int updateByExample(@Param("record") UpmsMarkdown record, @Param("example") UpmsMarkdownExample example);

    int updateByPrimaryKeySelective(UpmsMarkdown record);

    int updateByPrimaryKeyWithBLOBs(UpmsMarkdown record);

    int updateByPrimaryKey(UpmsMarkdown record);
}