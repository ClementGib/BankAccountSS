package com.cdx.bas.domain.statement.validation;

import com.cdx.bas.domain.statement.bank.BankStatement;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.function.UnaryOperator;

@Service
public class BankStatementValidationStep implements UnaryOperator<BankStatement>, Serializable {
    @Override
    public BankStatement apply(BankStatement bankStatement) {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<BankStatement>> violations = validator.validate(bankStatement);

            if (!violations.isEmpty()) {
                System.out.println("Bank statement " + bankStatement.getLabel() + " violated validation errors: " + violations);
            } else {
                return bankStatement;
            }
            return bankStatement;
        }
    }
}
