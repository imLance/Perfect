package com.lance.perfect.view.activity;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.ToastUtils;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/28.
 */
public class TextViewActivity extends BaseActivity{
    private TitleBarView mTitleBarView;
    private TextView mText1;
    private TextView mText2;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_textview;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"TextView",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
        mText1= (TextView) findViewById(R.id.mText1);
        mText2= (TextView) findViewById(R.id.mText2);
    }
    @Override
    protected void initData() {
        initTextSizeSpan();
        initTextUnderLineSpan();
    }

    /**
     * 设置超链接
     */
    private void initTextUnderLineSpan() {
        //将TextView的显示文字设置为SpannableString
        mText2.setText(getClickableSpan());
        //设置该句使文本的超连接起作用
        mText2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private SpannableString getClickableSpan() {
        SpannableString spanStr = new SpannableString("使用该软件，即表示您同意该软件的使用条款和隐私政策");
        //设置下划线文字
        spanStr.setSpan(new UnderlineSpan(), 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的单击事件
        spanStr.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                ToastUtils.showShort("使用条款");
            }
        }, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的前景色
        spanStr.setSpan(new ForegroundColorSpan(Color.GREEN), 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置下划线文字
        spanStr.setSpan(new UnderlineSpan(), 21, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的单击事件
        spanStr.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                ToastUtils.showShort("隐私政策");
            }
        }, 21, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置文字的前景色
        spanStr.setSpan(new ForegroundColorSpan(Color.GREEN), 21, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanStr;
    }

    /**
     * 不同字体大小
     */
    private void initTextSizeSpan() {
        String text = "您已经连续走了5963步";
        int start = text.indexOf('5');
        int end = text.length();
        Spannable textSpan = new SpannableStringBuilder(text);
        textSpan.setSpan(new AbsoluteSizeSpan(30), 0, start, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(45), start, end - 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textSpan.setSpan(new AbsoluteSizeSpan(30), end - 1, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mText1.setText(textSpan);
    }
}
