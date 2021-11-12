package com.andmal.rc.reactor;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxPara {
    @SneakyThrows
    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel(10)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
                .sequential()
                .subscribe(v -> printThreadName("sub " + v));


        Thread.sleep(5000);

    }
    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
