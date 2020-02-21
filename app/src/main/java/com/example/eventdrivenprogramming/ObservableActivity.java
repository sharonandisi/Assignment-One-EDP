package com.example.eventdrivenprogramming;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class ObservableActivity extends AppCompatActivity {

    private TextView output;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable);

        output = findViewById(R.id.output);

      //internalObserver()

        observableFromDiffered();
    }

    private void observableFromCallable(){
        Observable<String> text = Observable.fromCallable(()-> getTextForNumbers());
        compositeDisposable.add(text.subscribe(string -> output.setText(string)));

    }
    private void intervalObservable(){
        compositeDisposable.add(integerObservable.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( value->{
                    output.append(String.format("%dn", value));
                }));
    }


    private String getTextForNumbers(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<20; i++)
            builder.append(String.format("%d,\n",i));
        return builder.toString();
    }

    private Observable<Integer> integerObservable = Observable.create(emitter -> {
        for(int i =0; i<10; i++){
            if (!emitter.isDisposed()){
                emitter.onNext(i);
                Thread.sleep(2000);
            }
        }
        emitter.onComplete();
    });

    private void Observable<Integer> getDifferedObservable() {
        return integerObservable;

    }

    private void observableFromDiffered(){
        Observable<Integer> observable = Observable.defer(()->getDifferedObservable());
        compositeDisposable.add(            observable.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( value->{
                    output.append(String.format("%dn", value));
                }));

    }

    @Override
        protected void onDestroy() {
            super.onDestroy();
            compositeDisposable.dispose();
        }

    }