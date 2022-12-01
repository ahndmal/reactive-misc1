package com.andmal.rc.vertx;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;

public class VertxExe {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        Vertx vertx2 = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        HttpServer server = vertx.createHttpServer();

        HttpClient client = vertx.createHttpClient();
        Future<HttpClientRequest> request = client.request(HttpMethod.GET, "Hello!");
        request.onSuccess(httpClientRequest -> {
            httpClientRequest.send("Hi!");
            httpClientRequest.end();
        });
        request.onComplete(h -> {
            System.out.println(h.result().getURI());
        });
        server.listen(8088, "localhost");

    }
}
