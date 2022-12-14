package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView greet;
    private EditText name;
    private Button btn;
    private EditText password;
    private ProgressBar pb;
    private Map<String, String> passwords;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwords = new HashMap<>();
        passwords.put("noobmaster6969", "thor");
        passwords.put("vivekRawani", "angelpriya@69");
        passwords.put("jay", "123");
        passwords.put("aniket", "123");
        passwords.put("abhinav", "123");
        passwords.put("harsh", "123");
        passwords.put("neeraj", "123");
        passwords.put("rajat", "123");
        passwords.put("mohit", "123");
        passwords.put("prajjwal", "123");
        passwords.put("gipashu", "123");


        greet = findViewById(R.id.greet);
        name = findViewById(R.id.usernameBox);
        btn = findViewById(R.id.btn);
        password = findViewById(R.id.passwordBox);
        pb = findViewById(R.id.pb);
        rl = findViewById(R.id.parent);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closeKeyboard();
                SystemClock.sleep(400);
                authenticate();
            }
        });
    }

    private void authenticate() {
        boolean b = passwords.containsKey(name.getText().toString());
        String userInputPassword = password.getText().toString();
        String correctPassword = passwords.get(name.getText().toString());
        if(!b){
            greet.setVisibility(View.INVISIBLE);
            showInvalidUsername();

        }
        else{
            if(userInputPassword.equals(correctPassword)){
                greet.setVisibility(View.VISIBLE);
                greet.setText("Hello " +  name.getText().toString() + "! " +
                        "\nI hope you are enjoying your day.");
            }
            else {
                greet.setVisibility(View.INVISIBLE);
                showIncorrectPassword();
            }
        }

    }

    private void showIncorrectPassword() {
        Snackbar.make(rl, "Incorrect Password!", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        password.setText("");

                    }
                })
                .show();
    }
    

    private void showInvalidUsername() {
        Snackbar.make(rl, "Invalid Username!", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name.setText("");
                        password.setText("");

                    }
                })
                .show();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }


    }
}