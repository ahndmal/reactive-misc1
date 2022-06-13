package com.andmal.rc.rx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxInterval1 {

    @SneakyThrows
    public static void main(String[] args) {

       Flowable.range(1,7)
               .doOnNext(System.out::println)
               .map(i -> i * 1000)
               .delay(3, TimeUnit.SECONDS)
               .subscribe();

        Observable.timer(3, TimeUnit.SECONDS)
                .doOnNext(System.out::println)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("Subscribed");
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        System.out.println("NEXT");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Complete!");
                    }
                });
        Thread.sleep(2000);
    }
}
