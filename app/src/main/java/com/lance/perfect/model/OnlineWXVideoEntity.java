package com.lance.perfect.model;

import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class OnlineWXVideoEntity extends WXVideoEntity{
    private final String mOnlineUrl; // 资源文件描述
    public OnlineWXVideoEntity( VideoPlayerManager<MetaData> mVideoPlayerManager, String mTitle, int mImageResource, String mOnlineUrl) {
        super( mVideoPlayerManager, mTitle, mImageResource);
        this.mOnlineUrl = mOnlineUrl;
    }
    @Override
    public void playNewVideo(MetaData currentItemMetaData, VideoPlayerView player, VideoPlayerManager<MetaData> videoPlayerManager) {
        videoPlayerManager.playNewVideo(currentItemMetaData, player, mOnlineUrl);
    }
}
