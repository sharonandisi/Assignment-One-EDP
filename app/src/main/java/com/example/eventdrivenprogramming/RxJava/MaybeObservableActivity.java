package com.example.eventdrivenprogramming.RxJava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.eventdrivenprogramming.R;

import java.util.UUID;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MaybeObservableActivity extends AppCompatActivity {

    private boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maybe_observable);

        Button btnMaybe = findViewById(R.id.btnMaybe);
        btnMaybe.setOnClickListener(v-> {
            Maybe<String> someMessage;
            if (!error){
                error = true;
                someMessage = Maybe.just(UUID.randomUUID().toString());

        }else{
            error = false;
            someMessage = Maybe.error(Exception::new);
        }
            someMessage.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new MaybeObserver<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(String s) {
                            showToast(s);



                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
//

            }





            );
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
