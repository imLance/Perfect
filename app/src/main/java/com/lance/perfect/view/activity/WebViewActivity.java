package com.lance.perfect.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.Constants;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

import java.lang.reflect.InvocationTargetException;

/**
 * 作用:  浏览网页
 * 作者： 张甲彪
 * 时间： 2016/5/25.
 */
public class WebViewActivity extends BaseActivity{
    private TitleBarView mTitleBarView;
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private MyTimer mTimer;
    private int progress = 0;
    private String strurl="http://mp.weixin.qq.com/s?__biz=MzA4NzA3NzAzNg==&mid=401118458&idx=1&sn=f7023910ab455d316121bbd32b80cb74&scene=0#wechat_redirect";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mWebView= (WebView) findViewById(R.id.mWebView);
        mProgressBar= (ProgressBar) findViewById(R.id.mProgressBar);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE, "",
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            },null);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getString(Constants.URL) != null) {
            strurl = bundle.getString(Constants.URL);
        }
        if (bundle != null && bundle.getString(Constants.Title) != null) {
            mTitleBarView.setTitle(bundle.getString(Constants.Title));
        }else {
            mTitleBarView.setTitle("魔方陪你玩");
        }
        if (!TextUtils.isEmpty(strurl)) {
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WeiboWebViewClient());
            mWebView.setWebChromeClient(new WebChromeClient());
            mWebView.loadUrl(strurl);
        }
    }
    @Override
    protected void initData() {
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack())
                mWebView.goBack();
            else
                finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onResume() {
        super.onResume();
        try {
            mWebView.getClass().getMethod("onResume")
                    .invoke(mWebView, (Object[]) null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        try {
            mWebView.getClass().getMethod("onPause")
                    .invoke(mWebView, (Object[]) null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private class WeiboWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (mTimer == null) {
                mTimer = new MyTimer(15000, 50);
            }
            mTimer.start();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mTimer.cancel();
            progress = 0;
            mProgressBar.setProgress(100);
            mProgressBar.setVisibility(View.GONE);
        }
    }
    /* 定义一个倒计时的内部类 */
    private class MyTimer extends CountDownTimer {
        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            progress = 100;
            mProgressBar.setVisibility(View.GONE);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (progress == 100) {
                mProgressBar.setVisibility(View.GONE);
            } else {
                mProgressBar.setProgress(progress++);
            }
        }
    }
}
