package com.cdx.bas.application.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SchedulerImpl implements Scheduler {

    Logger logger = LoggerFactory.getLogger(SchedulerImpl.class);

    public static void main(String[] args) {
        SpringApplication.run(SchedulerImpl.class, args);
    }

    @Override
    @Scheduled(fixedRate = 5000)
    public void processQueue() {
        logger.info("Scheduler start");


        logger.info("Scheduler end");
    }
}
