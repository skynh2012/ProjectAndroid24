package com.niit.duyanh.ketquaxoso;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.niit.duyanh.ketquaxoso.models.SoiCau;
import com.niit.duyanh.ketquaxoso.adapters.soiCauAdapter;

import java.util.ArrayList;

/**
 * Created by DuyAnh on 19/07/2016.
 */
public class SoiCauActivity extends AppCompatActivity {

    private ListView lstSoiCau;

    private ArrayList<SoiCau> arrSoiCau;

    private soiCauAdapter adapterSoiCau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soicau);

        ActionBar ac = getSupportActionBar();

        ac.setDisplayHomeAsUpEnabled(true);

        ac.setTitle("Soi cầu xổ số");

        lstSoiCau = (ListView) this.findViewById(R.id.lstSoiCauLo);

        arrSoiCau = new ArrayList<>();

        adapterSoiCau = new soiCauAdapter(SoiCauActivity.this, R.layout.soicau_item_template, arrSoiCau);

        lstSoiCau.setAdapter(adapterSoiCau);

        dataSoiCau();

    }

    private void dataSoiCau() {
        SoiCau sc;
        sc = new SoiCau("R.mipmap.icon", "Cầu loto", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu loto bạch thủ", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu giải đặc biệt", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu giải đặc biệt thứ", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu ăn 2 nháy", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu loto tam giác", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu loto theo thứ", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu loto bạch thủ thứ", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu loại loto", "R.mipmap.icon");
        arrSoiCau.add(sc);

        sc = new SoiCau("R.mipmap.icon", "Cầu loại loto bạch thủ", "R.mipmap.icon");
        arrSoiCau.add(sc);

        adapterSoiCau.notifyDataSetChanged();
    }
}
