/**
 * 美窝云
 * APP服务端
 * 版权所有 2016~ 2017 杭州美窝科技有限公司
 */
package com.tudo.mq.server.controller;

import com.tudou.common.base.BaseResult;
import com.tudou.mq.dao.model.MqMessage;
import com.tudou.mq.rpc.api.MqMessageService;
import com.tudou.mq.rpc.api.PTPService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created on 2017/9/28.
 *
 * @auther 地瓜
 */
@Controller
@RequestMapping("/mq")
public class MQController {
    @Resource
    private MqMessageService mqMessageService;
    @Resource
    private PTPService ptpService;
    @RequestMapping("index")
    @ResponseBody
    public Object index(){
        MqMessage mqMessage = new MqMessage();
        mqMessage.setMessageName("digua");
        mqMessage.setMessageContent("地瓜在做测试");
        ptpService.messageTest(mqMessage);
        return  new BaseResult(1,"ok",null);
    }

}
