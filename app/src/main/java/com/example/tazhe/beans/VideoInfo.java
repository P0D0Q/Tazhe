package com.example.tazhe.beans;

public class VideoInfo {


    /**
     * video_time : 1小时56分钟
     * video_name : 星球大战
     * user_picture : /image/tou1.ipg
     * video_picture : /image/xingqiudazhan.jpg
     * video_id : 1
     * video_type : 科幻
     */

    private String video_time;
    private String video_name;
    private String user_picture;
    private String video_picture;
    private int video_id;
    private String video_type;

    public String getVideo_time() {
        return video_time;
    }

    public void setVideo_time(String video_time) {
        this.video_time = video_time;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public String getVideo_picture() {
        return video_picture;
    }

    public void setVideo_picture(String video_picture) {
        this.video_picture = video_picture;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }
}
