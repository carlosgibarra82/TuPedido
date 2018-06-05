package com.example.carlos.tupedido.Controllers;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.carlos.tupedido.R;
import com.example.carlos.tupedido.model.Dishes;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class IngredientsActivity extends AppCompatActivity {

    private Bundle bundle;
    private ImageView img_dish;
    private ListView lwIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        this.setFinishOnTouchOutside(true);
        img_dish = findViewById(R.id.img_dish);
        lwIngredients = findViewById(R.id.lwIngredients);

        bundle = getIntent().getExtras();
        String prd_picture = bundle.getString("picture");
        Picasso.get().load(prd_picture).into(img_dish);
        String name = bundle.getString("name");
        setTitle(name);
        String str_ing[] = bundle.getString("ingredients").substring(1,bundle.getString("ingredients").length()-1).split(",");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_ing);
        lwIngredients.setAdapter(adapter);
    }
}
