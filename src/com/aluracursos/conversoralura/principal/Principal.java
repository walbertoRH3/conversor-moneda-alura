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
