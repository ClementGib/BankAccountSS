package com.cdx.bas.domain.statement.group;

import com.cdx.bas.domain.statement.category.Category;
import com.cdx.bas.domain.statement.money.Money;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class BankStatementGroup implements Serializable {

    @NotNull
    Money amount;

    @NotNull
    Category category;

}
