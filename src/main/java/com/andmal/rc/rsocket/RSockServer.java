package com.andmal.rc.rsocket;

import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;

public class RSockServer {
    public static void main(String[] args) {

        RSocketServer.create(new PingHandler())
                // Enable Zero Copy
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .bind(TcpServerTransport.create(7878))
                .block()
                .onClose()
                .block();


    }
}
