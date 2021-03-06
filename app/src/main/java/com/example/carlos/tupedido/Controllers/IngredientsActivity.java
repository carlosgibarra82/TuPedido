package com.example.carlos.tupedido.Controllers;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.carlos.tupedido.DB.DBhelper;
import com.example.carlos.tupedido.Model.OrderLocal;
import com.example.carlos.tupedido.R;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.shawnlin.numberpicker.NumberPicker;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class IngredientsActivity extends AppCompatActivity {

    private Bundle bundle;
    private ImageView img_dish;
    private ListView lwIngredients;
    private NumberPicker numberPicker;
    private TextView id_txt_value;
    private int price;
    private Button btn_add;
    private Button btn_close;
    private Context context;
    private DBhelper helper;
    private Dao<OrderLocal, Integer> ordersDao;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        this.setFinishOnTouchOutside(true);
        img_dish = findViewById(R.id.img_dish);
        lwIngredients = findViewById(R.id.lwIngredients);
        id_txt_value = findViewById(R.id.id_txt_value);

        btn_add = findViewById(R.id.id_btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    putData();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        name = bundle.getString("name");
        price = bundle.getInt("price");
        setTitle(name);
        showValue(1);
        String str_ing[] = bundle.getString("ingredients").substring(1,bundle.getString("ingredients").length()-1).split(",");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_ing);
        lwIngredients.setAdapter(adapter);


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

    public void putData() throws SQLException {
       /* RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        String[] myStringArray = {"a","b","c"};
        service.saveOrder("1","1",myStringArray,myStringArray).enqueue(new Callback<List<OrderLocal>>() {

            @Override
            public void onResponse(Call<List<OrderLocal>> call, Response<List<OrderLocal>> response) {
                Log.i("working","Funcionó");
            }

            @Override
            public void onFailure(Call<List<OrderLocal>> call, Throwable t) {
                Log.e("not working","no funcionó");
            }
        });*/

        this.context=context;
        helper = OpenHelperManager.getHelper(this.context,DBhelper.class);
        SharedPreferences sharedPreferences = getSharedPreferences("PreferencesTuPedido", Context.MODE_PRIVATE);


        ordersDao = helper.getOrdersDao();
            OrderLocal order = new OrderLocal();
            order.setName(name);
            order.setDevice(sharedPreferences.getString("device",null));
            order.setType("1");
            order.setQuantity(numberPicker.getValue());
            order.setPrice(price*numberPicker.getValue());
            ordersDao.create(order);
            Toast.makeText(getBaseContext(), "Agregado al Carrito de Pedidos", Toast.LENGTH_LONG).show();
            finish();



        /*List<OrderLocal> ordenes =ordersDao.queryForAll();
        String registroOrdenes="";
        for(OrderLocal order1 : ordenes){
            registroOrdenes += "(" +order1.get_id() +","+ order1.getName() +","+order1.getDevice() +","+ order1.getType()+","+order1.getPrice()+")";

        }
        System.out.println(registroOrdenes);*/
    }
}
