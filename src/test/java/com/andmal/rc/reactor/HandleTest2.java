package com.andmal.rc.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandleTest2 {

    @Test
    void handle2() {
        handle(1,100);
    }

    Flux<Integer> handle(int max, int numberToError) {
        return Flux//
                .range(0, max) // <1>
                .handle((value, sink) -> {
                    var upTo = Stream.iterate(0, i -> i < numberToError, i -> i + 1).collect(Collectors.toList());
                    if (upTo.contains(value)) {
                        sink.next(value);
                        return;
                    }
                    if (value == numberToError) {
                        sink.error(new IllegalArgumentException("No 4 for you!"));
                        return;
                    }
                    sink.complete();
                });
    }
}
