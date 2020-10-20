package com.example.tazhe.beans;

public class CommentsInfo {


    /**
     * comment_time : 2020-10-19 09:24:13
     * user_id : 1
     * user_picture : /image/tou1.ipg
     * comment : haha
     * comment_id : 1
     * video_id : 1
     * username : pdq
     */

    private String comment_time;
    private int user_id;
    private String user_picture;
    private String comment;
    private int comment_id;
    private int video_id;
    private String username;

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
