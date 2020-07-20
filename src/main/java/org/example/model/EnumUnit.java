package org.example.model;

public enum EnumUnit {
    гр("гр"),
    пч("пч"),
    шт("шт");

    String description;

    EnumUnit( String description) {
        this.description = description;
    }
}


//установить костуктор

//грамм, пучок, штука
