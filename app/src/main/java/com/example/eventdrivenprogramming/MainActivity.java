package com.example.eventdrivenprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hyphenInsertion();

    }
    public void hyphenInsertion() {
        final TextInputEditText textInputEditText = findViewById(R.id.username);

        textInputEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isFormatting)
                    return;


                final int selStart = Selection.getSelectionStart(s);
                final int selEnd = Selection.getSelectionEnd(s);
                if (s.length() > 1
                        && count == 1
                        && after == 0
                        && s.charAt(start) ==
                        && selStart == selEnd) {
                    deletingHyphen = true;
                    hyphenStart = start;

                    if (selStart == start + 1) {
                        deletingBackward = true;
                    } else {
                        deletingBackward = false;
                    }
                } else {
                    deletingHyphen = false;
                }

            }
             int keyDel;
             String a;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean flag = true;
                String eachBlock[] = textInputEditText.getText().toString().split("-");
                for (int i = 0; i < eachBlock.length; i++) {
                    if (eachBlock[i].length() > 100) {
                        flag = false;
                    }
                }

               
                if (flag) {

                    textInputEditText.setOnKeyListener(new View.OnKeyListener() {

                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {

                            if (keyCode == KeyEvent.KEYCODE_DEL)
                                keyDel = 1;
                            return false;
                        }
                    });

                    if (keyDel == 0) {

                        if (((textInputEditText.getText().length() + 1) % 2) == 0) {

                            if (textInputEditText.getText().toString().split("-").length <= 16) {
                                textInputEditText.setText(textInputEditText.getText() + "-");
                                textInputEditText.setSelection(textInputEditText.getText().length());
                            }
                        }
                        a = textInputEditText.getText().toString();
                    } else {
                        a = textInputEditText.getText().toString();
                        keyDel = 0;
                    }

                } else {
                    textInputEditText.setText(a);
                }
            }
            private boolean isFormatting;
            private boolean deletingHyphen;
            private int hyphenStart;
            private boolean deletingBackward;

            @Override
            public void afterTextChanged(Editable s) {
                if (isFormatting)
                    return;

                isFormatting = true;


                if (deletingHyphen && hyphenStart > 0) {
                    if (deletingBackward) {
                        if (hyphenStart - 1 < s.length()) {
                            s.delete(hyphenStart - 1, hyphenStart);
                        }
                    } else if (hyphenStart < s.length()) {
                        s.delete(hyphenStart, hyphenStart + 1);
                    }
                }

                isFormatting = false;

            }
        });

    }

}
