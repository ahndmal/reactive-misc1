package com.andmal.rc.mutiny;

import io.smallrye.mutiny.Multi;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Multis {
    public static void main(String[] args) {

        Supplier supplier = () -> "";
        Multi<Integer> multi = Multi.createFrom().items(Stream.of(1,2,3,4));
        multi.onItem()
//                .call(() -> System.out.println())
                .transform(i -> i).subscribe();


        Multi.createFrom().items(1, 2, 3, 4, 5)
                .onItem().transform(i -> i * 2)
                .select().first(3)
                .onFailure().recoverWithItem(0)
                .subscribe().with(System.out::println);
    }
}
