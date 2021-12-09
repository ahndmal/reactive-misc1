package com.andmal.rc.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinksFlux {
    public static void sinks() {

        // handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().replay().all();
        Sinks.Many<Integer> replaySink = Sinks.many().replay().all();
        Sinks.Many<Object> onBackpressureBuffer = Sinks.many().unicast().onBackpressureBuffer();
        Sinks.Many<Object> objectMany = Sinks.many().multicast().onBackpressureBuffer();
        Sinks.One<Object> one = Sinks.one();

        replaySink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        Sinks.EmitResult result = sink.tryEmitNext(3);

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe();
        flux.subscribe();
        sink.tryEmitNext("?");
        flux.subscribe();

        sink.tryEmitNext("new msg");
    }
}
