package com.niit.duyanh.ketquaxoso;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import com.niit.duyanh.ketquaxoso.adapters.soiCauAdapter;
import com.niit.duyanh.ketquaxoso.models.SoiCau;

import java.util.ArrayList;

/**
 * Created by DuyAnh on 22/07/2016.
 */
public class ThongKeActivity extends AppCompatActivity{

    private ListView lstThongKe;

    private ArrayList<SoiCau> arrThongKe;

    private soiCauAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongkexoso);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Thống kê xổ số");

        lstThongKe = (ListView)findViewById(R.id.lstThongKe);

        arrThongKe =new ArrayList<>();

        adapter =new soiCauAdapter(ThongKeActivity.this,R.layout.soicau_item_template,arrThongKe);

        lstThongKe.setAdapter(adapter);

        dataThongKe();
    }

    private void dataThongKe(){
        SoiCau sc;

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê loto gan");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê chu kỳ");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê chu kỳ dàn lô to");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê chu kỳ gan theo tỉnh");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê nhanh");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê tần số nhịp loto");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê đầu đuôi loto");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê tần suất bộ số");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê tần suất loto");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê tần suất loto");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê tần suất cặp loto");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Tổng hợp chu kỳ đặc biệt");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê chu kỳ dàn đặc biệt");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Chu kỳ max dàn cùng về");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê giải đặc biệt gan");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Kết quả đặc biệt cho ngày mai");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Bảng đặc biệt tuần");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Bảng đặc biệt theo tháng");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê loto theo loto");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê loto theo đặc biệt");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê loto theo giải");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê cặp số anh em");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê 2 số cuối XSMB");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Tìm càng");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê tổng hợp");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê theo tổng");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê theo ngày");
        arrThongKe.add(sc);

        sc =new SoiCau();
        sc.setTitleSoiCau("Thống kê quan trọng");
        arrThongKe.add(sc);

        adapter.notifyDataSetChanged();
    }
}
