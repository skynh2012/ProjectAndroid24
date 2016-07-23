package com.niit.duyanh.ketquaxoso;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DuyAnh on 22/07/2016.
 */
public class SoKetQuaActivity extends AppCompatActivity {

    private EditText edtXemKetQuaNgay;

    private Spinner spnTinh;

    private RadioGroup rdgCheDoXem;

    private ArrayList<String> arrTinh;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soketqua);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Xổ kết quả");

        edtXemKetQuaNgay = (EditText) findViewById(R.id.edtXemKetQua);

        Date date =new Date();

        edtXemKetQuaNgay.setText(""+date.toString());

        spnTinh = (Spinner) findViewById(R.id.snpTinhThanh);

        arrTinh = new ArrayList<>();

        adapter = new ArrayAdapter<String>(SoKetQuaActivity.this, android.R.layout.simple_spinner_item, arrTinh);

        spnTinh.setAdapter(adapter);

        dataTinhThanh();
    }

    private void dataTinhThanh() {
        arrTinh.add("Truyền thống");
        arrTinh.add("Bình định");
        arrTinh.add("Khánh hòa");
        arrTinh.add("Quy nhơn");
        arrTinh.add("Cà mau");

        adapter.notifyDataSetChanged();
    }
}
