package com.andmal.rc.mutiny;

import io.smallrye.mutiny.Multi;

public class MultiGen {
    public static void main(String[] args) {

        // generator
        Multi<Object> sequence = Multi.createFrom().generator(() -> 1, (n, emitter) -> {
            int next = n + (n / 2) + 1;
            if (n < 50) {
                emitter.emit(next);

            } else {
                emitter.complete();
            }
            return next;
        });

        // invoke
        Multi<String> multi = Multi.createFrom().item("Hello");
        multi
                .onSubscription().invoke(() -> System.out.println("⬇️ Subscribed"))
                .onItem().invoke(i -> System.out.println("⬇️ Received item: " + i))
                .onFailure().invoke(f -> System.out.println("⬇️ Failed with " + f))
                .onCompletion().invoke(() -> System.out.println("⬇️ Completed"))
                .onCancellation().invoke(() -> System.out.println("⬆️ Cancelled"))
                .onRequest().invoke(l -> System.out.println("⬆️ Requested: " + l));
    }
}
