package com.andmal.rc.reactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class FluxTests {

    @Test
    public void tests() {

        Schedulers.enableMetrics();

        Mono<String> hello = Mono.just("hello");
        Assertions.assertEquals("hello", hello.block());

//        Flux. listenToEvents()
//                .doOnNext(event -> log.info("Received {}", event))
//                .delayUntil(this::processEvent)
//                .retry()
//                .subscribe();
    }
}
