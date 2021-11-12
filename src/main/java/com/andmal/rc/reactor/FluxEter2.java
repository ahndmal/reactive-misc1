package com.andmal.rc.reactor;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxEter2 {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    String country = Faker.instance().country().name();
                    System.out.println("emitting " + country);
                    synchronousSink.next(country);
                    if (country.equals("Ireland")) {
                        synchronousSink.complete();
                    }
                }).subscribe();
    }
}
