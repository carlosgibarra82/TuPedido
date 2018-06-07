package com.example.carlos.tupedido.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.carlos.tupedido.Adapters.PromoAdapter;
import com.example.carlos.tupedido.ApiRest.RestApiAdapter;
import com.example.carlos.tupedido.ApiRest.Service;
import com.example.carlos.tupedido.Model.Promo;
import com.example.carlos.tupedido.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PromoFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<Promo> promoList;


    public PromoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promo, container,false);

        progressBar = view.findViewById(R.id.id_pgb_promo);
        recyclerView = view.findViewById(R.id.id_rcv_promo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar.setVisibility(View.VISIBLE);
        getData();
        return  view;
    }

    public void getData() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<List<Promo>> groups = service.getDataPromo();
        groups.enqueue(new Callback<List<Promo>>() {
            @Override
            public void onResponse(Call<List<Promo>> call, Response<List<Promo>> response) {
                promoList = response.body();
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(new PromoAdapter(promoList, getContext()));
            }
            @Override
            public void onFailure(Call<List<Promo>> call, Throwable t) {
            }
        });
    }

}
