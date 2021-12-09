package com.andmal.rc.reactor;

import reactor.core.publisher.Mono;

public class Context {
    public static void main(String[] args) {

        String key = "message";
        Mono<String> r = Mono.just("Hello")
                .flatMap(s -> Mono.deferContextual(ctx ->
                        Mono.just(s + " " + ctx.get(key))))
                .contextWrite(ctx -> ctx.put(key, "World"));

//        StepVerifier.create(r)
//                .expectNext("Hello World")
//                .verifyComplete();
    }
}
