package com.tudou.mq.dao.mapper;

import com.tudou.mq.dao.model.MqMessage;
import com.tudou.mq.dao.model.MqMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MqMessageMapper {
    long countByExample(MqMessageExample example);

    int deleteByExample(MqMessageExample example);

    int deleteByPrimaryKey(Integer messageId);

    int insert(MqMessage record);

    int insertSelective(MqMessage record);

    List<MqMessage> selectByExample(MqMessageExample example);

    MqMessage selectByPrimaryKey(Integer messageId);

    int updateByExampleSelective(@Param("record") MqMessage record, @Param("example") MqMessageExample example);

    int updateByExample(@Param("record") MqMessage record, @Param("example") MqMessageExample example);

    int updateByPrimaryKeySelective(MqMessage record);

    int updateByPrimaryKey(MqMessage record);
}