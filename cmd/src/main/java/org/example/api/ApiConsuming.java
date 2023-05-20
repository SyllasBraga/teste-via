package org.example.api;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class ApiConsuming {

    private final String fileJson;
    private final String urlPost;
    private final HttpClient httpClient;

    public ApiConsuming(String fileJson, String urlPost, HttpClient httpClient) {
        this.fileJson = fileJson;
        this.urlPost = urlPost;
        this.httpClient = httpClient;
    }

    private HttpRequest criarRequest() throws FileNotFoundException {

        return HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(fileJson)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(urlPost))
                .setHeader("Content-Type", "application/json")
                .build();
    }

    public void enviarRequest() throws FileNotFoundException {

        HttpRequest request = criarRequest();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
