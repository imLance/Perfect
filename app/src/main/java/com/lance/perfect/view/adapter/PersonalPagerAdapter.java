package com.lance.perfect.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lance.perfect.view.fragment.personal.AllDynamicFragment;
import com.lance.perfect.view.fragment.personal.CollectFragment;
import com.lance.perfect.view.fragment.personal.FollowFragment;
import com.lance.perfect.view.fragment.personal.FollowerFragment;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/25.
 */
public class PersonalPagerAdapter extends FragmentPagerAdapter {

    Fragment[] fragments;

    public PersonalPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[4];
        fragments[0] = new AllDynamicFragment();
        fragments[1] = new CollectFragment();
        fragments[2] = new FollowFragment();
        fragments[3] = new FollowerFragment();
    }
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
    @Override
    public int getCount() {
        return fragments.length;
    }
}
