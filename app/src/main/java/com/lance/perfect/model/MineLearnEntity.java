package com.lance.perfect.model;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class MineLearnEntity {
    /**内容*/
    private String content;
    /**相关类名*/
    private String className;
    //

    public MineLearnEntity(String content, String className) {
        this.content = content;
        this.className = className;
    }
    public String getContent() {
        return content;
    }
    public String getClassName() {
        return className;
    }

}
