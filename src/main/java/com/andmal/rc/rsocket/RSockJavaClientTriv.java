package com.andmal.rc.rsocket;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.WebsocketClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

import java.net.URI;

public class RSockJavaClientTriv {
    public static void main(String[] args) {

        WebsocketClientTransport ws = WebsocketClientTransport.create(URI.create("ws://rsocket-demo.herokuapp.com/ws"));

        RSocket rSocket = RSocketConnector.connectWith(ws).block();

        try {

            Flux<Payload> s = rSocket.requestStream(DefaultPayload.create("peace"));
            s.take(10)
                    .doOnNext(p -> System.out.println(p.getDataUtf8()))
                    .blockLast();

        } catch (NullPointerException e) {
          e.printStackTrace();
        } finally {
            rSocket.dispose();
        }

    }
}
