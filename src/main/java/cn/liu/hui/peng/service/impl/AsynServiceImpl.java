package cn.liu.hui.peng.service.impl;

import cn.liu.hui.peng.service.AsynService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: 异步服务类
 * @author: hz16092620
 * @create: 2019-03-09 17:05
 */
@Service
public class AsynServiceImpl implements AsynService {

    private static final Logger logger = LoggerFactory.getLogger(AsynServiceImpl.class);

    @Override
    //@Async("asyncServiceExecutor")
    public Date execute() {
        logger.info("start execute");
        try{
            Thread.sleep(10000);
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("end execute");
        return new Date();
    }



}
