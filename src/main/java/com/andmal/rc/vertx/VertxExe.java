package com.andmal.rc.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class VertxExe {
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        Vertx vertx2 = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

    }
}
