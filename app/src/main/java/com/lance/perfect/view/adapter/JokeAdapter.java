package com.lance.perfect.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.model.ContentlistEntity;

import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/23.
 */
public class JokeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ContentlistEntity> jokeList;
    public JokeAdapter(List<ContentlistEntity> jokeList) {
        this.jokeList = jokeList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder=new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.joke_list_item, parent, false));
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.mContextTV.setText(Html.fromHtml(jokeList.get(position).getText().toString()));
    }
    @Override
    public int getItemCount() {
        return jokeList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mContextTV;
        public ViewHolder(View itemView) {
            super(itemView);
            mContextTV= (TextView) itemView.findViewById(R.id.mContextTV);
        }
    }
}
