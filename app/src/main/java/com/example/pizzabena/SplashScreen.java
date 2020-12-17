package com.example.pizzabena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.pizzabena.Classes.Constrans;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler();
    }
    public  void handler(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.idShredRef), Context.MODE_PRIVATE);
                boolean textConnected = sharedPref.getBoolean(getString(R.string.IS_CONNECTED),false);
                rounting(textConnected);
            }
        }, Constrans.DELAY);
    }
    /********************************************/
    /*********route to login or home*************/
    /********************************************/
    public void rounting(boolean textConnected){
        if(textConnected){
            startActivity(new Intent(SplashScreen.this,MainActivity.class));
            finish();
        }else{
            startActivity(new Intent(SplashScreen.this,login.class));
            finish();
        }
    }
}