package com.andmal.rc.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinksFlux {
    public static void main(String[] args) {

        // handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().replay().all();

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
