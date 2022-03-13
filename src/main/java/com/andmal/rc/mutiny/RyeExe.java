package com.andmal.rc.mutiny;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.Cancellable;

import java.util.concurrent.atomic.AtomicInteger;

public class RyeExe {
    public static void main(String[] args) {

        Uni<String> uni1 = Uni.createFrom().item("hello");
        Uni<String> uni2 = uni1.onItem().transform(item -> item + " mutiny");
        Uni<String> uni3 = uni2.onItem().transform(String::toUpperCase);

        uni1.subscribe().with(System.out::println);

        Cancellable cancellable = uni1
                .subscribe().with(
                        item -> System.out.println(item),
                        failure -> System.out.println("Failed with " + failure));

        AtomicInteger counter = new AtomicInteger();
        Uni<Integer> uni = Uni.createFrom().item(() -> counter.getAndIncrement());
    }
}
