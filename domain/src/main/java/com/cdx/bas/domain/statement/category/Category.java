package com.cdx.bas.domain.statement.category;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Category {
    private final String name;
    private final CategoryType type;

    private Category(String name, CategoryType type) {
        this.name = name;
        this.type = type;
    }

    public static Category income(String name) {
        return new Category(name, CategoryType.INCOME);
    }

    public static Category expense(String name) {
        return new Category(name, CategoryType.EXPENSE);
    }
}
