package com.aluracursos.coversoralura.modelo;

public record Moneda(String result,
                     String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {
}
