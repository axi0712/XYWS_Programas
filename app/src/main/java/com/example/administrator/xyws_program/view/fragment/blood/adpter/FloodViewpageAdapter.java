package com.example.administrator.xyws_program.view.fragment.blood.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 黑明阳 on 2017/3/29.
 */

public class FloodViewpageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    public FloodViewpageAdapter(FragmentManager manager, ArrayList<Fragment> fragments){
        super(manager);
        this.fragments=fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get( position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
