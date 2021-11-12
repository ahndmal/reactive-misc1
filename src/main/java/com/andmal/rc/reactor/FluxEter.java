package com.andmal.rc.reactor;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxEter {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    String country;
                    int counter = 0;
                    do {
                        country = Faker.instance().country().name();
                        System.out.println("emitting : " + country);
                        fluxSink.next(country);
                        counter++;
                    } while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled()
//                            && counter < 10
                    ); {
                        fluxSink.complete();
                    }
                })
//                .take(3)
                .subscribe();
    }
}
