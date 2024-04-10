# 🌟 Conversor de Moneda WRH3 🌟

¡Bienvenido al Conversor de Moneda WRH3! Este programa te permite convertir entre diferentes monedas de una manera rápida y sencilla utilizando la API ExchageRate.

## 🚀 Instalación

1. Clona este repositorio en tu máquina local:
   git clone https://github.com/tu_usuario/conversor-moneda-wrh3.git

2. Abre el proyecto en tu IDE Preferido
3. Asegurate de tener Java instalado en tu sistema

## 💼 Uso
Este proyecto unicamnete tiene como finalidad aprovar el Challenge Conversor de Monedas
por lo que las funcionalidad son muy limitadas.

## 📁 Estructura del Proyecto
El proyecto contiene dos package que son:
1. com.aluracursos.conversoralura.modelo
este package contine las clases:
<ol type="I">
  <li>Moneda</li>
  <li>Cliente</li>
</ol>
Moneda es un record que nos facilita trabajar con las variables que vamos a utilizar para este caso:

````java
public record Moneda(String result,
String base_code,
String target_code,
double conversion_rate,
double conversion_result) {
}
````
La clase Cliente se encarga de realizar la peticion a la api y trabajar con el json d ela respuesta para despues manejar los datos y poder obtener la tasa de cambio
````java
package com.aluracursos.coversoralura.modelo;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente {
    private double radioCoversion;

    public Moneda solicitarDato(String monedaBase, String monedaDestino, double cantidad){
        String direccion = "https://v6.exchangerate-api.com/v6/dd28bd449b4b6aae1700ddbb/pair/"
                + monedaBase + "/" + monedaDestino + "/" + cantidad;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String>response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new Gson();
            Moneda miMmoneda = gson.fromJson(json, Moneda.class);
            System.out.println(miMmoneda);
            this.radioCoversion = miMmoneda.conversion_rate();
            return miMmoneda;
        } catch (Exception e) {
            throw new RuntimeException("No se encontro datos");
        }
    }

    public Double convertir(double cantidad){
        return cantidad * this.radioCoversion;
    }
}
````
Notemos que hicimos uso de la biblioteca Gson

2. com.aluracursos.conversoralura.principal este package contine las clases:
<ol type="I">
  <li>Principal </li>
  <li>Menu</li>
</ol>

Notemos que en la clase Menu solo tenemos la impresion en pantalla de nuestro menu d eopciones para qeu el usuario pueda interactuar con nuestra aplicacion:
````java
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
````
Finalmente en la clase Principal tenemos la logica para el funcionameinto de nuestro programa.
````java
package com.aluracursos.conversoralura.principal;

import com.aluracursos.coversoralura.modelo.Cliente;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Menu menu = new Menu();
        int opcion = 0;
        double cantidad;
        double resultado;

        while(opcion != 7){
            menu.crearMenu();
            try{
                opcion = Integer.valueOf(entrada.next());
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la cantidad que desea convertir:");
                        cantidad = Double.valueOf(entrada.next());
                        cliente.solicitarDato("USD", "ARS", cantidad);
                        resultado = cliente.convertir(cantidad);
                        System.out.println(String.format("El valor %.2f [USD] corresponde al valor final de ==> %.2f [ARS]",
                                cantidad, resultado ));
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad que desea convertir:");
                        cantidad = Double.valueOf(entrada.next());
                        cliente.solicitarDato("ARS", "USD", cantidad);
                        resultado = cliente.convertir(cantidad);
                        System.out.println(String.format("El valor %.2f [ARS] corresponde al valor final de ==> %.2f [USD]",
                                cantidad, resultado ));
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad que desea convertir:");
                        cantidad = Double.valueOf(entrada.next());
                        cliente.solicitarDato("USD", "BRL", cantidad);
                        resultado = cliente.convertir(cantidad);
                        System.out.println(String.format("El valor %.2f [USD] corresponde al valor final de ==> %.2f [BRL]",
                                cantidad, resultado ));
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad que desea convertir:");
                        cantidad = Double.valueOf(entrada.next());
                        cliente.solicitarDato("BRL", "USD", cantidad);
                        resultado = cliente.convertir(cantidad);
                        System.out.println(String.format("El valor %.2f [BRL] corresponde al valor final de ==> %.2f [USD]",
                                cantidad, resultado ));
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad que desea convertir:");
                        cantidad = Double.valueOf(entrada.next());
                        cliente.solicitarDato("USD", "COP", cantidad);
                        resultado = cliente.convertir(cantidad);
                        System.out.println(String.format("El valor %.2f [USD] corresponde al valor final de ==> %.2f [COP]",
                                cantidad, resultado ));
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad que desea convertir:");
                        cantidad = Double.valueOf(entrada.next());
                        cliente.solicitarDato("COP", "USD", cantidad);
                        resultado = cliente.convertir(cantidad);
                        System.out.println(String.format("El valor %.2f [COP] corresponde al valor final de ==> %.2f [USD]",
                                cantidad, resultado ));
                        break;
                    case 7:
                        System.out.println("Finalizando Programa...");
                        System.out.println("Programa finalizado con exito!");
                        break;
                    default:
                        System.out.println("opcion invalida!");
                }
            }catch(NumberFormatException e){
                System.out.println("Formato de numero invalido " + e.getMessage());
            }catch(Exception e){
                System.out.println("Finalizando aplicacion, error inesperado: " + e.getMessage());
            }
        }
    }
}
````
Notemos que la logica es muy sencilla primero pedimos al usuario qeu seleccione una opcion del menu de donde tomamos los primeros dos parametros qeu necesitamos:
<ul type="I">
  <li>Moneda Base </li>
  <li>Moneda Destino</li>
</ul>
despues pedimos al usaurio que ingrese la cantidad a convertir, aqui de acuerdo a los dos parametros de entrada anterior y a la cantidad qeu introduzca se crea la url de consulta para la api que nso devuelve 
el conversion_rate con el cual calculamos el resultado de la conversion.

## ✅ Tecnologías Utilizadas
- Java 🔧

## 🌟 Funcionalidades
- Conversión de monedas 🛠️
- Interfaz de usuario amigable 🛠️
- Integración con API ExchageRate 🛠️


## 🤝 Contribución
mis profesores de Alura Latam que me han ensañado mucho y siempre muy profesionales.

## 📝 Licencia

Este proyecto está bajo la licencia MIT.

¡Gracias por utilizar el Conversor de Moneda WRH3! Espero que te sea útil y que tengas una excelente experiencia convirtiendo monedas. ¡Feliz conversión! 🚀✨

## Autores

1. Walberto Roblero Hernandez
