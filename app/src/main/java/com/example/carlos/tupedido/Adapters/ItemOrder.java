package com.example.carlos.tupedido.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlos.tupedido.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;



public class ItemOrder extends BaseAdapter {
    protected Activity activity;
    protected List<String[]> items;
    private NumberFormat formatter = NumberFormat.getInstance(Locale.getDefault());

    public ItemOrder(Activity activity, List<String[]> items, NumberFormat formatter) {
        this.activity = activity;
        this.items = items;
        this.formatter = formatter;
    }

    @Override
    public int getCount() {
       return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.roworder, null);
        }

        String[] producto = items.get(position);

        ((TextView) vi.findViewById(R.id.txtDevice)).setText(producto[0]);

        ((TextView) vi.findViewById(R.id.txtName)).setText(producto[1]);

        ((TextView) vi.findViewById(R.id.txtPrice)).setText(producto[2]);

        ((TextView) vi.findViewById(R.id.txtQuantity)).setText(producto[3]);

        return vi;
    }
}
