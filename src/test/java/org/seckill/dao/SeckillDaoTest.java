package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

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
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0,100);
        for (Seckill s : seckillList) {
            System.out.println(s);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateNumber = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateNumber = " + updateNumber);

    }



}