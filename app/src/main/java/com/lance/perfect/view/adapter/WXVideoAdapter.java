package com.lance.perfect.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.GlideUtils;
import com.lance.perfect.model.WXVideoEntity;
import com.volokh.danylo.video_player_manager.ui.MediaPlayerWrapper;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;

import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/26.
 */
public class WXVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final List<WXVideoEntity> mList;
    private Context mContext;
    public WXVideoAdapter(List<WXVideoEntity> list,Context context) {
        this.mList = list;
        this.mContext=context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wxvideo,parent,false);
        VideoViewHolder holder=new VideoViewHolder(view);
        view.setTag(holder);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoViewHolder mHolder= (VideoViewHolder) holder;
        mHolder.mTitleTV.setText(mList.get(position).getTitle());
        mHolder.mBackIV.setVisibility(View.VISIBLE);
        GlideUtils.loadLocalImage(mContext,mList.get(position).getImageResource(),mHolder.mBackIV);
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private MediaPlayerWrapper.MainThreadMediaPlayerListener mPlayerListener;

        private VideoPlayerView mVideoPlayerView; // 播放控件
        private ImageView mBackIV; // 覆盖层
        private TextView mTitleTV; // 标题
        private TextView mPercentTV; // 百分比
        public VideoViewHolder(View itemView) {
            super(itemView);
            mContext=itemView.getContext().getApplicationContext();
            mVideoPlayerView= (VideoPlayerView) itemView.findViewById(R.id.mVideoPlayerView);
            mBackIV= (ImageView) itemView.findViewById(R.id.mBackIV);
            mTitleTV= (TextView) itemView.findViewById(R.id.mTitleTV);
            mPercentTV= (TextView) itemView.findViewById(R.id.mPercentTV);
            mPlayerListener = new MediaPlayerWrapper.MainThreadMediaPlayerListener() {
                @Override
                public void onVideoSizeChangedMainThread(int width, int height) {
                }

                @Override
                public void onVideoPreparedMainThread() {
                    // 视频播放隐藏前图
                    mBackIV.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onVideoCompletionMainThread() {
                }

                @Override
                public void onErrorMainThread(int what, int extra) {
                }

                @Override
                public void onBufferingUpdateMainThread(int percent) {
                }

                @Override
                public void onVideoStoppedMainThread() {
                    // 视频暂停显示前图
                    mBackIV.setVisibility(View.VISIBLE);
                }
            };
            mVideoPlayerView.addMediaPlayerListener(mPlayerListener);
        }
        public VideoPlayerView getVideoPlayerView(){
            return mVideoPlayerView;
        }
        public TextView getPercentTV(){
            return mPercentTV;
        }
    }
}
