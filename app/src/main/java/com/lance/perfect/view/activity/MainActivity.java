package com.lance.perfect.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.fragment.main.HomeFragment;
import com.lance.perfect.view.fragment.main.MessageFragment;
import com.lance.perfect.view.fragment.main.MineFragment;
import com.lance.perfect.view.widget.bottomnavigation.BottomNavigationItem;
import com.lance.perfect.view.widget.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity{
    BottomNavigationView mBottomNavigation;

    private Fragment homeFragment;
    private Fragment messageFragment;
    private Fragment mineFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.content_main;
    }
    @Override
    protected void initData() {
    }
    @Override
    protected void initViews() {
        mBottomNavigation= (BottomNavigationView) findViewById(R.id.bottomNavigation);
        if (mBottomNavigation != null) {
            mBottomNavigation.isWithText(true);
            mBottomNavigation.isColoredBackground(false);
            mBottomNavigation.disableShadow();
            mBottomNavigation.setItemActiveColorWithoutColoredBackground(getResources()
                    .getColor(R.color.fourthColor));
        }
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                (getString(R.string.home), getResources().getColor(R.color.white),
                        R.drawable.ic_home_24dp);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                (getString(R.string.message), getResources().getColor(R.color.white),
                        R.drawable.ic_markunread_24dp);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                (getString(R.string.me), getResources().getColor(R.color.white),
                        R.drawable.ic_timer_auto_24dp);

        mBottomNavigation.addTab(bottomNavigationItem);
        mBottomNavigation.addTab(bottomNavigationItem1);
        mBottomNavigation.addTab(bottomNavigationItem2);
        selectedImages(0);
        mBottomNavigation.setOnBottomNavigationItemClickListener(new BottomNavigationView.OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        selectedImages(0);
                        break;
                    case 1:
                        selectedImages(1);
                        break;
                    case 2:
                        selectedImages(2);
                        break;
                }
            }
        });
    }
    /**
     * 设置选中
     * @param i
     */
    private void selectedImages(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.fragment_navigation, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case 1:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.fragment_navigation, messageFragment);
                } else {
                    fragmentTransaction.show(messageFragment);
                }
                break;
            case 2:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.fragment_navigation, mineFragment);
                } else {
                    fragmentTransaction.show(mineFragment);
                }
                break;
            default:
                break;

        }
        fragmentTransaction.commit();
    }

    /**
     * 初始化隐藏所有Fragment
     *
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (messageFragment != null) {
            fragmentTransaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            fragmentTransaction.hide(mineFragment);
        }

    }
}
