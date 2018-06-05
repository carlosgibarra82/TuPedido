package com.example.carlos.tupedido.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.model.Promo;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter{

    List<Promo> promoList;
    Context context;

    public PromoAdapter(List<Promo> promoList, Context context) {
        this.promoList = promoList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promo, parent, false);
        return new ViewHolderPromo(item,this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Promo object = promoList.get(position);
        ViewHolderPromo viewHolderPromo = (ViewHolderPromo) holder;

        Picasso.get().load(object.getPicture()).into(viewHolderPromo.imageViewPromoImg);
        Picasso.get().load(object.getPicture2()).into(viewHolderPromo.imageViewPromoDrinkImg);
        viewHolderPromo.textViewPromoName.setText(object.getName()+" + "+object.getFlavor());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMinimumFractionDigits(0);
        viewHolderPromo.textViewPromoValue.setText(formatter.format(object.getPrice()));

   }

    @Override
    public int getItemCount() {return promoList.size();}

    public class ViewHolderPromo extends RecyclerView.ViewHolder{
        ImageView imageViewPromoImg;
        ImageView imageViewPromoDrinkImg;
        TextView textViewPromoName;
        TextView textViewPromoValue;



        public ViewHolderPromo(View item,Context c) {
            super(item);
            final Context context=c;
            imageViewPromoImg = item.findViewById(R.id.id_img_dish);
            imageViewPromoDrinkImg = item.findViewById(R.id.id_img_drink);
            textViewPromoName = item.findViewById(R.id.id_txt_promoname);
            textViewPromoValue = item.findViewById(R.id.id_txt_promovalue);
        }
    }
}