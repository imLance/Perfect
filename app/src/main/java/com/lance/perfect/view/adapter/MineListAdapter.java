package com.lance.perfect.view.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.model.MineLearnEntity;

import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/26.
 */
public class MineListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public List<MineLearnEntity> mList;
    private Context mContext;
    public MineListAdapter(List<MineLearnEntity> list, Context context){
        this.mList=list;
        this.mContext=context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mine_learn,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder= (ViewHolder) holder;
        final MineLearnEntity note=mList.get(position);
        mHolder.mContextTV.setText((position+1)+"、"+note.getContent());
        mHolder.mRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent().setComponent(new ComponentName(mContext,
                        note.getClassName()));
                mContext.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mContextTV;
        private RelativeLayout mRootLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            mContextTV= (TextView) itemView.findViewById(R.id.mContextTV);
            mRootLayout= (RelativeLayout) itemView.findViewById(R.id.mRootLayout);
        }
    }
}
