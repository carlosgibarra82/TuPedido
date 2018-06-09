package com.example.carlos.tupedido.DB;

import android.content.Context;
import android.widget.Toast;

import com.example.carlos.tupedido.Model.OrderLocal;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InitilizeDb {
    private Context context;
    private DBhelper helper;
    private Dao<OrderLocal, Integer> ordersDao;


    public InitilizeDb(Context context) {
        this.context=context;
        helper = OpenHelperManager.getHelper(this.context,DBhelper.class);
        /*try {
            ordersDao = helper.getOrdersDao();
            if (ordersDao.countOf() == 0) {
                OrderLocal order = new OrderLocal();
                order.set_id(1);
                order.setName("hola");
                order.setDevice("2");
                ArrayList<String> prueba = new ArrayList<String>();
                prueba.add("A");
                prueba.add("B");
                prueba.add("C");

                order.setPrice(100);
                ordersDao.create(order);
            }

            List<OrderLocal> ordenes =ordersDao.queryForAll();
            String registroOrdenes="";
            for(OrderLocal order : ordenes){
            /*    registroOrdenes += "(" +order.get_id() +","+ order.getName() +","+order.getDevice() +","+ order.getDishes()+","+order.getDrinks()+")";

            }
            System.out.println(registroOrdenes);

        } catch (SQLException e) {
            Toast.makeText(this.context, "Error Creando Estados", Toast.LENGTH_LONG).show();
        }*/
    }
}
