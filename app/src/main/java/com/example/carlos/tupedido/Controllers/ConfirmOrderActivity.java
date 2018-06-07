package com.example.carlos.tupedido.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlos.tupedido.R;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class ConfirmOrderActivity extends AppCompatActivity {
    ExpandableRelativeLayout expand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        expand = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        System.out.println("log "+expand.isExpanded());
    }
}
