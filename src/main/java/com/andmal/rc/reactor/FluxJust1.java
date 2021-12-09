package com.andmal.rc.reactor;

import reactor.core.publisher.Flux;

public class FluxJust1 {

    public static void main(String[] args) {

        Flux<String> alphabet = Flux.just(-1, 30, 13, 9, 20)
                .handle((i, sink) -> {
                    String letter = Util.alphabet(i);
                    if (letter != null)
                        sink.next(letter);
                });

        alphabet.subscribe(System.out::println);
    }
}
