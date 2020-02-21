package com.example.eventdrivenprogramming.RxJava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventdrivenprogramming.R;

import java.util.UUID;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SingleObservableActivity extends AppCompatActivity {
    private Single<String> name = Single.just("name");
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_observable);
        TextView textView = findViewById(R.id.textView);
        Button single = findViewById(R.id.single);
        single.setOnClickListener(v-> name = Single.just(UUID.randomUUID().toString()));

        name.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(String s) {
                        Toast.makeText(SingleObservableActivity.this,
                                s, Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


     @Override
    protected void onDestroy(){
        super.onDestroy();
        compositeDisposable.dispose();
     }
}
