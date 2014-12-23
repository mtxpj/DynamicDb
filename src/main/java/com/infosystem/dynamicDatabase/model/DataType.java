package com.infosystem.dynamicDatabase.model;

public enum DataType {
    STRING, // dana typu String
    DATE, // dana typu data
    NUMBER, // dana typu liczbowego
    PREDEFINED_VALUE, // dana typu predefiniowanea wartośc np. pytanie typu
                      // RadioButton
    SUB_SET, // jeden wiersz może zawiera podwiersze (np. kilka zaznaczonych
             // checkboxów, lub dla pytania typu tabela każda kolumna tabeli
             // jest mapowana na jedna kolumane a wiersze tej kolumny stanowia
             // podzbior
}
