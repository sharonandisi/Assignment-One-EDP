package com.example.eventdrivenprogramming.WeekOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.eventdrivenprogramming.R;
import com.google.android.material.textfield.TextInputEditText;

//public class tryCatch extends AppCompatActivity {
//
//    Context context;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_assignment_one);
//
//        context = this;
//        buttonEvents();
//        editTextEvents();
//        checkBoxEvents();
//
//    }
//
//    private void buttonEvents(){
//        final String message= "Button has been clicked";
//        final Button test = findViewById(R.id.test);
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, message, Toast.LENGTH_LONG) .show();
//
//            }
//        });
//
//        final String longMessage= "Button has been long clicked";
//        test.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(context, longMessage, Toast.LENGTH_LONG).show();
//                return false;
//            }
//
//        });
//    }
//    public void editTextEvents() {
//        TextInputEditText editText = findViewById(R.id.phone_number);
//        final TextInputEditText layout = findViewById(R.id.phone_number_layout);
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String input = s.toString();
//                try {
//                    int number = Integer.parseInt(input);
//                    layout.setError(null);
//                } catch (NumberFormatException ex) {
//                    layout.setError("Invalid number: " + input);
//                }
//
//            }
//        });
//
//    }
//
//    private void checkBoxEvents() {
//        CheckBox checkBox=findViewById(R.id.checkBox);
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    Toast.makeText(context,"Checked", Toast.LENGTH_LONG).show();
//                }else {
//                    Toast.makeText(context,"Not Checked", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
//}
