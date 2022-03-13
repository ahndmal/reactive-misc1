package com.andmal.rc.mutiny;

import io.smallrye.mutiny.Multi;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Multis {
    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1, 100);
        Supplier supplier = () -> "";
        Multi<Integer> multi = Multi.createFrom().items(Stream.of(1,2,3,4));
//        Multi<Integer> multi2 = Multi.createFrom().iterable(intStream);
        Multi<Integer> multiFromIterable = Multi.createFrom().iterable(Arrays.asList(1, 2, 3, 4, 5));
        multi.onItem()
//                .call(() -> System.out.println())
                .transform(i -> i).subscribe();

        Multi<Long> ticks = Multi.createFrom().ticks().every(Duration.ofMillis(100));

        Multi.createFrom().items(1, 2, 3, 4, 5)
                .onItem().transform(i -> i * 2)
                .select().first(3)
                .onFailure().recoverWithItem(0)
                .subscribe().with(System.out::println);
    }
}
