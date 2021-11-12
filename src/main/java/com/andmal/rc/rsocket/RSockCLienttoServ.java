package com.andmal.rc.rsocket;

import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;

public class RSockCLienttoServ {
    public static void main(String[] args) {

        RSocket clientRSocket =
                RSocketConnector.create()
                        // Enable Zero Copy
                        .payloadDecoder(PayloadDecoder.ZERO_COPY)
                        .connect(TcpClientTransport.create(7878))
                        .block();

    }
}
