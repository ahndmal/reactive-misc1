package com.andmal.rc.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpAsync {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://github.com/arriven/db1000n"))
                    .build();
            for (int i = 0; i < 100; i++) {
                CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.get().body());
            }
        } catch(InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }
    }
}
