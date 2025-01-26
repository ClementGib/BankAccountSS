package com.cdx.bas.domain.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BankReport implements Serializable {
    private String bankName;
    private long accountId;
    private String ownerName;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
}
