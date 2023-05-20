package org.example;

import org.example.api.ApiConsuming;

import java.io.FileNotFoundException;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String URL = "http://localhost:8080/produtos";
        String JSON = "../cmd/src/main/resources/produtos.json";
        HttpClient httpClient = HttpClient.newHttpClient();

        ApiConsuming api = new ApiConsuming(JSON, URL, httpClient);

        api.enviarRequest();


    }
}