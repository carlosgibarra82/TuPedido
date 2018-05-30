package com.example.carlos.tupedido;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


public class MyOrdersFragment extends Fragment {

    ProgressBar progressBar;
    RecyclerView recyclerView;

    public MyOrdersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container,false);

        progressBar = (ProgressBar) view.findViewById(R.id.id_pgb_products);
        recyclerView = (RecyclerView) view.findViewById(R.id.id_rcv_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressBar.setVisibility(view.VISIBLE);

        return  view;


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_my_orders, container, false);
    }


}
