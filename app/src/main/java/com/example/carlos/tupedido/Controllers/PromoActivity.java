package com.example.carlos.tupedido.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlos.tupedido.R;
import com.shawnlin.numberpicker.NumberPicker;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;

public class PromoActivity extends AppCompatActivity {

    private Bundle bundle;
    private ImageView img_dish;
    private ImageView img_drink;
    private NumberPicker numberPicker;
    private TextView id_txt_value;
    private int price;
    private Button btn_add;
    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        this.setFinishOnTouchOutside(true);
        img_dish = findViewById(R.id.img_dish);
        img_drink = findViewById(R.id.img_drink);
        id_txt_value = findViewById(R.id.id_txt_value);

        btn_add = findViewById(R.id.id_btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                putData();
            }
        });

        btn_close = findViewById(R.id.id_btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });

        bundle = getIntent().getExtras();

        String prd_picture = bundle.getString("picture");
        Picasso.get().load(prd_picture).into(img_dish);

        String prd_picture2 = bundle.getString("picture2");
        Picasso.get().load(prd_picture2).into(img_drink);

        String name = bundle.getString("name");
        price = bundle.getInt("price");
        setTitle(name);
        showValue(1);

        numberPicker = findViewById(R.id.number_picker);
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(data.length);
        numberPicker.setDisplayedValues(data);
        numberPicker.setValue(1);
        numberPicker.setTextSize(getResources().getDimension(R.dimen.text_size));


        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                showValue(newVal);
            }
        });
    }

    private void showValue(int newVal){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setMinimumFractionDigits(0);
        id_txt_value.setText(formatter.format(newVal*price));
    }

    public void putData(){
        /*RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        String[] myStringArray = {"a","b","c"};
        service.saveOrder("1","1",myStringArray,myStringArray).enqueue(new Callback<List<Orders>>() {

            @Override
            public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
                Log.i("working","Funcionó");
            }

            @Override
            public void onFailure(Call<List<Orders>> call, Throwable t) {
                Log.e("not working","no funcionó");
            }
        });

    }*/
    }
}
