package com.niit.duyanh.ketquaxoso;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.niit.duyanh.ketquaxoso.models.SoiCau;

import java.util.ArrayList;

/**
 * Created by DuyAnh on 19/07/2016.
 */
public class SoiCauActivity extends Activity {

    private ListView lstSoiCau;

    private ArrayList<SoiCau> arrSoiCau;

    private ArrayAdapter<SoiCau> adapterSoiCau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_soicau);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        lstSoiCau =(ListView)this.findViewById(R.id.lstSoiCau);

        arrSoiCau = new ArrayList<>();

        adapterSoiCau = new ArrayAdapter<SoiCau>(getApplicationContext(),R.layout.soicau_item_template,arrSoiCau);

        lstSoiCau.setAdapter(adapterSoiCau);

        dataSoiCau();

    }

    private void dataSoiCau(){
            SoiCau sc;
        sc =new SoiCau("","Cầu loto","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu loto bạch thủ","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu giải đặc biệt","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu giải đặc biệt thứ","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu loto tam giác","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu loto theo thứ","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu loto bạch thủ thứ","");
        arrSoiCau.add(sc);

        sc = new SoiCau("","Cầu ăn 2 nháy","");
        arrSoiCau.add(sc);

        adapterSoiCau.notifyDataSetChanged();
    }
}
