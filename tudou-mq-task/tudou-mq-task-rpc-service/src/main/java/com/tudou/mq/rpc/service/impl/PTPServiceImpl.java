/**
 * 美窝云
 * APP服务端
 * 版权所有 2016~ 2017 杭州美窝科技有限公司
 */
package com.tudou.mq.rpc.service.impl;

import com.tudou.mq.dao.model.MqMessage;
import com.tudou.mq.rpc.api.PTPService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;

/**
 * Created on 2017/9/28.
 *
 * @auther 地瓜
 */
public class PTPServiceImpl implements PTPService {

    @Autowired
    private ConnectionFactory factory;

    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;


    public void messageTest(MqMessage mqMessage) {
        try {

            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(mqMessage.getMessageName());
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            TextMessage textMsg = session.createTextMessage(mqMessage.getMessageContent());
            producer.send(textMsg);
            System.out.println("发送消息成功");
            producer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
