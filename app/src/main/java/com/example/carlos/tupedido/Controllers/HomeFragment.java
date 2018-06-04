package com.example.carlos.tupedido.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.carlos.tupedido.ApiRest.RestApiAdapter;
import com.example.carlos.tupedido.ApiRest.Service;
import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.model.Vf_images;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment{

    private ViewFlipper viewFlipper;
    private List<Vf_images> imagesList;
    private String images[];
    private Button btn_products;
    public HomeFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        viewFlipper = view.findViewById(R.id.v_Flipper);
        getData();
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        btn_products = view.findViewById(R.id.btn_products);
        btn_products.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction=manager.beginTransaction();
                ProductsFragment fragmentB=new ProductsFragment();
                transaction.replace(R.id.content_main,fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    public void getData() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<List<Vf_images>> groups = service.getVfImages();
        groups.enqueue(new Callback<List<Vf_images>>() {
            @Override
            public void onResponse(Call<List<Vf_images>> call, Response<List<Vf_images>> response) {
                imagesList = response.body();
                images = new String[imagesList.size()];

                int i = 0;
                for (Vf_images image : imagesList) {
                    images[i] = image.getImage();
                    setImageInFlipr(images[i]);
                    i++;
                }
                viewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);
            }

            @Override
            public void onFailure(Call<List<Vf_images>> call, Throwable t) {

            }
        });
    }

    private void setImageInFlipr(String imgUrl) {
        ImageView image = new ImageView(this.getContext());
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.get().load(imgUrl).into(image);
        viewFlipper.addView(image);
    }

    public void products(View view){

    }
}
