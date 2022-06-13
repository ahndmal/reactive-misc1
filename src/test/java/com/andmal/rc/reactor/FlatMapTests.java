//package com.andmal.rc.reactor;
//
//import org.apache.commons.lang3.tuple.Pair;
//import org.junit.jupiter.api.Test;
//import reactor.core.publisher.Flux;
//import reactor.test.StepVerifier;
//
//import java.time.Duration;
//
//public class FlatMapTests {
//
//    @Test
//    public void flatMap() {
//
//        var data = Flux.just(new Pair(1, 300), new Pair(2, 200), new Pair(3, 100))
//                .flatMap(id -> this.delayReplyFor(id.id, id.delay));
//        StepVerifier//
//                .create(data)//
//                .expectNext(3, 2, 1)//
//                .verifyComplete();
//    }
//
//    private Flux<Integer> delayReplyFor(Integer i, long delay) {
//        return Flux.just(i).delayElements(Duration.ofMillis(delay));
//    }
//
//    private record Pair(int id, long delay) {
//    }
//}
