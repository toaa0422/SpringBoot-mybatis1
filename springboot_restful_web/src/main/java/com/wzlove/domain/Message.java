package com.wzlove.domain;

/**
 * @ClassName Message
 * @Author wz157
 * @Date 2018/12/6 18:08
 * @Description TODO
 */
public class Message {

    private Long id;

    private String text;

    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
