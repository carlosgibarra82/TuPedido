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
import com.example.carlos.tupedido.interfaces.LoginActivityInterface;

public class LoginActivity extends AppCompatActivity implements LoginActivityInterface {

    SharedPreferences sharedPreferences;
    TextView txt_username;
    TextView txt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void LaunchSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void Login(View view) {
        sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("user", null);
        String password = sharedPreferences.getString("password", null);

        if (txt_username.getText().toString().isEmpty() || txt_password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Some Field is empty", Toast.LENGTH_SHORT).show();
        } else {
            if (txt_username.getText().toString().trim().equals(user.trim()) && (txt_password.getText().toString().trim().equals(password.trim()))) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", txt_username.getText().toString());
                editor.putString("password", txt_password.getText().toString());
                editor.putBoolean("persistence", true);
                editor.apply();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Credentials invalid", Toast.LENGTH_SHORT).show();
        }
    }

}
