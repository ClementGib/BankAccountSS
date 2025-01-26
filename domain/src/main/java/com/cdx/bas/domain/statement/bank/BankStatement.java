package com.cdx.bas.domain.statement.bank;

import com.cdx.bas.domain.statement.money.Money;
import com.cdx.bas.domain.statement.type.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankStatement implements Serializable {

    @NotNull
    private long id;

    @NotNull
    private LocalDate date;

    @NotBlank
    @NotNull
    private String label;

    @NotNull
    private Money value;

    @NotNull
    private Type type;
}
