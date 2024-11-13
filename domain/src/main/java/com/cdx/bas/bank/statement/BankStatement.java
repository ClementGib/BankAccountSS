package com.cdx.bas.bank.statement;

import com.cdx.bas.bank.statement.money.Money;
import com.cdx.bas.bank.statement.type.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class BankStatement {

    @NotNull
    Date date;

    @NotBlank
    @NotNull
    String label;

    @NotNull
    Money value;

    @NotNull
    Type type;

    public BankStatement(Date date, String label, Money value, Type type) {
        this.date = date;
        this.label = label;
        this.value = value;
        this.type = type;
    }

    public @NotNull Date getDate() {
        return date;
    }

    public void setDate(@NotNull Date date) {
        this.date = date;
    }

    public @NotNull String getLabel() {
        return label;
    }

    public void setLabel(@NotNull String label) {
        this.label = label;
    }

    public @NotNull Money getValue() {
        return value;
    }

    public void setValue(@NotNull Money value) {
        this.value = value;
    }

    public @NotNull Type getType() {
        return type;
    }

    public void setType(@NotNull Type type) {
        this.type = type;
    }
}
