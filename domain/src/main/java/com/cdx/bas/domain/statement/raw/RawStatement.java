package com.cdx.bas.domain.statement.raw;

import com.cdx.bas.domain.statement.money.Money;
import com.cdx.bas.domain.statement.type.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawStatement implements Serializable {
    @NotNull
    private long id;

    @NotNull
    private String date;

    @NotBlank
    @NotNull
    private String label;

    @NotNull
    private String value;

    @NotNull
    private Type type;
}
