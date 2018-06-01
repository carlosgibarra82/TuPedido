package com.example.carlos.tupedido.ApiRest;

import com.example.carlos.tupedido.Model.Devices;
import com.example.carlos.tupedido.Model.Dishes;
import com.example.carlos.tupedido.Model.Drinks;
import com.example.carlos.tupedido.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {
    @GET(Constants.URL_GET_USER)
    Call<List<Users>> getDataUsers();

    @GET(Constants.URL_GET_DEVICES)
    Call<List<Devices>> getDataDevices();

    @GET(Constants.URL_GET_DISHES)
    Call<List<Dishes>> getDataDishes();

    @GET(Constants.URL_GET_DRINKS)
    Call<List<Drinks>> getDataDrinks();

    @POST(Constants.URL_POST_USER)
    @FormUrlEncoded
    Call<Users> saveUser(@Field("username") String username,
                        @Field("password") String password);
}
