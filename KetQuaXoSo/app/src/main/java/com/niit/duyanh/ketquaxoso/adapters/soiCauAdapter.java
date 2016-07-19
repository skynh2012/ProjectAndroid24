package com.niit.duyanh.ketquaxoso.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.niit.duyanh.ketquaxoso.R;
import com.niit.duyanh.ketquaxoso.models.SoiCau;

import java.util.ArrayList;

/**
 * Created by DuyAnh on 19/07/2016.
 */


public class soiCauAdapter extends ArrayAdapter<SoiCau> {
    private ArrayList<SoiCau> arrSoiCau;

    private LayoutInflater layoutInflater;

    public soiCauAdapter(Context context, int resource, ArrayList<SoiCau> objects) {
        super(context, resource, objects);

        this.arrSoiCau = objects;

        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = layoutInflater.inflate(R.layout.soicau_item_template, parent, false);

            holder.imgSoiCau = (ImageView) convertView.findViewById(R.id.imgSearch);

            holder.tvSoiCau = (TextView) convertView.findViewById(R.id.tvSoiCau);

            holder.imgNext = (ImageView) convertView.findViewById(R.id.imgNext);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            final SoiCau soicau= arrSoiCau.get(position);
        if (soicau != null){

            holder.tvSoiCau.setText(soicau.getTitleSoiCau());

        }

        return convertView;
    }

    public static class ViewHolder {

        public ImageView imgSoiCau;

        public TextView tvSoiCau;

        public ImageView imgNext;
    }
}
