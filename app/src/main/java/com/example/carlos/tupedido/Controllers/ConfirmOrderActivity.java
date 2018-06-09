package com.example.carlos.tupedido.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.carlos.tupedido.Adapters.ItemOrder;
import com.example.carlos.tupedido.DB.DBhelper;
import com.example.carlos.tupedido.Model.OrderLocal;
import com.example.carlos.tupedido.R;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class ConfirmOrderActivity extends AppCompatActivity {
    private DBhelper helper;
    private Dao<OrderLocal,Integer> orderLocalIntegerDao;
    private ItemOrder adapter;
    private ListView lwProducts;
    private List<String[]> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        lwProducts = (ListView) findViewById(R.id.lw_confirm_order);
        helper = OpenHelperManager.getHelper(getBaseContext(), DBhelper.class);
        try {
            orderLocalIntegerDao = helper.getOrdersDao();
            productos = orderLocalIntegerDao.queryRaw("SELECT device, name, price, quantity from orderLocal"
                    + " ORDER BY type ASC").getResults();
            adapter = new ItemOrder(this, productos,null);
            lwProducts.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
