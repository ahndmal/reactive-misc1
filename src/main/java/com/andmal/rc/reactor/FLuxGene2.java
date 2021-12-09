package com.andmal.rc.reactor;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

public class FLuxGene2 {
    public static void main(String[] args) {

        // Synchronous Flux.generate

        Flux<String> flux = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) sink.complete();
                    return state;
                });

        Flux<String> flux2 = Flux.generate(
                () -> 0,    //    AtomicLong::new,
                (state, sink) -> {
                    System.out.println("3 x " + state + " = " + 3*state);
                    sink.next("3 x " + state + " = " + 3*state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        flux2.subscribe();

        Flux<String> fluxConsumer = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.out.println("state: " + state));





    }
}
