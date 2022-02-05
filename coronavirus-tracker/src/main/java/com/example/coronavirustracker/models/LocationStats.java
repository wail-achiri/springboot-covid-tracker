package com.example.coronavirustracker.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationStats {
    private String estado;
    private String pais;
    private int totalUltimosCasos;
    private int diferenciaDiaAnterior;
}
