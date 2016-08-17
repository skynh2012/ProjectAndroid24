package com.niit.duyanh.xosoonline.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.niit.duyanh.xosoonline.R;
import com.niit.duyanh.xosoonline.app.BaseApplication;
import com.niit.duyanh.xosoonline.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Duy Anh on 12/08/2016.
 */
public class MienBacPagerFragment extends Fragment {
    private ImageButton imgbtnPreDate;
    private ImageButton imgbtnNextDate;
    private TextView tvHeader;
    private LinearLayout linearLayout;
    private String date;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat simpleDateFormat;
    private Calendar calendar;
    private Calendar c;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mienbacpager = inflater.inflate(R.layout.fragment_mienbac_pager, container, false);

        findId(mienbacpager);

        calendar = Calendar.getInstance();

        c = Calendar.getInstance();

        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 18, 30, 0);

        if (calendar.compareTo(c) <= 0) {
            calendar.add(Calendar.DATE, -1);
        }

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        date = dateFormat.format(calendar.getTime());

        tvHeader.setText("Xổ số Miền Bắc ngày " + simpleDateFormat.format(calendar.getTime()));

        getXSMB(date);

        show(calendar.getTime());

        imgbtnPreDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar.add(Calendar.DATE, -1);

                date = dateFormat.format(calendar.getTime());

                tvHeader.setText("Xổ số Miền Bắc ngày " + simpleDateFormat.format(calendar.getTime()));

                removeFragmentByTag("mienbac");
                removeFragmentByTag("dauduoimienbac");

                getXSMB(date);

                show(calendar.getTime());
            }
        });

        imgbtnNextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.DATE, 1);

                if (c.compareTo(Calendar.getInstance()) > 0) {
                    return;
                }

                date = dateFormat.format(calendar.getTime());

                tvHeader.setText("Xổ số Miền Bắc ngày " + simpleDateFormat.format(calendar.getTime()));

                removeFragmentByTag("mienbac");
                removeFragmentByTag("dauduoimienbac");

                getXSMB(date);

                show(calendar.getTime());
            }
        });

        return mienbacpager;
    }

    private void findId(View view) {
        imgbtnPreDate = (ImageButton) view.findViewById(R.id.btnPreviousDate);
        imgbtnNextDate = (ImageButton) view.findViewById(R.id.btnNextDate);
        tvHeader = (TextView) view.findViewById(R.id.tvHeader);
        linearLayout = (LinearLayout) view.findViewById(R.id.lnKetQuaMienBac);
    }

    private void getXSMB(final String ngay) {

        progressDialog = ProgressDialog.show(getContext(), "", "");

        Call<JsonElement> call = BaseApplication.ketQuaAPIService.getXoSo(ngay, "mb");

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JsonElement jsonElement = response.body();

                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject.get("success").getAsInt() == 1) {
                    JsonArray xoso = jsonObject.getAsJsonArray("xoso");

                    JsonArray jsonDau = jsonObject.getAsJsonArray("dau");

                    JsonArray jsonDuoi = jsonObject.getAsJsonArray("duoi");

                    JsonObject objXoSo = xoso.get(0).getAsJsonObject();

                    JsonArray dau = jsonDau.get(0).getAsJsonArray();

                    JsonArray duoi = jsonDuoi.get(0).getAsJsonArray();

                    BangKetQuaMienBacFragment mienBacFragment = new BangKetQuaMienBacFragment();

                    Bundle bundleMienBac = new Bundle();

                    bundleMienBac.putString("xoso", objXoSo.toString());

                    mienBacFragment.setArguments(bundleMienBac);

                    BangThongKeDauDuoiFragment dauDuoiFragment = new BangThongKeDauDuoiFragment();

                    Bundle bundleDauDuoi = new Bundle();

                    bundleDauDuoi.putString("dau", dau.toString());
                    bundleDauDuoi.putString("duoi", duoi.toString());
                    bundleDauDuoi.putString("matinh", "mb");

                    bundleDauDuoi.putString("ngay", ngay);

                    dauDuoiFragment.setArguments(bundleDauDuoi);

                    FragmentManager manager = getFragmentManager();

                    manager.beginTransaction().add(R.id.lnKetQuaMienBac, mienBacFragment, "mienbac").commit();

                    manager.beginTransaction().add(R.id.lnKetQuaMienBac, dauDuoiFragment, "dauduoimienbac").commit();

                }

                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                LogUtil.LogD("Error", t.getMessage().toString());
                progressDialog.dismiss();
            }
        });
    }

    private void show(Date ngay) {
        if (ngay.compareTo(Calendar.getInstance().getTime()) > 0) {
            imgbtnNextDate.setImageResource(R.drawable.nextlock);
        } else {
            imgbtnNextDate.setImageResource(R.drawable.nextdate);
        }
    }

    private void removeFragmentByTag(String fmTag) {
        FragmentManager manager = getFragmentManager();

        Fragment fm = manager.findFragmentByTag(fmTag);

        if (fm != null) {
            manager.beginTransaction().remove(fm).commit();
        }
    }

}
