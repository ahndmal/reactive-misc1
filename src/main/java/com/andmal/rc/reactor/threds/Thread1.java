package com.andmal.rc.reactor.threds;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Thread1 {

    public static void main(String[] args) throws InterruptedException {

        final Mono<String> mono = Mono.just("hello ");

        Thread t = new Thread(() -> mono.map(msg -> msg + "thread ")
                .subscribe(v ->
                        System.out.println(v + Thread.currentThread().getName())
                )
        );
        t.start();
        t.join();

        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> 10 + i)
                .publishOn(s)
                .map(i -> "value " + i);

        new Thread(() -> flux.subscribe(System.out::println));

        Flux.interval(Duration.ofMillis(300), Schedulers.newSingle("test")).doOnNext(System.out::println).subscribe();

    }
}
