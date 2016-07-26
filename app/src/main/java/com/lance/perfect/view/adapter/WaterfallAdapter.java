package com.lance.perfect.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.GlideUtils;

import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/23.
 */
public class WaterfallAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<String> mList;
    private List<Integer> mHeights;
    public WaterfallAdapter(Context context,List<String> list) {
        this.mContext=context;
        this.mList = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder=new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_waterfall, parent, false));
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ViewGroup.LayoutParams lp = viewHolder.mImageView.getLayoutParams();
        lp.height = (int) (300 + Math.random() * 100);
        viewHolder.mImageView.setLayoutParams(lp);
        GlideUtils.loadImage(mContext,mList.get(position),viewHolder.mImageView);
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.mImageView);
        }
    }
}
