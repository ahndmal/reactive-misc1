package com.andmal.rc.reactor.threads;

import reactor.core.publisher.Flux;

public class Errors1 {

    static void doSomethingDangerous() {
        System.out.println("danger");
    }

    public void main(String[] args) {

        Flux.just(10)
                .map(Object::toString)
                .onErrorReturn("RECOVERED");
    }
}
