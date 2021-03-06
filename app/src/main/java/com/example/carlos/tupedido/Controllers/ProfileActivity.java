package com.example.carlos.tupedido.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.tupedido.ApiRest.RestApiAdapter;
import com.example.carlos.tupedido.ApiRest.Service;
import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.Model.Users;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView user;
    private TextView password;
    private TextView confirm_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user = findViewById(R.id.id_profile_user);
        password = findViewById(R.id.id_profile_password);
        confirm_password = findViewById(R.id.id_profile_confirm_password);
        sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);
        user.setText(sharedPreferences.getString("user",""));
        user.setEnabled(false);
        user.setSelected(false);
        password.requestFocus();
    }


    public void changePassword(View view) {

        if(user.getText().length()!=0 && password.getText().length()!=0) {
            if (password.getText().toString().equals(confirm_password.getText().toString())) {
                Users newUser = new Users(user.getText().toString(), password.getText().toString());
                putData(newUser);

                sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", user.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.putBoolean("persistence", true);
                editor.commit();
                this.finish();

            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
        }

    }

    public void putData(Users user){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();

        service.updateUser(user.getUsername(),user).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("working","Funcionó");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("not working","no funcionó");
            }
        });

    }
}
