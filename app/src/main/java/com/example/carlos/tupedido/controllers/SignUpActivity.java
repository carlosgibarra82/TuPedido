package com.example.carlos.tupedido.controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.interfaces.SignupActivityInterface;

public class SignUpActivity extends AppCompatActivity implements SignupActivityInterface{

    SharedPreferences sharedPreferences;
    TextView user;
    TextView password;
    TextView confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user =  (TextView) findViewById(R.id.edt_user);
        password =  (TextView) findViewById(R.id.edt_password);
        confirm_password =  (TextView) findViewById(R.id.edt_confirm_password);

    }

    @Override
    public void SignIn(View view) {

        if(password.getText().toString().equals(confirm_password.getText().toString())) {

            sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("user", user.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
    }

}
