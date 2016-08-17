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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.niit.duyanh.xosoonline.R;
import com.niit.duyanh.xosoonline.app.BaseApplication;
import com.niit.duyanh.xosoonline.util.DateTimeUtil;
import com.niit.duyanh.xosoonline.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Duy Anh on 12/08/2016.
 */
public class MienNamPagerFragment extends Fragment {

    private LinearLayout lnKetQuaMienNam;

    private TextView tvHeaderMienNam;

    private ImageButton imgbtnPresiuos, imgbtnNext;


    private Calendar calendar;

    private Calendar c;

    private SimpleDateFormat dateFormat;

    private SimpleDateFormat simpleDateFormat;

    private Bundle bundle;

    private FragmentManager manager;

    private BangKetQuaMienNamFragment mienNamFragment;

    private ProgressDialog progressDialog;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mienNamPager = inflater.inflate(R.layout.fragment_miennam_pager, container, false);

        findId(mienNamPager);

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        calendar = Calendar.getInstance();

        c = Calendar.getInstance();

        c.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, 16, 30, 0);

        if (calendar.compareTo(c) < 0) {
            calendar.add(Calendar.DATE, -1);
        }

        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        bundle = new Bundle();

        tvHeaderMienNam.setText("Xổ số Miền Nam ngày " + simpleDateFormat.format(calendar.getTime()));

        addView();

        /////////////////////////////////////////////////Start Img Pre
        imgbtnPresiuos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.DATE, -1);

                tvHeaderMienNam.setText("Xổ số Miền Nam ngày " + simpleDateFormat.format(calendar.getTime()));

                removeFragmentByTag("miennam");

                addView();

            }
        });
        ////////////////////////////////////////////////////

        ////////////////////////////////////////Start Img next
        imgbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (calendar.compareTo(Calendar.getInstance()) >= 0) {
                    return;
                }
                calendar.add(Calendar.DATE, 1);

                tvHeaderMienNam.setText("Xổ số Miền Nam ngày " + simpleDateFormat.format(calendar.getTime()));

                removeFragmentByTag("miennam");

                addView();

            }
        });
        //////////////////////////////////////////////////

        return mienNamPager;
    }

    private void findId(View view) {
        lnKetQuaMienNam = (LinearLayout) view.findViewById(R.id.lnKetQuaMienNam);

        tvHeaderMienNam = (TextView) view.findViewById(R.id.tvHeader);

        imgbtnPresiuos = (ImageButton) view.findViewById(R.id.btnPreviousDate);

        imgbtnNext = (ImageButton) view.findViewById(R.id.btnNextDate);
    }

    private void addView() {

        String date = dateFormat.format(calendar.getTime());

        progressDialog = ProgressDialog.show(getContext(), "", "");

        Call<JsonElement> call = BaseApplication.ketQuaAPIService.getXoSoMienNam(date);

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                JsonElement jsonElement = response.body();

                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject.get("success").getAsInt() == 1) {

                    Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();

                    int i = 0;

                    for (Map.Entry<String, JsonElement> entry : entries) {
                        String key = entry.getKey();
                        if (!key.equals("success")) {


                            bundle.putString("ketqua" + i, entry.getValue().toString());

                            bundle.putString("tinh" + i, key);

                            i++;
                        }
                    }

                    bundle.putString("ngay", DateTimeUtil.getDayOfWeek(calendar.getTime()));

                    mienNamFragment = new BangKetQuaMienNamFragment();

                    mienNamFragment.setArguments(bundle);

                    manager = getFragmentManager();

                    manager.beginTransaction().add(R.id.lnKetQuaMienNam, mienNamFragment, "miennam").commit();

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

    private void removeFragmentByTag(String fmTag) {
        FragmentManager manager = getFragmentManager();

        Fragment fm = manager.findFragmentByTag(fmTag);

        if (fm != null) {
            manager.beginTransaction().remove(fm).commit();
        }
    }
}
