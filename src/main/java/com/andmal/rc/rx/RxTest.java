package com.andmal.rc.rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxTest {

    public static void main(String[] args) {

        Flowable.just("Hello!").subscribe(System.out::println);

        Observable.just("Hello JUST!")
                .doOnNext(System.out::println)
                .doOnComplete(() -> System.out.println("Completed JUST"))
                .subscribe();

        Flowable.range(1,10)
                .map(e -> "Hello " + e)
                .doOnNext(System.out::println)
//                .subscribeOn(new Scheduler())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        System.out.println("Accepted!");
                    }
                });

    }
}
