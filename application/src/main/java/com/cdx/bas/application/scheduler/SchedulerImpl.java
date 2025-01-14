package com.cdx.bas.application.scheduler;


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
    String filePath = getClass().getClassLoader().getResource("bs.parquet").getPath();
    Logger logger = LoggerFactory.getLogger(SchedulerImpl.class);

    @Override
    @Scheduled(fixedRate = 10000)
    public void processQueue() {
        logger.info("Scheduler start");
        SparkSession spark = SparkSession.builder()
                .master("local[*]")
                .config("spark.ui.enabled", "false")
                .getOrCreate();
        Dataset<Row> bsDf = spark.read().parquet(filePath);
        bsDf.show();
        logger.info("Scheduler end");
    }
}
