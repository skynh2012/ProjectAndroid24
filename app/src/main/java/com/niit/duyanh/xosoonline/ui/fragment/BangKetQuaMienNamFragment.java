package com.niit.duyanh.xosoonline.ui.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.niit.duyanh.xosoonline.R;
import com.niit.duyanh.xosoonline.database.tinhThanhdbManager;


/**
 * Created by Duy Anh on 15/08/2016.
 */
public class BangKetQuaMienNamFragment extends Fragment {

    private TextView tvHeaderMienNam;

    private TextView tvTinh1, tvTinh2, tvTinh3, tvTinh4, tvDauTinh1, tvDauTinh2, tvDauTinh3, tvDauTinh4;

    private TextView tvTinh1G0, tvTinh1G1, tvTinh1G2, tvTinh1G3, tvTinh1G4, tvTinh1G5, tvTinh1G6, tvTinh1G7, tvTinh1G8;

    private TextView tvTinh2G0, tvTinh2G1, tvTinh2G2, tvTinh2G3, tvTinh2G4, tvTinh2G5, tvTinh2G6, tvTinh2G7, tvTinh2G8;

    private TextView tvTinh3G0, tvTinh3G1, tvTinh3G2, tvTinh3G3, tvTinh3G4, tvTinh3G5, tvTinh3G6, tvTinh3G7, tvTinh3G8;

    private TextView tvTinh4G0, tvTinh4G1, tvTinh4G2, tvTinh4G3, tvTinh4G4, tvTinh4G5, tvTinh4G6, tvTinh4G7, tvTinh4G8;

    private TextView tvDauTinh1D0, tvDauTinh1D1, tvDauTinh1D2, tvDauTinh1D3, tvDauTinh1D4, tvDauTinh1D5, tvDauTinh1D6, tvDauTinh1D7, tvDauTinh1D8, tvDauTinh1D9;

    private TextView tvDauTinh2D0, tvDauTinh2D1, tvDauTinh2D2, tvDauTinh2D3, tvDauTinh2D4, tvDauTinh2D5, tvDauTinh2D6, tvDauTinh2D7, tvDauTinh2D8, tvDauTinh2D9;

    private TextView tvDauTinh3D0, tvDauTinh3D1, tvDauTinh3D2, tvDauTinh3D3, tvDauTinh3D4, tvDauTinh3D5, tvDauTinh3D6, tvDauTinh3D7, tvDauTinh3D8, tvDauTinh3D9;

    private TextView tvDauTinh4D0, tvDauTinh4D1, tvDauTinh4D2, tvDauTinh4D3, tvDauTinh4D4, tvDauTinh4D5, tvDauTinh4D6, tvDauTinh4D7, tvDauTinh4D8, tvDauTinh4D9;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mienNam = inflater.inflate(R.layout.fragment_bangketqua_miennam, container, false);

