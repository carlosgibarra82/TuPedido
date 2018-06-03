package com.example.carlos.tupedido.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlos.tupedido.model.Dishes;
import com.example.carlos.tupedido.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter{

    List<Dishes> dishesList;
    Context context;

    public DishesAdapter(List<Dishes> dishesList, Context context) {
        this.dishesList = dishesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes, parent, false);
        return new ViewHolderDishes(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Dishes object = dishesList.get(position);
        ViewHolderDishes viewHolderStadium = (ViewHolderDishes) holder;
        viewHolderStadium.textViewDishName.setText(object.getName());
        Picasso.get().load(object.getPicture()).into(viewHolderStadium.imageViewDishImg);

    }


    @Override
    public int getItemCount() {return dishesList.size();
    }

    public class ViewHolderDishes extends RecyclerView.ViewHolder{
        TextView textViewDishName;
        ImageView imageViewDishImg;

        public ViewHolderDishes(View item) {
            super(item);
            textViewDishName = item.findViewById(R.id.id_txt_dish);
            imageViewDishImg = item.findViewById(R.id.id_img_dish);
        }
    }
}
