package com.lance.perfect.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lance.greendaodem.Note;
import com.lance.perfect.R;
import com.lance.perfect.view.activity.GreenDaoActivity;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/26.
 */
public class GreenDaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public List<Note> mList;
    private WeakReference<GreenDaoActivity> mActivity;
    public GreenDaoAdapter(List<Note> list, Context context){
        this.mList=list;
        this.mActivity=new WeakReference<GreenDaoActivity>((GreenDaoActivity)context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_greendao,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder= (ViewHolder) holder;
        final Note note=mList.get(position);
        mHolder.mContextTV.setText(note.getId()+":"+note.getText());
        mHolder.mDelIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GreenDaoActivity activity = mActivity.get();
                activity.delete(note.getId());
            }
        });
        mHolder.mEditIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GreenDaoActivity activity = mActivity.get();
                activity.update(note.getId());
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mContextTV;
        private ImageView mDelIV;
        private ImageView mEditIV;
        public ViewHolder(View itemView) {
            super(itemView);
            mContextTV= (TextView) itemView.findViewById(R.id.mContextTV);
            mDelIV= (ImageView) itemView.findViewById(R.id.mDelIV);
            mEditIV= (ImageView) itemView.findViewById(R.id.mEditIV);
        }
    }
}
