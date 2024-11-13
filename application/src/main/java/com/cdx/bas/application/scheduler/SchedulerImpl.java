package com.cdx.bas.application.scheduler;


import com.cdx.bas.bank.statement.processor.StatementProcessor;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.Serializable;

@Configuration
@EnableScheduling
public class SchedulerImpl implements Scheduler, Serializable {
    Logger logger = LoggerFactory.getLogger(SchedulerImpl.class);

    StatementProcessor statementProcessor;

    public SchedulerImpl(StatementProcessor statementProcessor) {
        this.statementProcessor = statementProcessor;
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void processQueue() {
        logger.info("Scheduler start");
        statementProcessor.process();
        logger.info("Scheduler end");
    }
}
