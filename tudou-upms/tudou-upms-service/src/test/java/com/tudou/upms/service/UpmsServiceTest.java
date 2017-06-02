package com.tudou.upms.service;

import com.tudou.common.util.CpUtil;
import com.tudou.upms.dao.model.UpmsSystemExample;
import com.tudou.upms.rpc.api.UpmsSystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml",
        "classpath:applicationContext-dubbo-consumer.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UpmsServiceTest {

    @Autowired
    private UpmsSystemService upmsSystemService;

    @Test
    public void index() {
//        String dest = "/Users/DavidWang/ServiceProject/tudou-upms/tudou-upms-service/src/main/resources/erp";
//        CpUtil.copy(dest,"ServiceProject","/tudou-ui/tudou-erp-web/erp");
//        int count = upmsSystemService.countByExample(new UpmsSystemExample());
//        System.out.println("num-"+count);
    }

}
