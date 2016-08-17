package com.niit.duyanh.xosoonline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.niit.duyanh.xosoonline.ui.fragment.MienBacPagerFragment;
import com.niit.duyanh.xosoonline.ui.fragment.MienNamPagerFragment;
import com.niit.duyanh.xosoonline.ui.fragment.MienTrungPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duy Anh on 12/08/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleList = new ArrayList<>();

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
    
}
