package com.example.carlos.tupedido.ApiRest;

import com.example.carlos.tupedido.Model.Orders;
import com.example.carlos.tupedido.Model.Devices;
import com.example.carlos.tupedido.Model.Dishes;
import com.example.carlos.tupedido.Model.Drinks;
import com.example.carlos.tupedido.Model.Promo;
import com.example.carlos.tupedido.Model.Users;
import com.example.carlos.tupedido.Model.Vf_images;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service {

    @POST(Constants.URL_POST_USER)
    @FormUrlEncoded
    Call<List<Users>> saveUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @PUT(Constants.URL_PUT_USER)
    Call<ResponseBody> updateUser(@Path("username") String username, @Body Users user);

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


    @POST(Constants.URL_POST_ORDER)
    @FormUrlEncoded
    Call<List<Orders>> saveOrder(
            @Field("user") String username,
            @Field("device") String password,
            @Field("dishes") String[] dishes,
            @Field("drinks") String[] drinks
    );
}