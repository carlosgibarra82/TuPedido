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
import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.model.Dishes;
import com.example.carlos.tupedido.model.Drinks;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

public class DrinksAdapter extends RecyclerView.Adapter{

    List<Drinks> drinksList;
    Context context;

    public DrinksAdapter(List<Drinks> drinksList, Context context) {
        this.drinksList = drinksList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drinks, parent, false);
        return new ViewHolderDrinks(item,this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Drinks object = drinksList.get(position);
        ViewHolderDrinks viewHolderProducts = (ViewHolderDrinks) holder;
        viewHolderProducts.textViewDrinkName.setText(object.getFlavor());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMinimumFractionDigits(0);
        Picasso.get().load(object.getPicture()).into(viewHolderProducts.imageViewDrinkImg);
   }

    @Override
    public int getItemCount() {return drinksList.size();}

    public class ViewHolderDrinks extends RecyclerView.ViewHolder{
        TextView textViewDrinkName;
        ImageView imageViewDrinkImg;


        public ViewHolderDrinks(View item,Context c) {
            super(item);
            final Context context=c;
            textViewDrinkName = item.findViewById(R.id.id_txt_drink);
            imageViewDrinkImg = item.findViewById(R.id.id_img_drink);
        }
    }
}