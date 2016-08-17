package com.niit.duyanh.xosoonline.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.niit.duyanh.xosoonline.R;
import com.niit.duyanh.xosoonline.util.DateTimeUtil;
import com.niit.duyanh.xosoonline.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Duy Anh on 07/08/2016.
 */
public class BangKetQuaMienBacFragment extends Fragment {

    private TextView tvGiaiDacBiet, tvGiaiNhat, tvGiaiNhi1, tvGiaiNhi2, tvGiaiBa1, tvGiaiBa2, tvGiaiBa3, tvGiaiBa4, tvGiaiBa5, tvGiaiBa6, tvGiaiTu1, tvGiaiTu2, tvGiaiTu3, tvGiaiTu4, tvGiaiNam1, tvGiaiNam2, tvGiaiNam3, tvGiaiNam4, tvGiaiNam5, tvGiaiNam6, tvGiaiSau1, tvGiaiSau2, tvGiaiSau3, tvGiaiBay1, tvGiaiBay2, tvGiaiBay3, tvGiaiBay4;
    private TextView tvHeaderMienBac;
    private String xoso;
    private String ngay = "";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View bangketquamienbac = inflater.inflate(R.layout.fragment_bangketqua_mienbac, container, false);

        FindTextView(bangketquamienbac);

        Bundle bundle = getArguments();

        if (bundle != null) {
            xoso = bundle.getString("xoso");
        }

        JsonParser parser = new JsonParser();

        JsonElement jsonElement = parser.parse(xoso);

        JsonObject object = jsonElement.getAsJsonObject();

        ngay = object.get("ngay").getAsString();

        tvHeaderMienBac.setText("Xổ số " + object.get("tentinh").getAsString() + ngay);

        tvGiaiDacBiet.setText(object.get("g0").getAsString());
        tvGiaiNhat.setText(object.get("g1").getAsString());
        String[] giaiNhi = object.get("g2").getAsString().split("[-]");


        tvGiaiNhi1.setText(giaiNhi[0]);
        tvGiaiNhi2.setText(giaiNhi[1]);

        String[] giaiBa = object.get("g3").getAsString().split("[-]");

        tvGiaiBa1.setText(giaiBa[0]);
        tvGiaiBa2.setText(giaiBa[1]);
        tvGiaiBa3.setText(giaiBa[2]);
        tvGiaiBa4.setText(giaiBa[3]);
        tvGiaiBa5.setText(giaiBa[4]);
        tvGiaiBa6.setText(giaiBa[5]);

        String[] giaiTu = object.get("g4").getAsString().split("[-]");

        tvGiaiTu1.setText(giaiTu[0]);
        tvGiaiTu2.setText(giaiTu[1]);
        tvGiaiTu3.setText(giaiTu[2]);
        tvGiaiTu4.setText(giaiTu[3]);

        String[] giaiNam = object.get("g5").getAsString().split("[-]");

        tvGiaiNam1.setText(giaiNam[0]);
        tvGiaiNam2.setText(giaiNam[1]);
        tvGiaiNam3.setText(giaiNam[2]);
        tvGiaiNam4.setText(giaiNam[3]);
        tvGiaiNam5.setText(giaiNam[4]);
        tvGiaiNam6.setText(giaiNam[5]);

        String[] giaiSau = object.get("g6").getAsString().split("[-]");

        tvGiaiSau1.setText(giaiSau[0]);
        tvGiaiSau2.setText(giaiSau[1]);
        tvGiaiSau3.setText(giaiSau[2]);

        String[] giaiBay = object.get("g7").getAsString().split("[-]");

        tvGiaiBay1.setText(giaiBay[0]);
        tvGiaiBay2.setText(giaiBay[1]);
        tvGiaiBay3.setText(giaiBay[2]);
        tvGiaiBay4.setText(giaiBay[3]);

        return bangketquamienbac;
    }

    public void FindTextView(View view) {

        tvHeaderMienBac = (TextView) view.findViewById(R.id.tvHeaderMienBac);

        tvGiaiDacBiet = (TextView) view.findViewById(R.id.tvGiaiDacBiet);

        tvGiaiNhat = (TextView) view.findViewById(R.id.tvGiaiNhat);

        tvGiaiNhi1 = (TextView) view.findViewById(R.id.tvGiaiNhi1);

        tvGiaiNhi2 = (TextView) view.findViewById(R.id.tvGiaiNhi2);

        tvGiaiBa1 = (TextView) view.findViewById(R.id.tvGiaiBa1);
        tvGiaiBa2 = (TextView) view.findViewById(R.id.tvGiaiBa2);
        tvGiaiBa3 = (TextView) view.findViewById(R.id.tvGiaiBa3);
        tvGiaiBa4 = (TextView) view.findViewById(R.id.tvGiaiBa4);
        tvGiaiBa5 = (TextView) view.findViewById(R.id.tvGiaiBa5);
        tvGiaiBa6 = (TextView) view.findViewById(R.id.tvGiaiBa6);

        tvGiaiTu1 = (TextView) view.findViewById(R.id.tvGiaiTu1);
        tvGiaiTu2 = (TextView) view.findViewById(R.id.tvGiaiTu2);
        tvGiaiTu3 = (TextView) view.findViewById(R.id.tvGiaiTu3);
        tvGiaiTu4 = (TextView) view.findViewById(R.id.tvGiaiTu4);

        tvGiaiNam1 = (TextView) view.findViewById(R.id.tvGiaiNam1);
        tvGiaiNam2 = (TextView) view.findViewById(R.id.tvGiaiNam2);
        tvGiaiNam3 = (TextView) view.findViewById(R.id.tvGiaiNam3);
        tvGiaiNam4 = (TextView) view.findViewById(R.id.tvGiaiNam4);
        tvGiaiNam5 = (TextView) view.findViewById(R.id.tvGiaiNam5);
        tvGiaiNam6 = (TextView) view.findViewById(R.id.tvGiaiNam6);

        tvGiaiSau1 = (TextView) view.findViewById(R.id.tvGiaiSau1);
        tvGiaiSau2 = (TextView) view.findViewById(R.id.tvGiaiSau2);
        tvGiaiSau3 = (TextView) view.findViewById(R.id.tvGiaiSau3);

        tvGiaiBay1 = (TextView) view.findViewById(R.id.tvGiaiBay1);
        tvGiaiBay2 = (TextView) view.findViewById(R.id.tvGiaiBay2);
        tvGiaiBay3 = (TextView) view.findViewById(R.id.tvGiaiBay3);
        tvGiaiBay4 = (TextView) view.findViewById(R.id.tvGiaiBay4);
    }

}
