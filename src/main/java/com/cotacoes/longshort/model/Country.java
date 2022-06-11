package com.cotacoes.longshort.model;

import java.util.stream.Stream;

public enum Country {
    BRAZIL("BR"),
    USA("US");

    private String sigla;

    Country(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return this.sigla;
    }

    public static Country getCountry(String country) {
        System.out.println(country);
        Country matchedCountry = Stream.of(values())
                .filter(thisCountry -> thisCountry.getSigla().equalsIgnoreCase(country))
                .findFirst().orElseThrow(() -> {
                    return new RuntimeException("erro");
                });
        return matchedCountry;
    }
}
