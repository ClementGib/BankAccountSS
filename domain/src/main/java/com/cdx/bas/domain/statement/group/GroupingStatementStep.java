package com.cdx.bas.domain.statement.group;

import com.cdx.bas.domain.statement.bank.BankStatement;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.function.Function;

@Service
public class GroupingStatementStep implements Function<BankStatement, BankStatementGroup>, Serializable {
    @Override
    public BankStatementGroup apply(BankStatement bankStatement) {
        return new BankStatementGroup();
    }
}
