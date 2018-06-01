package com.example.carlos.tupedido.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.tupedido.Adapters.DishesAdapter;
import com.example.carlos.tupedido.ApiRest.RestApiAdapter;
import com.example.carlos.tupedido.ApiRest.Service;
import com.example.carlos.tupedido.Model.Dishes;
import com.example.carlos.tupedido.Model.Users;
import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.Interfaces.LoginActivityInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityInterface {

    SharedPreferences sharedPreferences;
    TextView txt_username;
    TextView txt_password;
    List<Users> usersList;
    Boolean valid=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        getData();
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

        if (txt_username.getText().toString().isEmpty() || txt_password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Some Field is empty", Toast.LENGTH_SHORT).show();
        } else {

            if (validateUser(usersList)){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", txt_username.getText().toString());
                editor.putString("password", txt_password.getText().toString());
                editor.putBoolean("persistence", true);
                editor.apply();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Credentials invalid", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void getData(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<List<Users>> groups = service.getDataUsers();
        groups.enqueue(new Callback<List<Users>>() {

            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                usersList = response.body();
            }
            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });
    }

    public boolean validateUser(List<Users> usersList){
        for(Users user : usersList) {
            if (txt_username.getText().toString().trim().equals(user.getUsername().trim()) && (txt_password.getText().toString().trim().equals(user.getPassword().trim()))){
                valid=true;
                break;
            } else
                valid=false;
        }
        return valid;
    }
}
