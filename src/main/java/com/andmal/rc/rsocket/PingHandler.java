package com.andmal.rc.rsocket;

import io.rsocket.ConnectionSetupPayload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import reactor.core.publisher.Mono;

public class PingHandler implements SocketAcceptor {

    @Override
    public Mono<RSocket> accept(ConnectionSetupPayload payload, RSocket rSocket) {

//        return Mono.fromCallable(MathService::new);
        return Mono.just(rSocket);
    }
}
