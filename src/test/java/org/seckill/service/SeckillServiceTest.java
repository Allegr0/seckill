package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kukri on 2018/5/8.
 */

//Spring启东时候，加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件，完成bean的注入
@ContextConfiguration({"" +
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("list = {}", seckills);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    //集成测试代码完整逻辑，注意可重复执行，注意测试的业务覆盖完整性。
    @Test
    public void seckillLogic() throws Exception {
        long id = 1001L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer = {}", exposer);
            long userPhone = 2131231343L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, userPhone, md5);
                logger.info("result = {}", seckillExecution);
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            }

        }
        else {
            //秒杀未开启
            logger.warn("exposer= {}", exposer);
        }
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1000L;
        long phone = 13680111011L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }
//    @Test
//    public void exportSeckillUrl() throws Exception {
//        long id = 1000L;
//        Exposer exposer = seckillService.exportSeckillUrl(id);
//        logger.info("exposer = {}", exposer);
//    }
//
//    @Test
//    public void executeSeckill() throws Exception {
//        long id = 1000L;
//        long userPhone = 2131231343L;
//        String md5 = "22c7520b823037b5e7fc57cff62a333f";
//        try {
//            SeckillExecution seckillExecution = seckillService.executeSeckill(id, userPhone, md5);
//            logger.info("result = {}", seckillExecution);
//        } catch (SeckillCloseException e) {
//            logger.error(e.getMessage());
//        } catch (RepeatKillException e) {
//            logger.error(e.getMessage());
//        }
//
//    }



}