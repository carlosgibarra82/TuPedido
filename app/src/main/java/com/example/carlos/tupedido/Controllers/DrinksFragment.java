package com.example.carlos.tupedido.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.carlos.tupedido.Adapters.DrinksAdapter;
import com.example.carlos.tupedido.Adapters.ProductsAdapter;
import com.example.carlos.tupedido.ApiRest.RestApiAdapter;
import com.example.carlos.tupedido.ApiRest.Service;
import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.model.Dishes;
import com.example.carlos.tupedido.model.Drinks;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<Drinks> drinksList;


    public DrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drinks, container,false);

        progressBar = view.findViewById(R.id.id_pgb_drinks);
        recyclerView = view.findViewById(R.id.id_rcv_drinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar.setVisibility(View.VISIBLE);
        getData();
        return  view;
    }


    public void getData() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<List<Drinks>> groups = service.getDataDrinks();
        groups.enqueue(new Callback<List<Drinks>>() {
            @Override
            public void onResponse(Call<List<Drinks>> call, Response<List<Drinks>> response) {
                drinksList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(new DrinksAdapter(drinksList, getContext()));
            }
            @Override
            public void onFailure(Call<List<Drinks>> call, Throwable t) {
            }
        });
    }

}
