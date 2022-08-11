package com.yjq.programmer.config;

import com.yjq.programmer.dao.RentalMapper;
import com.yjq.programmer.domain.Rental;
import com.yjq.programmer.domain.RentalExample;
import com.yjq.programmer.enums.RentalStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2021-04-02 21:20
 */

/**
 * 定时任务
 */
@Configuration
@EnableScheduling  //开启定时任务
public class ScheduleTask {

    @Resource
    private RentalMapper rentalMapper;

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    //@Scheduled(cron = "*/5 * * * * ?") //5s执行一次
    @Scheduled(cron = "0 */5 * * * ?") //5分钟执行一次
    private void configureESTasks() {
        logger.info("开始更新租赁数据....");
        RentalExample rentalExample = new RentalExample();
        // 判断审核通过状态的租赁数据是否在租赁时间内，若在，则修改租赁状态
        Date now = new Date();
        rentalExample.createCriteria()
                .andStateEqualTo(RentalStateEnum.SUCCESS.getCode())
                .andEndTimeGreaterThanOrEqualTo(now)
                .andStartTimeLessThanOrEqualTo(now);
        List<Rental> rentalList = rentalMapper.selectByExample(rentalExample);
        for(Rental rental : rentalList) {
            rental.setState(RentalStateEnum.RENTAL.getCode());
            rentalMapper.updateByPrimaryKeySelective(rental);
        }
        logger.info("更新租赁数据完成....");
    }

}
