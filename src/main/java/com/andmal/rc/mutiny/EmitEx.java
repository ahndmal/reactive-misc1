package com.andmal.rc.mutiny;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class EmitEx {
    public static void main(String[] args) {

        Multi<Integer> uni = Multi.createFrom().emitter(em -> {

            em.emit(1);
            em.emit(2);
            em.emit(3);
            em.complete();
            // When the result is available, emit it
        });
    }
}
