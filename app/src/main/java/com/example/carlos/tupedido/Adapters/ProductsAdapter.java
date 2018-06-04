package com.example.carlos.tupedido.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlos.tupedido.Controllers.IngredientsActivity;
import com.example.carlos.tupedido.model.Dishes;
import com.example.carlos.tupedido.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter{

    List<Dishes> dishesList;
    Context context;

    public ProductsAdapter(List<Dishes> dishesList, Context context) {
        this.dishesList = dishesList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes, parent, false);
        return new ViewHolderDishes(item,this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Dishes object = dishesList.get(position);
        ViewHolderDishes viewHolderProducts = (ViewHolderDishes) holder;
        viewHolderProducts.textViewDishName.setText(object.getName());
        viewHolderProducts.object=object;
        Picasso.get().load(object.getPicture()).into(viewHolderProducts.imageViewDishImg);


    }


    @Override
    public int getItemCount() {return dishesList.size();}

    public class ViewHolderDishes extends RecyclerView.ViewHolder{
        TextView textViewDishName;
        ImageView imageViewDishImg;
        Dishes object;

        public ViewHolderDishes(View item,Context c) {
            super(item);
            final Context context=c;
            textViewDishName = item.findViewById(R.id.id_txt_dish);
            imageViewDishImg = item.findViewById(R.id.id_img_dish);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, IngredientsActivity.class);
                    myIntent.putExtra("picture",object.getPicture().toString());
                    context.startActivity(myIntent);
                }
            });
        }


    }
}
