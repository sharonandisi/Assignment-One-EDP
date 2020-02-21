package com.example.eventdrivenprogramming.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eventdrivenprogramming.R;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class StudentDetailsActivity extends AppCompatActivity {

    private StudentDetailsViewModel viewModel;
    private Button buttonStringEvent, buttonObjEvent;
    private TextView stringEvent, objEvent, fullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        viewModel = ViewModelProviders.of(this).get(StudentDetailsViewModel.class);
        viewModel.setup();
        buttonObjEvent = findViewById(R.id.buttonStudentObjEvent);
        buttonStringEvent = findViewById(R.id.buttonStudentStringEvent);
        stringEvent = findViewById(R.id.studentStringEvent);
        objEvent = findViewById(R.id.studentObjEvent);
        fullName = findViewById(R.id.fullName);

        viewModel.studentName.observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s){

                    }
                });
        viewModel.myStudentObj.observe(this, student -> objEvent.setText(student .toString()));

        buttonStringEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setStudentName(UUID.randomUUID().toString());
            }
        });
        buttonObjEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setMyStudentObj(new Student(UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                       UUID.randomUUID().toString()));
            }
        });

                viewModel.fullName.observe(this, Name->{
                    fullName.setText(Name);
                });
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                viewModel.setMyStudentObj(new Student(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
//
//                viewModel.setFirstName(UUID.randomUUID().toString());
//
//            }
//        }, 3000);
    }
}
