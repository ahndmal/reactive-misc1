package com.andmal.rc.reactor;

import reactor.core.publisher.Operators;

import java.util.function.Consumer;

public class Util {
    public static void sleepSeconds(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Consumer onNext() {

        return new Consumer<>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }

        };

    }
}
