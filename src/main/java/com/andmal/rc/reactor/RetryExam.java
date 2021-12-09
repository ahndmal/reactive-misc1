package com.andmal.rc.reactor;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryExam {

    public static void main(String[] args) {

        AtomicInteger errorCount = new AtomicInteger();
        Flux<String> flux =
                Flux.<String>error(new IllegalArgumentException())
                        .doOnError(e -> errorCount.incrementAndGet())
                        .retryWhen(Retry.from(companion ->
                                companion.map(rs -> {
                                    if (rs.totalRetries() < 3) return rs.totalRetries();
                                    else throw Exceptions.propagate(rs.failure());
                                })
                        ));
    }
}
