package com.lance.perfect.view.activity;

import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lance.greendaodem.Note;
import com.lance.greendaodem.NoteDao;
import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.adapter.GreenDaoAdapter;
import com.lance.perfect.view.widget.TitleBarView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.Query;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/25.
 */
public class GreenDaoActivity extends BaseActivity implements View.OnClickListener {
    private TitleBarView mTitleBarView;
    private TextView mAddTV;
    private TextView mSearchTV;
    private EditText mContextET;
    private RecyclerView mRecyclerView;
    GreenDaoAdapter mAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_greendao;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView)findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE, "GreenDao学习",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }, null);
        mAddTV= (TextView) findViewById(R.id.mAddTV);
        mSearchTV= (TextView) findViewById(R.id.mSearchTV);
        mContextET= (EditText) findViewById(R.id.mContextET);
        mRecyclerView= (RecyclerView) findViewById(R.id.mRecyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Note> mList=new ArrayList<>();
        mAdapter=new GreenDaoAdapter(mList,this);
        mRecyclerView.setAdapter(mAdapter);
        mAddTV.setOnClickListener(this);
        mSearchTV.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        Cursor cursor=mApp.getDb().query(mApp.getDaoSession().getNoteDao().getTablename(),
                mApp.getDaoSession().getNoteDao().getAllColumns(),null,null,null, null,null);
        List<Note> mList=new ArrayList<>();
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            mList.add(new Note(cursor.getLong(0),cursor.getString(1),cursor.getString(2),new Date()));
        }
        mAdapter.mList=mList;
        mAdapter.notifyDataSetChanged();
        cursor.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mAddTV:
                add();
                break;
            case R.id.mSearchTV:
                read(mContextET.getText().toString());
                break;
            default:
                break;
        }
    }
    /**增*/
    private void add(){
        Note note = new Note(null, mContextET.getText().toString(), "", new Date());
        mApp.getDaoSession().getNoteDao().insert(note);
        read("");
    }
    /**删*/
    public void delete(long id){
        DeleteQuery<Note> delQuery=mApp.getDaoSession().getNoteDao().queryBuilder()
                .where(NoteDao.Properties.Id.eq(id))
                .buildDelete();
        delQuery.executeDeleteWithoutDetachingEntities();
        read("");
    }
    /**改*/
    public void update(long id){
        Note note=new Note(id,"我是更新的数据","",new Date());
        mApp.getDaoSession().getNoteDao().insertOrReplace(note);
        read("");
    }
    /**查*/
    private void read(String text){
        Query query;
        if (TextUtils.isEmpty(text)){
            query= mApp.getDaoSession().getNoteDao().queryBuilder()
                    .orderAsc(NoteDao.Properties.Date)
                    .build();
        }else {
            query= mApp.getDaoSession().getNoteDao().queryBuilder()
//                    .where(NoteDao.Properties.Text.eq(text))
                    .where(NoteDao.Properties.Text.like("%"+text+"%"))
                    .orderAsc(NoteDao.Properties.Date)
                    .build();
        }
        List mList=query.list();
        mAdapter.mList=mList;
        mAdapter.notifyDataSetChanged();
    }
}
