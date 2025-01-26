package com.cdx.bas.domain.report;

import com.cdx.bas.domain.data.transformation.DataTransformationStep;
import com.cdx.bas.domain.statement.bank.BankStatement;
import com.cdx.bas.domain.statement.group.GroupingStatementStep;
import com.cdx.bas.domain.statement.raw.RawStatement;
import com.cdx.bas.domain.statement.validation.BankStatementValidationStep;
import com.cdx.bas.domain.workflow.AbstractBankReportWorkflow;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.function.Function;

@Service
public class SimpleBankReportWorkflow extends AbstractBankReportWorkflow implements Serializable {
    private final DataTransformationStep dataTransformationStep;
    private final BankStatementValidationStep bankStatementValidationStep;
    private final GroupingStatementStep groupingStatementStep;
    private final ProduceBankReportStep produceBankReportStep;

    @Autowired
    public SimpleBankReportWorkflow(DataTransformationStep dataTransformationStep, BankStatementValidationStep bankStatementValidationStep, GroupingStatementStep groupingStatementStep, ProduceBankReportStep produceBankReportStep) {
        this.dataTransformationStep = dataTransformationStep;
        this.bankStatementValidationStep = bankStatementValidationStep;
        this.groupingStatementStep = groupingStatementStep;
        this.produceBankReportStep = produceBankReportStep;
    }

    @Override
    protected Function<RawStatement, BankReport> getSteps() {
        return dataTransformationStep
                .andThen(bankStatementValidationStep)
                .andThen(groupingStatementStep)
                .andThen(produceBankReportStep);
    }
}
