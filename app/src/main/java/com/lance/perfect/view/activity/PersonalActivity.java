package com.lance.perfect.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.GlideUtils;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.adapter.PersonalPagerAdapter;

/**
 * 作用: 个人资料
 * 作者： 张甲彪
 * 时间： 2016/5/24.
 */
public class PersonalActivity extends BaseActivity implements View.OnClickListener {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private Toolbar mToolbar;
    private RelativeLayout mHeadLayout;
    private ImageView mPortraitRIV;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void initViews() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        mCollapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.mCollapsingToolbarLayout);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(0,0,0));
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        mHeadLayout= (RelativeLayout) findViewById(R.id.mHeadLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -mHeadLayout.getHeight() / 2) {
                    mCollapsingToolbarLayout.setTitle("Lance");
                } else {
                    mCollapsingToolbarLayout.setTitle(" ");
                }
            }
        });
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        mPortraitRIV= (ImageView) findViewById(R.id.mPortraitRIV);
        GlideUtils.loadCircleImage(this,
                "http://img2.imgtn.bdimg.com/it/u=3065510176,2216713784&fm=21&gp=0.jpg",mPortraitRIV);
        mPortraitRIV.setOnClickListener(this);

        mViewPager= (ViewPager) findViewById(R.id.mViewPager);
        mTabLayout= (TabLayout) findViewById(R.id.mTabLayout);
        PersonalPagerAdapter vpAdapter = new PersonalPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(vpAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }
    @Override
    protected void initData() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mPortraitRIV:

                break;
            default:
                break;
        }
    }
}
