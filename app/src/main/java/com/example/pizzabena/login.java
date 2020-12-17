package com.example.pizzabena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText Tel;
    EditText Password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /********************************************/
        /**************init var***********************/
        /********************************************/
        init();
        /********************************************/
        login();
    }

    public void init() {
        Tel = findViewById(R.id.EditTextTelLoginPage);
        Password = findViewById(R.id.EditTextPasswordLoginPage);
        btnLogin = findViewById(R.id.loginBtn);
    }

    public void login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Message = testValidation(Tel.getText().toString(), Password.getText().toString());
                if (Message.isEmpty()) {
                    SharedPreferences sharedPref = getSharedPreferences(getString(R.string.idShredRef), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean(getString(R.string.IS_CONNECTED), true);
                    editor.apply();
                    startActivity(new Intent(login.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(v.getContext(),Message, Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    /********************************************/
    /***********Test input if valid**************/
    /********************************************/
    public String testValidation(String tel, String password) {
        String ErrorMeesage="";
        if (tel.isEmpty() || password.isEmpty()) {
            ErrorMeesage="You Should Not leave Empty Inputs";
        }
        else if (!tel.matches("-?(0|[1-9]\\d*)")){
            ErrorMeesage="You Should Put Number In Tel";

        }
            return  ErrorMeesage;
    }
}