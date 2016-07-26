package com.lance.perfect.model;

import android.graphics.Rect;
import android.view.View;

import com.lance.perfect.view.adapter.WXVideoAdapter;
import com.volokh.danylo.video_player_manager.manager.VideoItem;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.CurrentItemMetaData;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.visibility_utils.items.ListItem;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public abstract class WXVideoEntity implements VideoItem, ListItem {
    private final Rect mCurrentViewRect; // 当前视图的方框
    private final VideoPlayerManager<MetaData> mVideoPlayerManager; // 视频播放管理器
    private final String mTitle; // 标题
    private final int mImageResource; // 图片资源

    protected WXVideoEntity(VideoPlayerManager<MetaData> mVideoPlayerManager,
                            String mTitle, int mImageResource) {
        this.mVideoPlayerManager = mVideoPlayerManager;
        this.mTitle = mTitle;
        this.mImageResource = mImageResource;
        mCurrentViewRect = new Rect();
    }
    // 视频项的标题
    public String getTitle() {
        return mTitle;
    }

    // 视频项的背景
    public int getImageResource() {
        return mImageResource;
    }
    // 显示可视的百分比程度
    @Override public int getVisibilityPercents(View view) {
        int percents = 100;

        view.getLocalVisibleRect(mCurrentViewRect);
        int height = view.getHeight();

        if (viewIsPartiallyHiddenTop()) {
            percents = (height - mCurrentViewRect.top) * 100 / height;
        } else if (viewIsPartiallyHiddenBottom(height)) {
            percents = mCurrentViewRect.bottom * 100 / height;
        }
        // 设置百分比
        setVisibilityPercentsText(view, percents);

        return percents;
    }

    @Override public void setActive(View newActiveView, int newActiveViewPosition) {
        WXVideoAdapter.VideoViewHolder viewHolder =
                (WXVideoAdapter.VideoViewHolder) newActiveView.getTag();
        playNewVideo(new CurrentItemMetaData(newActiveViewPosition, newActiveView),
                viewHolder.getVideoPlayerView(), mVideoPlayerManager);
    }

    @Override public void deactivate(View currentView, int position) {
        stopPlayback(mVideoPlayerManager);
    }

    @Override public void stopPlayback(VideoPlayerManager videoPlayerManager) {
        videoPlayerManager.stopAnyPlayback();
    }

    // 显示百分比
    private void setVisibilityPercentsText(View currentView, int percents) {
        WXVideoAdapter.VideoViewHolder vh =
                (WXVideoAdapter.VideoViewHolder) currentView.getTag();
        String percentsText = "可视百分比: " + String.valueOf(percents);
        vh.getPercentTV().setText(percentsText);
    }

    // 顶部出现
    private boolean viewIsPartiallyHiddenTop() {
        return mCurrentViewRect.top > 0;
    }

    // 底部出现
    private boolean viewIsPartiallyHiddenBottom(int height) {
        return mCurrentViewRect.bottom > 0 && mCurrentViewRect.bottom < height;
    }
}
