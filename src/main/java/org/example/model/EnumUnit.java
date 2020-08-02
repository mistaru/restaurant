package org.example.model;

public enum EnumUnit {
    гр("грамм"),
    пч("пучок"),
    шт("штук");

    String description;

    EnumUnit(String description) {
        this.description = description;
    }
}