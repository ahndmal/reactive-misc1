package com.andmal.rc.reactor;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxRepeat {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        getIntegers()
                .repeat(() -> atomicInteger.get() < 14)
                .subscribe();
    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> atomicInteger.getAndIncrement());
    }
}
