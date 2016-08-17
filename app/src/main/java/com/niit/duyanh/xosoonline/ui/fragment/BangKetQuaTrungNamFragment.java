package com.niit.duyanh.xosoonline.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.niit.duyanh.xosoonline.R;
import com.niit.duyanh.xosoonline.model.KetQuaTrungNam;
import com.niit.duyanh.xosoonline.network.KetQuaAPIClient;

/**
 * Created by Duy Anh on 09/08/2016.
 */
public class BangKetQuaTrungNamFragment extends Fragment {

    private TextView tvg0, tvg1, tvg2, tvg3, tvg4, tvg5, tvg6, tvg7, tvg8;
    private TextView tvHeaderTrungNam;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View KetQuaTrungNamView = inflater.inflate(R.layout.fragment_bangketqua_trungnam, container, false);

        findViewById(KetQuaTrungNamView);

        Bundle bundle = getArguments();

        if (bundle != null) {
            String ngay = bundle.getString("ngay");
            String matinh = bundle.getString("matinh");

            tvHeaderTrungNam.setText("mã tỉnh : " + matinh + " ngày : " + ngay);

            String xoso = bundle.getString("JsonTrungNam");

            JsonParser parser = new JsonParser();

            JsonElement jsonElement = parser.parse(xoso);

            JsonObject jsonObject = jsonElement.getAsJsonObject();

            tvg0.setText(jsonObject.get("g0").getAsString());
            tvg1.setText(jsonObject.get("g1").getAsString());
            tvg2.setText(jsonObject.get("g2").getAsString());
            tvg3.setText(jsonObject.get("g3").getAsString());
            tvg4.setText(jsonObject.get("g4").getAsString());
            tvg5.setText(jsonObject.get("g5").getAsString());
            tvg6.setText(jsonObject.get("g6").getAsString());
            tvg7.setText(jsonObject.get("g7").getAsString());
            tvg8.setText(jsonObject.get("g8").getAsString());
        }


        return KetQuaTrungNamView;
    }

    public void findViewById(View view) {
        tvg0 = (TextView) view.findViewById(R.id.tvKQMNGiaiDacBiet);
        tvg1 = (TextView) view.findViewById(R.id.tvKQMNGiaiNhat);
        tvg2 = (TextView) view.findViewById(R.id.tvKQMNGiaiNhi);
        tvg3 = (TextView) view.findViewById(R.id.tvKQMNGiaiBa);
        tvg4 = (TextView) view.findViewById(R.id.tvKQMNGiaiTu);
        tvg5 = (TextView) view.findViewById(R.id.tvKQMNGiaiNam);
        tvg6 = (TextView) view.findViewById(R.id.tvKQMNGiaiSau);
        tvg7 = (TextView) view.findViewById(R.id.tvKQMNGiaiBay);
        tvg8 = (TextView) view.findViewById(R.id.tvKQMNGiaiTam);
        tvHeaderTrungNam = (TextView) view.findViewById(R.id.tvHeaderTrungNam);
    }
}
