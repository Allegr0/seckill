package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by kukri on 2018/5/6.
 */

/**
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器
 */

//Spring启东时候，加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件，完成bean的注入
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        successKilledDao.insertSuccessKilled(1000L, 0202022602);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long phone = 02020202;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println("successKilled:" + successKilled);
    }

}