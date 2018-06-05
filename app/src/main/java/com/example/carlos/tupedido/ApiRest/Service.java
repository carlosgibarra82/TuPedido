package com.example.carlos.tupedido.ApiRest;

import com.example.carlos.tupedido.model.Devices;
import com.example.carlos.tupedido.model.Dishes;
import com.example.carlos.tupedido.model.Drinks;
import com.example.carlos.tupedido.model.Promo;
import com.example.carlos.tupedido.model.Users;
import com.example.carlos.tupedido.model.Vf_images;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {

    @POST(Constants.URL_POST_USER)
    @FormUrlEncoded
    Call<List<Users>> saveUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET(Constants.URL_GET_USER)
    Call<List<Users>> getDataUsers();

    @GET(Constants.URL_GET_DEVICES)
    Call<List<Devices>> getDataDevices();

    @GET(Constants.URL_GET_DISHES)
    Call<List<Dishes>> getDataDishes();

    @GET(Constants.URL_GET_DRINKS)
    Call<List<Drinks>> getDataDrinks();

    @GET(Constants.URL_GET_VF_IMAGES)
    Call<List<Vf_images>> getVfImages();

    @GET(Constants.URL_GET_PROMO)
    Call<List<Promo>> getDataPromo();
}