        findViewId(mienNam);
        SetKetQua();
        return mienNam;
    }

    private void findViewId(View view) {

        tvHeaderMienNam = (TextView) view.findViewById(R.id.tvHeaderMienNam);

        tvTinh1 = (TextView) view.findViewById(R.id.tvTinh1);
        tvTinh2 = (TextView) view.findViewById(R.id.tvTinh2);
        tvTinh3 = (TextView) view.findViewById(R.id.tvTinh3);
        tvTinh4 = (TextView) view.findViewById(R.id.tvTinh4);

        tvDauTinh1 = (TextView) view.findViewById(R.id.tvDauTinh1);
        tvDauTinh2 = (TextView) view.findViewById(R.id.tvDauTinh2);
        tvDauTinh3 = (TextView) view.findViewById(R.id.tvDauTinh3);
        tvDauTinh4 = (TextView) view.findViewById(R.id.tvDauTinh4);

        tvTinh1G0 = (TextView) view.findViewById(R.id.tvTinh1G0);
        tvTinh1G1 = (TextView) view.findViewById(R.id.tvTinh1G1);
        tvTinh1G2 = (TextView) view.findViewById(R.id.tvTinh1G2);
        tvTinh1G3 = (TextView) view.findViewById(R.id.tvTinh1G3);
        tvTinh1G4 = (TextView) view.findViewById(R.id.tvTinh1G4);
        tvTinh1G5 = (TextView) view.findViewById(R.id.tvTinh1G5);
        tvTinh1G6 = (TextView) view.findViewById(R.id.tvTinh1G6);
        tvTinh1G7 = (TextView) view.findViewById(R.id.tvTinh1G7);
        tvTinh1G8 = (TextView) view.findViewById(R.id.tvTinh1G8);

        tvTinh2G0 = (TextView) view.findViewById(R.id.tvTinh2G0);
        tvTinh2G1 = (TextView) view.findViewById(R.id.tvTinh2G1);
        tvTinh2G2 = (TextView) view.findViewById(R.id.tvTinh2G2);
        tvTinh2G3 = (TextView) view.findViewById(R.id.tvTinh2G3);
        tvTinh2G4 = (TextView) view.findViewById(R.id.tvTinh2G4);
        tvTinh2G5 = (TextView) view.findViewById(R.id.tvTinh2G5);
        tvTinh2G6 = (TextView) view.findViewById(R.id.tvTinh2G6);
        tvTinh2G7 = (TextView) view.findViewById(R.id.tvTinh2G7);
        tvTinh2G8 = (TextView) view.findViewById(R.id.tvTinh2G8);

        tvTinh3G0 = (TextView) view.findViewById(R.id.tvTinh3G0);
        tvTinh3G1 = (TextView) view.findViewById(R.id.tvTinh3G1);
        tvTinh3G2 = (TextView) view.findViewById(R.id.tvTinh3G2);
        tvTinh3G3 = (TextView) view.findViewById(R.id.tvTinh3G3);
        tvTinh3G4 = (TextView) view.findViewById(R.id.tvTinh3G4);
        tvTinh3G5 = (TextView) view.findViewById(R.id.tvTinh3G5);
        tvTinh3G6 = (TextView) view.findViewById(R.id.tvTinh3G6);
        tvTinh3G7 = (TextView) view.findViewById(R.id.tvTinh3G7);
        tvTinh3G8 = (TextView) view.findViewById(R.id.tvTinh3G8);

        tvTinh4G0 = (TextView) view.findViewById(R.id.tvTinh4G0);
        tvTinh4G1 = (TextView) view.findViewById(R.id.tvTinh4G1);
        tvTinh4G2 = (TextView) view.findViewById(R.id.tvTinh4G2);
        tvTinh4G3 = (TextView) view.findViewById(R.id.tvTinh4G3);
        tvTinh4G4 = (TextView) view.findViewById(R.id.tvTinh4G4);
        tvTinh4G5 = (TextView) view.findViewById(R.id.tvTinh4G5);
        tvTinh4G6 = (TextView) view.findViewById(R.id.tvTinh4G6);
        tvTinh4G7 = (TextView) view.findViewById(R.id.tvTinh4G7);
        tvTinh4G8 = (TextView) view.findViewById(R.id.tvTinh4G8);

        tvDauTinh1D0 = (TextView) view.findViewById(R.id.tvDauTinh1D0);
        tvDauTinh1D1 = (TextView) view.findViewById(R.id.tvDauTinh1D1);
        tvDauTinh1D2 = (TextView) view.findViewById(R.id.tvDauTinh1D2);
        tvDauTinh1D3 = (TextView) view.findViewById(R.id.tvDauTinh1D3);
        tvDauTinh1D4 = (TextView) view.findViewById(R.id.tvDauTinh1D4);
        tvDauTinh1D5 = (TextView) view.findViewById(R.id.tvDauTinh1D5);
        tvDauTinh1D6 = (TextView) view.findViewById(R.id.tvDauTinh1D6);
        tvDauTinh1D7 = (TextView) view.findViewById(R.id.tvDauTinh1D7);
        tvDauTinh1D8 = (TextView) view.findViewById(R.id.tvDauTinh1D8);
        tvDauTinh1D9 = (TextView) view.findViewById(R.id.tvDauTinh1D9);

        tvDauTinh2D0 = (TextView) view.findViewById(R.id.tvDauTinh2D0);
        tvDauTinh2D1 = (TextView) view.findViewById(R.id.tvDauTinh2D1);
        tvDauTinh2D2 = (TextView) view.findViewById(R.id.tvDauTinh2D2);
        tvDauTinh2D3 = (TextView) view.findViewById(R.id.tvDauTinh2D3);
        tvDauTinh2D4 = (TextView) view.findViewById(R.id.tvDauTinh2D4);
        tvDauTinh2D5 = (TextView) view.findViewById(R.id.tvDauTinh2D5);
        tvDauTinh2D6 = (TextView) view.findViewById(R.id.tvDauTinh2D6);
        tvDauTinh2D7 = (TextView) view.findViewById(R.id.tvDauTinh2D7);
        tvDauTinh2D8 = (TextView) view.findViewById(R.id.tvDauTinh2D8);
        tvDauTinh2D9 = (TextView) view.findViewById(R.id.tvDauTinh2D9);

        tvDauTinh3D0 = (TextView) view.findViewById(R.id.tvDauTinh3D0);
        tvDauTinh3D1 = (TextView) view.findViewById(R.id.tvDauTinh3D1);
        tvDauTinh3D2 = (TextView) view.findViewById(R.id.tvDauTinh3D2);
        tvDauTinh3D3 = (TextView) view.findViewById(R.id.tvDauTinh3D3);
        tvDauTinh3D4 = (TextView) view.findViewById(R.id.tvDauTinh3D4);
        tvDauTinh3D5 = (TextView) view.findViewById(R.id.tvDauTinh3D5);
        tvDauTinh3D6 = (TextView) view.findViewById(R.id.tvDauTinh3D6);
        tvDauTinh3D7 = (TextView) view.findViewById(R.id.tvDauTinh3D7);
        tvDauTinh3D8 = (TextView) view.findViewById(R.id.tvDauTinh3D8);
        tvDauTinh3D9 = (TextView) view.findViewById(R.id.tvDauTinh3D9);

        tvDauTinh4D0 = (TextView) view.findViewById(R.id.tvDauTinh4D0);
        tvDauTinh4D1 = (TextView) view.findViewById(R.id.tvDauTinh4D1);
        tvDauTinh4D2 = (TextView) view.findViewById(R.id.tvDauTinh4D2);
        tvDauTinh4D3 = (TextView) view.findViewById(R.id.tvDauTinh4D3);
        tvDauTinh4D4 = (TextView) view.findViewById(R.id.tvDauTinh4D4);
        tvDauTinh4D5 = (TextView) view.findViewById(R.id.tvDauTinh4D5);
        tvDauTinh4D6 = (TextView) view.findViewById(R.id.tvDauTinh4D6);
        tvDauTinh4D7 = (TextView) view.findViewById(R.id.tvDauTinh4D7);
        tvDauTinh4D8 = (TextView) view.findViewById(R.id.tvDauTinh4D8);
        tvDauTinh4D9 = (TextView) view.findViewById(R.id.tvDauTinh4D9);

    }

    private void SetKetQua() {
        Bundle bundle = getArguments();

        if (bundle != null) {

            String ngay = bundle.getString("ngay");

            tvHeaderMienNam.setText("Xổ số Miền Nam " + ngay);

            if (bundle.get("ketqua0") != null && bundle.get("tinh0") != null) {
                String ketqua = bundle.getString("ketqua0");

                String matinh = bundle.getString("tinh0");

                String tentinh = getTenTinh(matinh.trim());

                JsonParser parser = new JsonParser();

                JsonElement jsonElement = parser.parse(ketqua);

                JsonArray jsonArray = jsonElement.getAsJsonArray();

                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

                tvTinh1.setText(tentinh);

                tvTinh1G0.setText(convertGiai(jsonObject.get("g0").getAsString()));
                tvTinh1G1.setText(convertGiai(jsonObject.get("g1").getAsString()));
                tvTinh1G2.setText(convertGiai(jsonObject.get("g2").getAsString()));
                tvTinh1G3.setText(convertGiai(jsonObject.get("g3").getAsString()));
                tvTinh1G4.setText(convertGiai(jsonObject.get("g4").getAsString()));
                tvTinh1G5.setText(convertGiai(jsonObject.get("g5").getAsString()));
                tvTinh1G6.setText(convertGiai(jsonObject.get("g6").getAsString()));
                tvTinh1G7.setText(convertGiai(jsonObject.get("g7").getAsString()));
                tvTinh1G8.setText(convertGiai(jsonObject.get("g8").getAsString()));


                JsonArray dau = jsonObject.getAsJsonArray("dau");

                tvDauTinh1.setText(tentinh);

                tvDauTinh1D0.setText(dau.get(0).getAsString());
                tvDauTinh1D1.setText(dau.get(1).getAsString());
                tvDauTinh1D2.setText(dau.get(2).getAsString());
                tvDauTinh1D3.setText(dau.get(3).getAsString());
                tvDauTinh1D4.setText(dau.get(4).getAsString());
                tvDauTinh1D5.setText(dau.get(5).getAsString());
                tvDauTinh1D6.setText(dau.get(6).getAsString());
                tvDauTinh1D7.setText(dau.get(7).getAsString());
                tvDauTinh1D8.setText(dau.get(8).getAsString());
                tvDauTinh1D9.setText(dau.get(9).getAsString());

            } else {
                setGoneTinh1();
            }
            if (bundle.get("ketqua1") != null && bundle.get("tinh1") != null) {
                String ketqua = bundle.getString("ketqua1");

                String matinh = bundle.getString("tinh1");

                String tentinh = getTenTinh(matinh.trim());

                JsonParser parser = new JsonParser();

                JsonElement jsonElement = parser.parse(ketqua);

                JsonArray jsonArray = jsonElement.getAsJsonArray();

                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

                tvTinh2.setText(tentinh);

                tvTinh2G0.setText(convertGiai(jsonObject.get("g0").getAsString()));
                tvTinh2G1.setText(convertGiai(jsonObject.get("g1").getAsString()));
                tvTinh2G2.setText(convertGiai(jsonObject.get("g2").getAsString()));
                tvTinh2G3.setText(convertGiai(jsonObject.get("g3").getAsString()));
                tvTinh2G4.setText(convertGiai(jsonObject.get("g4").getAsString()));
                tvTinh2G5.setText(convertGiai(jsonObject.get("g5").getAsString()));
                tvTinh2G6.setText(convertGiai(jsonObject.get("g6").getAsString()));
                tvTinh2G7.setText(convertGiai(jsonObject.get("g7").getAsString()));
                tvTinh2G8.setText(convertGiai(jsonObject.get("g8").getAsString()));


                JsonArray dau = jsonObject.getAsJsonArray("dau");

                tvDauTinh2.setText(tentinh);

                tvDauTinh2D0.setText(dau.get(0).getAsString());
                tvDauTinh2D1.setText(dau.get(1).getAsString());
                tvDauTinh2D2.setText(dau.get(2).getAsString());
                tvDauTinh2D3.setText(dau.get(3).getAsString());
                tvDauTinh2D4.setText(dau.get(4).getAsString());
                tvDauTinh2D5.setText(dau.get(5).getAsString());
                tvDauTinh2D6.setText(dau.get(6).getAsString());
                tvDauTinh2D7.setText(dau.get(7).getAsString());
                tvDauTinh2D8.setText(dau.get(8).getAsString());
                tvDauTinh2D9.setText(dau.get(9).getAsString());
            } else {
                setGoneTinh2();
            }

            if (bundle.get("ketqua2") != null && bundle.get("tinh2") != null) {
                String ketqua = bundle.getString("ketqua2");

                String matinh = bundle.getString("tinh2");

                String tentinh = getTenTinh(matinh.trim());

                JsonParser parser = new JsonParser();

                JsonElement jsonElement = parser.parse(ketqua);

                JsonArray jsonArray = jsonElement.getAsJsonArray();

                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

                tvTinh3.setText(tentinh);

                tvTinh3G0.setText(convertGiai(jsonObject.get("g0").getAsString()));
                tvTinh3G1.setText(convertGiai(jsonObject.get("g1").getAsString()));
                tvTinh3G2.setText(convertGiai(jsonObject.get("g2").getAsString()));
                tvTinh3G3.setText(convertGiai(jsonObject.get("g3").getAsString()));
                tvTinh3G4.setText(convertGiai(jsonObject.get("g4").getAsString()));
                tvTinh3G5.setText(convertGiai(jsonObject.get("g5").getAsString()));
                tvTinh3G6.setText(convertGiai(jsonObject.get("g6").getAsString()));
                tvTinh3G7.setText(convertGiai(jsonObject.get("g7").getAsString()));
                tvTinh3G8.setText(convertGiai(jsonObject.get("g8").getAsString()));


                JsonArray dau = jsonObject.getAsJsonArray("dau");

                tvDauTinh3.setText(tentinh);

                tvDauTinh3D0.setText(dau.get(0).getAsString());
                tvDauTinh3D1.setText(dau.get(1).getAsString());
                tvDauTinh3D2.setText(dau.get(2).getAsString());
                tvDauTinh3D3.setText(dau.get(3).getAsString());
                tvDauTinh3D4.setText(dau.get(4).getAsString());
                tvDauTinh3D5.setText(dau.get(5).getAsString());
                tvDauTinh3D6.setText(dau.get(6).getAsString());
                tvDauTinh3D7.setText(dau.get(7).getAsString());
                tvDauTinh3D8.setText(dau.get(8).getAsString());
                tvDauTinh3D9.setText(dau.get(9).getAsString());
            } else {
                setGoneTinh3();
            }

            if (bundle.get("ketqua3") != null && bundle.get("tinh3") != null) {
                String ketqua = bundle.getString("ketqua3");

                String matinh = bundle.getString("tinh3");

                String tentinh = getTenTinh(matinh.trim());

                JsonParser parser = new JsonParser();

                JsonElement jsonElement = parser.parse(ketqua);

                JsonArray jsonArray = jsonElement.getAsJsonArray();

                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

                tvTinh4.setText(tentinh);

                tvTinh4G0.setText(convertGiai(jsonObject.get("g0").getAsString()));
                tvTinh4G1.setText(convertGiai(jsonObject.get("g1").getAsString()));
                tvTinh4G2.setText(convertGiai(jsonObject.get("g2").getAsString()));
                tvTinh4G3.setText(convertGiai(jsonObject.get("g3").getAsString()));
                tvTinh4G4.setText(convertGiai(jsonObject.get("g4").getAsString()));
                tvTinh4G5.setText(convertGiai(jsonObject.get("g5").getAsString()));
                tvTinh4G6.setText(convertGiai(jsonObject.get("g6").getAsString()));
                tvTinh4G7.setText(convertGiai(jsonObject.get("g7").getAsString()));
                tvTinh4G8.setText(convertGiai(jsonObject.get("g8").getAsString()));


                JsonArray dau = jsonObject.getAsJsonArray("dau");

                tvDauTinh4.setText(tentinh);

                tvDauTinh4D0.setText(dau.get(0).getAsString());
                tvDauTinh4D1.setText(dau.get(1).getAsString());
                tvDauTinh4D2.setText(dau.get(2).getAsString());
                tvDauTinh4D3.setText(dau.get(3).getAsString());
                tvDauTinh4D4.setText(dau.get(4).getAsString());
                tvDauTinh4D5.setText(dau.get(5).getAsString());
                tvDauTinh4D6.setText(dau.get(6).getAsString());
                tvDauTinh4D7.setText(dau.get(7).getAsString());
                tvDauTinh4D8.setText(dau.get(8).getAsString());
                tvDauTinh4D9.setText(dau.get(9).getAsString());
            } else {
                setGoneTinh4();
            }
        }

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

    private void setGoneTinh1() {
        tvTinh1.setVisibility(View.GONE);
        tvTinh1G0.setVisibility(View.GONE);
        tvTinh1G1.setVisibility(View.GONE);
        tvTinh1G2.setVisibility(View.GONE);
        tvTinh1G3.setVisibility(View.GONE);
        tvTinh1G4.setVisibility(View.GONE);
        tvTinh1G5.setVisibility(View.GONE);
        tvTinh1G6.setVisibility(View.GONE);
        tvTinh1G7.setVisibility(View.GONE);
        tvTinh1G8.setVisibility(View.GONE);

        tvDauTinh1.setVisibility(View.GONE);
        tvDauTinh1D0.setVisibility(View.GONE);
        tvDauTinh1D1.setVisibility(View.GONE);
        tvDauTinh1D2.setVisibility(View.GONE);
        tvDauTinh1D3.setVisibility(View.GONE);
        tvDauTinh1D4.setVisibility(View.GONE);
        tvDauTinh1D5.setVisibility(View.GONE);
        tvDauTinh1D6.setVisibility(View.GONE);
        tvDauTinh1D7.setVisibility(View.GONE);
        tvDauTinh1D8.setVisibility(View.GONE);
        tvDauTinh1D9.setVisibility(View.GONE);
    }

    private void setGoneTinh2() {
        tvTinh2.setVisibility(View.GONE);
        tvTinh2G0.setVisibility(View.GONE);
        tvTinh2G1.setVisibility(View.GONE);
        tvTinh2G2.setVisibility(View.GONE);
        tvTinh2G3.setVisibility(View.GONE);
        tvTinh2G4.setVisibility(View.GONE);
        tvTinh2G5.setVisibility(View.GONE);
        tvTinh2G6.setVisibility(View.GONE);
        tvTinh2G7.setVisibility(View.GONE);
        tvTinh2G8.setVisibility(View.GONE);

        tvDauTinh2.setVisibility(View.GONE);
        tvDauTinh2D0.setVisibility(View.GONE);
        tvDauTinh2D1.setVisibility(View.GONE);
        tvDauTinh2D2.setVisibility(View.GONE);
        tvDauTinh2D3.setVisibility(View.GONE);
        tvDauTinh2D4.setVisibility(View.GONE);
        tvDauTinh2D5.setVisibility(View.GONE);
        tvDauTinh2D6.setVisibility(View.GONE);
        tvDauTinh2D7.setVisibility(View.GONE);
        tvDauTinh2D8.setVisibility(View.GONE);
        tvDauTinh2D9.setVisibility(View.GONE);

    }

    private void setGoneTinh3() {
        tvTinh3.setVisibility(View.GONE);
        tvTinh3G0.setVisibility(View.GONE);
        tvTinh3G1.setVisibility(View.GONE);
        tvTinh3G2.setVisibility(View.GONE);
        tvTinh3G3.setVisibility(View.GONE);
        tvTinh3G4.setVisibility(View.GONE);
        tvTinh3G5.setVisibility(View.GONE);
        tvTinh3G6.setVisibility(View.GONE);
        tvTinh3G7.setVisibility(View.GONE);
        tvTinh3G8.setVisibility(View.GONE);

        tvDauTinh3.setVisibility(View.GONE);
        tvDauTinh3D0.setVisibility(View.GONE);
        tvDauTinh3D1.setVisibility(View.GONE);
        tvDauTinh3D2.setVisibility(View.GONE);
        tvDauTinh3D3.setVisibility(View.GONE);
        tvDauTinh3D4.setVisibility(View.GONE);
        tvDauTinh3D5.setVisibility(View.GONE);
        tvDauTinh3D6.setVisibility(View.GONE);
        tvDauTinh3D7.setVisibility(View.GONE);
        tvDauTinh3D8.setVisibility(View.GONE);
        tvDauTinh3D9.setVisibility(View.GONE);
    }

    private void setGoneTinh4() {
        tvTinh4.setVisibility(View.GONE);
        tvTinh4G0.setVisibility(View.GONE);
        tvTinh4G1.setVisibility(View.GONE);
        tvTinh4G2.setVisibility(View.GONE);
        tvTinh4G3.setVisibility(View.GONE);
        tvTinh4G4.setVisibility(View.GONE);
        tvTinh4G5.setVisibility(View.GONE);
        tvTinh4G6.setVisibility(View.GONE);
        tvTinh4G7.setVisibility(View.GONE);
        tvTinh4G8.setVisibility(View.GONE);

        tvDauTinh4.setVisibility(View.GONE);
        tvDauTinh4D0.setVisibility(View.GONE);
        tvDauTinh4D1.setVisibility(View.GONE);
        tvDauTinh4D2.setVisibility(View.GONE);
        tvDauTinh4D3.setVisibility(View.GONE);
        tvDauTinh4D4.setVisibility(View.GONE);
        tvDauTinh4D5.setVisibility(View.GONE);
        tvDauTinh4D6.setVisibility(View.GONE);
        tvDauTinh4D7.setVisibility(View.GONE);
        tvDauTinh4D8.setVisibility(View.GONE);
        tvDauTinh4D9.setVisibility(View.GONE);
    }

    private String convertGiai(String Giai) {
        String result = "";

        String[] arr = Giai.split("[-]");

        for (String str : arr) {
            result += str + "\r\n";
        }
        return result;
    }
}
