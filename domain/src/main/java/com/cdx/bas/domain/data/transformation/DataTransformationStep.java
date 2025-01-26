package com.cdx.bas.domain.data.transformation;

import com.cdx.bas.domain.statement.bank.BankStatement;
import com.cdx.bas.domain.statement.money.Money;
import com.cdx.bas.domain.statement.raw.RawStatement;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

@Service
public class DataTransformationStep implements Function<RawStatement, BankStatement>, Serializable {
    @Override
    public BankStatement apply(RawStatement rawStatement) {
        LocalDate localDate = LocalDate.parse(rawStatement.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new BankStatement(rawStatement.getId(), localDate, rawStatement.getLabel(), Money.of(new BigDecimal(rawStatement.getValue())), rawStatement.getType());
    }
}
