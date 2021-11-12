package com.andmal.rc.reactor;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxCreate {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String catBreed;
            do {
                catBreed = Faker.instance().cat().breed();
                fluxSink.next(catBreed);
//                fluxSink.onRequest((r) -> System.out.println("Request initiated")).next(catBreed);
            } while (!catBreed.equals("Arabian Mau")); {
                fluxSink.complete();
            }
        }).subscribe();
    }
}
