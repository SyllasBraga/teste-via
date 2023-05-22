package org.example;

import org.example.api.ApiConsuming;
import org.example.problema.Carro;
import org.example.problema.PostoGasolina;

import java.net.http.HttpClient;
import java.util.*;

public class Main {
    public static void main(String[] args){

        String URL = "http://localhost:8080/produtos";
        String JSON = "../cmd/src/main/resources/produtos.json";
        HttpClient httpClient = HttpClient.newHttpClient();

        ApiConsuming api = new ApiConsuming(JSON, URL, httpClient);

        api.enviarRequest();

        Carro[] carros = {new Carro("carro1", 10),
                new Carro("carro2", 5), new Carro("carro3", 1),
                new Carro("carro4", 1), new Carro("carro5", 1)};

        Carro[] carrosAbastecidos = PostoGasolina.abastecerCarros(carros, 3);
        System.out.println("\nPosto de gasolina:");
        for (Carro carro: carrosAbastecidos) {
            System.out.println(carro);
        }
    }
}
