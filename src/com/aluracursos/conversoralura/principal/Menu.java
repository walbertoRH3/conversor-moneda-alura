package com.aluracursos.conversoralura.principal;

public class Menu {
    public void crearMenu(){
        String menu = """
                **********************************************************
                Sea bienvenido/a al Conversor de Moneda WRH3 =]
                
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Salir
                Elija una opcion valida:
                ***********************************************************              
                """;
        System.out.println(menu);
    }
}
