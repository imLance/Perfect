package com.lance.perfect.model;

import android.content.res.AssetFileDescriptor;

import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;

/**
 * 作用:  本地资源播放视频
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class LocalWXVideoEntity extends WXVideoEntity{
    private final AssetFileDescriptor mAssetFileDescriptor; // 资源文件描述
    public LocalWXVideoEntity(VideoPlayerManager<MetaData> mVideoPlayerManager, String mTitle, int mImageResource, AssetFileDescriptor mAssetFileDescriptor) {
        super(mVideoPlayerManager, mTitle, mImageResource);
        this.mAssetFileDescriptor = mAssetFileDescriptor;
    }

    @Override
    public void playNewVideo(MetaData currentItemMetaData, VideoPlayerView player, VideoPlayerManager<MetaData> videoPlayerManager) {
        videoPlayerManager.playNewVideo(currentItemMetaData, player, mAssetFileDescriptor);
    }
}
