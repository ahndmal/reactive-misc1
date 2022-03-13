package com.andmal.rc.mutiny;

import io.smallrye.mutiny.Uni;

public class EmitEx {
    public static void main(String[] args) {

        Uni<String> uni = Uni.createFrom().emitter(em -> {


            // When the result is available, emit it
            em.complete(result);
        });
    }
}
