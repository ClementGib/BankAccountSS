package com.cdx.bas.domain.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BankAccount implements Serializable {
    private String bankName;
    private String ownerName;
    private long id;
}
