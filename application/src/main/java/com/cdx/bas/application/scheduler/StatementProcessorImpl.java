package com.cdx.bas.application.scheduler;

import com.cdx.bas.bank.statement.processor.StatementProcessor;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StatementProcessorImpl implements StatementProcessor {
    Logger logger = LoggerFactory.getLogger(SchedulerImpl.class);

    private SparkSession spark;
    String filePath = getClass().getClassLoader().getResource("input").getPath();
    public StatementProcessorImpl() {
        spark = SparkSession.builder()
                .master("local[*]")
                .config("spark.ui.enabled", "false")
                .getOrCreate();
    }

    @Override
    public void process() {
        if(filePath!= null) {
            Dataset<Row> statements = spark.read()
                    .option("delimiter", ",")
                    .option("header", true)
                    .csv(filePath);
            statements.show();
            logger.info("File processed successfully");
        }
    }
}
