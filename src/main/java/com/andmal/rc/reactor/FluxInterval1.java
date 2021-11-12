package com.andmal.rc.reactor;

import org.reactivestreams.Subscriber;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval1 {
    public static void main(String[] args) {

        Flux.just("1", "2", "4")
                .delayElements(Duration.ofSeconds(3))
//                .interval(Duration.ofSeconds(1), Duration.ofSeconds(3))
                .flatMap(e -> Subscriber::onComplete)
                .doOnNext(System.out::println)
                .doOnEach(System.out::println)

                .subscribe();

    }
}
