/**
 * 美窝云
 * APP服务端
 * 版权所有 2016~ 2017 杭州美窝科技有限公司
 */
package com.tudou.mq.rpc.api;

import com.tudou.mq.dao.model.MqMessage;

/**
 * Created on 2017/9/28.
 *
 * @auther 地瓜
 */
public interface PTPService {
    public void messageTest(MqMessage mqMessage);
}
