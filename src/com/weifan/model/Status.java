package com.weifan.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Status {

    @DatabaseField
    private String created_at;
    
    @DatabaseField(id = true)
    private long id;
    
    @DatabaseField
    private long mid;
    
    @DatabaseField
    private String idstr;
    
    @DatabaseField
    private String text;
    
    @DatabaseField
    private String source;
    
    @DatabaseField
    private boolean favorited;
    
    @DatabaseField
    private boolean truncated;
    
    @DatabaseField
    private String in_reply_to_status_id;
    
    @DatabaseField
    private String in_reply_to_user_id;
    
    @DatabaseField
    private String in_reply_to_screen_name;
    
    @DatabaseField
    private String thumbnail_pic;
    
    @DatabaseField
    private String bmiddle_pic;
    
    @DatabaseField
    private String original_pic;
    
    @DatabaseField(foreign = true)
    private Geo geo;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;
    
    @DatabaseField(foreign = true)
    private Status retweeted_status;
    
    @DatabaseField
    private int reposts_count;
    
    @DatabaseField
    private int comments_count;
    
    @DatabaseField
    private int attitudes_count;
    
    @DatabaseField
    private int mlevel;
    
    public Status() {
        
    }

    // visible object
    // 微博的可见性及指定可见分组信息。该object中type取值，0：普通微博，1：私密微博，3：指定分组微博，4：密友微博；list_id为分组的组号
    
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }

    public String getBmiddle_pic() {
        return bmiddle_pic;
    }

    public void setBmiddle_pic(String bmiddle_pic) {
        this.bmiddle_pic = bmiddle_pic;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public void setOriginal_pic(String original_pic) {
        this.original_pic = original_pic;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Status retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public int getMlevel() {
        return mlevel;
    }

    public void setMlevel(int mlevel) {
        this.mlevel = mlevel;
    }

    @Override
    public String toString() {
        return "Status [create_at=" + created_at + ", id=" + id + ", mid=" + mid
                + ", idstr=" + idstr + ", text=" + text + ", source=" + source
                + ", favorited=" + favorited + ", truncated=" + truncated
                + ", in_reply_to_status_id=" + in_reply_to_status_id
                + ", in_reply_to_user_id=" + in_reply_to_user_id
                + ", in_reply_to_screen_name=" + in_reply_to_screen_name
                + ", thumbnail_pic=" + thumbnail_pic + ", bmiddle_pic="
                + bmiddle_pic + ", original_pic=" + original_pic + ", geo="
                + geo + ", user=" + user + ", retweeted_status="
                + retweeted_status + ", reposts_count=" + reposts_count
                + ", comments_count=" + comments_count + ", attitudes_count="
                + attitudes_count + ", mlevel=" + mlevel + "]";
    }

}
