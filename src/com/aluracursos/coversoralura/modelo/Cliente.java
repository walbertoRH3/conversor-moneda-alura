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
