package com.cdx.bas.domain.report;

import com.cdx.bas.domain.statement.group.BankStatementGroup;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.function.Function;

@Service
public class ProduceBankReportStep implements Function<BankStatementGroup, BankReport>, Serializable {
    @Override
    public BankReport apply(BankStatementGroup bankStatementGroup) {
        return null;
    }
}
