package com.cdx.bas.application.scheduler;

import com.cdx.bas.domain.statement.bank.BankStatement;
import com.cdx.bas.domain.statement.processor.StatementProcessor;
import com.cdx.bas.domain.statement.raw.RawStatement;
import com.cdx.bas.domain.workflow.TestBankReportWorkflow;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static com.cdx.bas.application.encoder.EncoderFactory.createEncoder;

@Component
public class StatementProcessorImpl implements StatementProcessor, Serializable {
    Logger logger = LoggerFactory.getLogger(SchedulerImpl.class);

//    SimpleBankReportWorkflow simpleBankReportWorkflow;
    TestBankReportWorkflow simpleBankReportWorkflow;

    private SparkSession spark;
    String filePath = getClass().getClassLoader().getResource("input").getPath();

    @Autowired
    public StatementProcessorImpl(TestBankReportWorkflow simpleBankReportWorkflow) {
        this.simpleBankReportWorkflow = simpleBankReportWorkflow;
        spark = SparkSession.builder()
                .master("local[*]")
                .config("spark.ui.enabled", "false")
                .getOrCreate();
    }

    @Override
    public void process() {
        if(filePath!= null) {
            WindowSpec windowSpec = Window.orderBy("date");
            Dataset<Row> statements = spark.read()
                    .option("delimiter", ";")
                    .option("header", true)
                    .csv(filePath);
            Dataset<RawStatement> rawStatements = statements.withColumn("id", functions.row_number().over(windowSpec))
                            .as(createEncoder(RawStatement.class));
            rawStatements.show();
//            Dataset<BankReport> bankReport = rawStatements.map((MapFunction<RawStatement, BankReport>) (statement) -> simpleBankReportWorkflow.apply(statement), Encoders.bean(BankReport.class));
            Dataset<BankStatement> bankReport = rawStatements.map((MapFunction<RawStatement, BankStatement>) (statement) -> simpleBankReportWorkflow.apply(statement), Encoders.bean(BankStatement.class));
            bankReport.show();
            logger.info("File processed successfully");
        }
    }
}
