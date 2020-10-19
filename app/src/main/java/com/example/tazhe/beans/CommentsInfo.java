package com.example.tazhe.beans;

import java.util.List;

public class CommentsInfo {

    /**
     * msg : null
     * status : 0
     * data : [{"comment_id":"10","comment_time":"2020-10-19 11:07:32","comment":"123","video_id":"2","user_id":"5"},{"comment_id":"9","comment_time":"2020-10-19 09:55:13","comment":"123","video_id":"2","user_id":"4"},{"comment_id":"8","comment_time":"2020-10-19 09:54:16","comment":"123","video_id":"2","user_id":"3"},{"comment_id":"7","comment_time":"2020-10-19 09:50:01","comment":"123","video_id":"2","user_id":"2"},{"comment_id":"6","comment_time":"2020-10-19 09:49:19","comment":"123","video_id":"1","user_id":"1"},{"comment_id":"4","comment_time":"2020-10-19 09:24:24","comment":"gg","video_id":"1","user_id":"1"},{"comment_id":"3","comment_time":"2020-10-19 09:24:21","comment":"真不错","video_id":"2","user_id":"2"},{"comment_id":"2","comment_time":"2020-10-19 09:24:18","comment":"hehe","video_id":"1","user_id":"1"},{"comment_id":"1","comment_time":"2020-10-19 09:24:13","comment":"haha","video_id":"1","user_id":"1"}]
     */

    private Object msg;
    private int status;
    private List<DataBean> data;

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * comment_id : 10
         * comment_time : 2020-10-19 11:07:32
         * comment : 123
         * video_id : 2
         * user_id : 5
         */

        private String comment_id;
        private String comment_time;
        private String comment;
        private String video_id;
        private String user_id;

        public String getComment_id() {
            return comment_id;
        }

        public void setComment_id(String comment_id) {
            this.comment_id = comment_id;
        }

        public String getComment_time() {
            return comment_time;
        }

        public void setComment_time(String comment_time) {
            this.comment_time = comment_time;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
