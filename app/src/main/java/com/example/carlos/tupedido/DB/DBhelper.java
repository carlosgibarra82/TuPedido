package com.example.carlos.tupedido.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.carlos.tupedido.Model.Orders;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBhelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "Tupedido.db";
    private static final int DATABASE_VERSION = 1;

    private Context context;

    private Dao<Orders, Integer> ordersDao;


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSouce) {
        try {
            TableUtils.createTable(connectionSouce, Orders.class);
            new InitilizeDb(this.context);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Orders, Integer> getOrdersDao() throws SQLException {
        if (ordersDao == null) {
            ordersDao = getDao(Orders.class);
        }
        return ordersDao;
    }

    @Override
    public void close(){
        super.close();
        ordersDao = null;
    }
}
