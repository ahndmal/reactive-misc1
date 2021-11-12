package com.andmal.rc.reactor;

import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public class MonoMisc {
    public static void main(String[] args) {

        Mono<String> mono = Mono.just("Hello!");
        mono.doOnNext(System.out::println)
                .subscribe();

        Mono<String> mono1 = Mono.fromSupplier(() -> "Hello from Supplier!");
        mono1.doOnNext(System.out::println).subscribe();
    }
}
