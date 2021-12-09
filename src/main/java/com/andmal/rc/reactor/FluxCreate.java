package com.andmal.rc.reactor;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.List;

interface MyEventListener<T> {
    void onDataChunk(List<T> chunk);
    void processComplete();
}

public class FluxCreate {
    public static void main(String[] args) {

        // Asynchronous Flux.create()
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

//        Flux<String> bridge = Flux.create(sink -> {
//            myEventProcessor.register(
//                    new MyEventListener<String>() {
//
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        public void processComplete() {
//                            sink.complete();
//                        }
//                    });
//        });

//        Flux<String> bridge = Flux.push(sink -> {
//            myEventProcessor.register(
//                    new SingleThreadEventListener<String>() {
//
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        public void processComplete() {
//                            sink.complete();
//                        }
//
//                        public void processError(Throwable e) {
//                            sink.error(e);
//                        }
//                    });
//        });

//        Flux<String> bridge = Flux.create(sink -> {
//            sink.onRequest(n -> channel.poll(n))
//                    .onCancel(() -> channel.cancel())
//                    .onDispose(() -> channel.close())
//        });


    }
}
