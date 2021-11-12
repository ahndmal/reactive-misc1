package com.andmal.rc.rsocket;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import reactor.core.publisher.Mono;

public class MathService implements RSocket {

    @Override
    public Mono<Void> fireAndForget(Payload payload) {
        return RSocket.super.fireAndForget(payload);
    }
}
