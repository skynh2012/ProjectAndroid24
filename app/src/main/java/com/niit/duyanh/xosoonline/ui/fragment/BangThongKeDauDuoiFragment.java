package com.niit.duyanh.xosoonline.ui.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.niit.duyanh.xosoonline.R;


import java.text.SimpleDateFormat;

import com.niit.duyanh.xosoonline.app.BaseApplication;
import com.niit.duyanh.xosoonline.database.tinhThanhdbManager;

/**
 * Created by Duy Anh on 09/08/2016.
 */
public class BangThongKeDauDuoiFragment extends Fragment {
    private TextView tvHeaderDauDuoi, tvDau0, tvDau1, tvDau2, tvDau3, tvDau4, tvDau5, tvDau6, tvDau7, tvDau8, tvDau9, tvDuoi0, tvDuoi1, tvDuoi2, tvDuoi3, tvDuoi4, tvDuoi5, tvDuoi6, tvDuoi7, tvDuoi8, tvDuoi9;
    private LinearLayout lnThongKeDau, lnThongKeDuoi;

    private LinearLayout lnDauDuoi;
    private SimpleDateFormat dateFormat;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View dauduoiView = inflater.inflate(R.layout.fragment_bangthongke_dauduoi, container, false);

        findId(dauduoiView);

        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Bundle bundle = getArguments();

        if (bundle != null) {
            if (bundle.get("ngay") != null) {
                if (bundle.get("matinh") != null) {
                    String tentinh = getTenTinh(bundle.getString("matinh"));
                    String ngay = bundle.get("ngay").toString();
                }
            }
            if (bundle.get("dau") != null) {
                String dau = bundle.getString("dau");

                JsonParser parser = new JsonParser();

                JsonElement jsonElement = parser.parse(dau);

                JsonArray jsonArray = jsonElement.getAsJsonArray();

                tvDau0.setText(jsonArray.get(0).getAsString());
                tvDau1.setText(jsonArray.get(1).getAsString());
                tvDau2.setText(jsonArray.get(2).getAsString());
                tvDau3.setText(jsonArray.get(3).getAsString());
                tvDau4.setText(jsonArray.get(4).getAsString());
                tvDau5.setText(jsonArray.get(5).getAsString());
                tvDau6.setText(jsonArray.get(6).getAsString());
                tvDau7.setText(jsonArray.get(7).getAsString());
                tvDau8.setText(jsonArray.get(8).getAsString());
                tvDau9.setText(jsonArray.get(9).getAsString());
            } else {
                lnThongKeDau.setVisibility(View.GONE);
            }
            if (bundle.get("duoi") != null) {
                String duoi = bundle.getString("duoi");

                JsonParser parser = new JsonParser();

                JsonElement jsonElement = parser.parse(duoi);

                JsonArray jsonArray = jsonElement.getAsJsonArray();

                tvDuoi0.setText(jsonArray.get(0).getAsString());
                tvDuoi1.setText(jsonArray.get(1).getAsString());
                tvDuoi2.setText(jsonArray.get(2).getAsString());
                tvDuoi3.setText(jsonArray.get(3).getAsString());
                tvDuoi4.setText(jsonArray.get(4).getAsString());
                tvDuoi5.setText(jsonArray.get(5).getAsString());
                tvDuoi6.setText(jsonArray.get(6).getAsString());
                tvDuoi7.setText(jsonArray.get(7).getAsString());
                tvDuoi8.setText(jsonArray.get(8).getAsString());
                tvDuoi9.setText(jsonArray.get(9).getAsString());
            } else {
                lnThongKeDuoi.setVisibility(View.GONE);
            }
        }


        return dauduoiView;
    }

    private void findId(View view) {
        tvDau0 = (TextView) view.findViewById(R.id.tvDau0);
        tvDau1 = (TextView) view.findViewById(R.id.tvDau1);
        tvDau2 = (TextView) view.findViewById(R.id.tvDau2);
        tvDau3 = (TextView) view.findViewById(R.id.tvDau3);
        tvDau4 = (TextView) view.findViewById(R.id.tvDau4);
        tvDau5 = (TextView) view.findViewById(R.id.tvDau5);
        tvDau6 = (TextView) view.findViewById(R.id.tvDau6);
        tvDau7 = (TextView) view.findViewById(R.id.tvDau7);
        tvDau8 = (TextView) view.findViewById(R.id.tvDau8);
        tvDau9 = (TextView) view.findViewById(R.id.tvDau9);

        tvDuoi0 = (TextView) view.findViewById(R.id.tvDuoi0);
        tvDuoi1 = (TextView) view.findViewById(R.id.tvDuoi1);
        tvDuoi2 = (TextView) view.findViewById(R.id.tvDuoi2);
        tvDuoi3 = (TextView) view.findViewById(R.id.tvDuoi3);
        tvDuoi4 = (TextView) view.findViewById(R.id.tvDuoi4);
        tvDuoi5 = (TextView) view.findViewById(R.id.tvDuoi5);
        tvDuoi6 = (TextView) view.findViewById(R.id.tvDuoi6);
        tvDuoi7 = (TextView) view.findViewById(R.id.tvDuoi7);
        tvDuoi8 = (TextView) view.findViewById(R.id.tvDuoi8);
        tvDuoi9 = (TextView) view.findViewById(R.id.tvDuoi9);

        lnDauDuoi = (LinearLayout) view.findViewById(R.id.lnDauDuoi);
        lnThongKeDau = (LinearLayout) view.findViewById(R.id.lnThongKeDau);
        lnThongKeDuoi = (LinearLayout) view.findViewById(R.id.lnThongKeDuoi);
        tvHeaderDauDuoi = (TextView) view.findViewById(R.id.tvHeaderDauDuoi);
    }

    private String getTenTinh(String matinh) {

        String result = "";

        tinhThanhdbManager dbManager = new tinhThanhdbManager(getContext());

        Cursor sor = dbManager.getListTinhThanh();

        if (sor.getCount() <= 0) {
            dbManager.insertDataTinhThanh();
        }


        Cursor cursor = dbManager.getTenTinh(matinh);

        while (cursor.moveToNext()) {
            result += cursor.getString(cursor.getColumnIndex("tentinh"));
        }


        return result;
    }
}
