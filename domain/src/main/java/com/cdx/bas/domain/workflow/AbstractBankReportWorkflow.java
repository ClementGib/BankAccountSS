package com.cdx.bas.domain.workflow;

import com.cdx.bas.domain.report.BankReport;
import com.cdx.bas.domain.statement.bank.BankStatement;
import com.cdx.bas.domain.statement.raw.RawStatement;

import java.io.Serializable;
import java.util.function.Function;

public abstract class AbstractBankReportWorkflow implements Function<RawStatement, BankReport>, Serializable {
    @Override
    public BankReport apply(RawStatement rawStatement) {
        return getSteps().apply(rawStatement);
    }

    protected abstract Function<RawStatement, BankReport> getSteps();
}
