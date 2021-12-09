package com.andmal.rc.reactor;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SinksFluxTest {

    @Test
    void sinks() {

        SinksFlux.sinks();

        Flux<String> source = Flux.just("thing1", "thing2");

        StepVerifier.withVirtualTime(() -> Mono.delay(Duration.ofDays(1)));

        StepVerifier.withVirtualTime(() -> Mono.delay(Duration.ofDays(1)))
                .expectSubscription()
                .expectNoEvent(Duration.ofDays(1))
                .expectNext(0L)
                .verifyComplete();

//        verifyThenAssertThat();

//        StepVerifier.create(
//                        appendBoomError(source))
//                .expectNext("thing1")
//                .expectNext("thing2")
//                .expectErrorMessage("boom")
//                .verify();
    }

    private Object appendBoomError(Flux<String> source) {
        Publisher publisher = (e) -> System.out.println();
        return publisher;
    }
}