package com.example.carlos.tupedido.Controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.carlos.tupedido.Adapters.ProductsAdapter;
import com.example.carlos.tupedido.ApiRest.RestApiAdapter;
import com.example.carlos.tupedido.ApiRest.Service;
import com.example.carlos.tupedido.Model.Dishes;
import com.example.carlos.tupedido.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductsFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<Dishes> dishesList;


    public ProductsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container,false);

        progressBar = view.findViewById(R.id.id_pgb_products);
        recyclerView = view.findViewById(R.id.id_rcv_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar.setVisibility(View.VISIBLE);
        getData();
        return  view;
    }



    public void getData() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<List<Dishes>> groups = service.getDataDishes();
        groups.enqueue(new Callback<List<Dishes>>() {
            @Override
            public void onResponse(Call<List<Dishes>> call, Response<List<Dishes>> response) {
                dishesList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(new ProductsAdapter(dishesList, getContext()));
            }
            @Override
            public void onFailure(Call<List<Dishes>> call, Throwable t) {
            }
        });
    }
}
