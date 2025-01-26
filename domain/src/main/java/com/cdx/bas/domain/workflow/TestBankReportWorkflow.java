package com.cdx.bas.domain.workflow;

import com.cdx.bas.domain.data.transformation.DataTransformationStep;
import com.cdx.bas.domain.report.BankReport;
import com.cdx.bas.domain.report.ProduceBankReportStep;
import com.cdx.bas.domain.statement.bank.BankStatement;
import com.cdx.bas.domain.statement.group.GroupingStatementStep;
import com.cdx.bas.domain.statement.raw.RawStatement;
import com.cdx.bas.domain.statement.validation.BankStatementValidationStep;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.function.Function;

@Service
public class TestBankReportWorkflow implements Function<RawStatement, BankStatement>, Serializable {
    private final DataTransformationStep dataTransformationStep;
    private final BankStatementValidationStep bankStatementValidationStep;
//    private final GroupingStatementStep groupingStatementStep;
//    private final ProduceBankReportStep produceBankReportStep;

    @Autowired
    public TestBankReportWorkflow(DataTransformationStep dataTransformationStep, BankStatementValidationStep bankStatementValidationStep) {
        this.dataTransformationStep = dataTransformationStep;
        this.bankStatementValidationStep = bankStatementValidationStep;
    }

    protected Function<RawStatement, BankStatement> getSteps() {
        return dataTransformationStep
                .andThen(bankStatementValidationStep);
    }

    @Override
    public BankStatement apply(RawStatement rawStatement) {
        return getSteps().apply(rawStatement);
    }

}
