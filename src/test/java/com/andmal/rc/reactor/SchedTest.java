package com.andmal.rc.reactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class SchedTest {
    Logger log = LoggerFactory.getLogger(SchedTest.class);

    @Test
    public void onScheduleHook() {
        var counter = new AtomicInteger();
        Schedulers.onScheduleHook("my hook", runnable -> () -> {
            var threadName = Thread.currentThread().getName();
            counter.incrementAndGet();
            log.info("before execution: " + threadName);
            runnable.run();
            log.info("after execution: " + threadName);
        });
        var integerFlux = Flux.just(1, 2, 3).delayElements(Duration.ofMillis(1)).subscribeOn(Schedulers.immediate());
        StepVerifier.create(integerFlux).expectNext(1, 2, 3).verifyComplete();
        Assertions.assertEquals(3, counter.get(), "count should be 3");
    }
}
