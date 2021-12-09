package com.andmal.rc.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class MonoCreateTests {

    @Test
    public void testMonoCReate() {
        StepVerifier.create(
                        Mono.just(1).map(i -> i + 10),
                        StepVerifierOptions.create().withInitialContext(Context.of("thing1", "thing2")))
                .expectAccessibleContext()
                .contains("thing1", "thing2")
                .then()
                .expectNext(11)
                .verifyComplete();
    }
}
