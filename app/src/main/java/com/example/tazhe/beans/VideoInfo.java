package com.example.tazhe.beans;

import java.util.List;

public class VideoInfo {

    /**
     * msg : null
     * status : 0
     * data : [{"video_id":"4","video_name":"风味人间","video_time":"8小时47分钟","video_framer":"陈晓卿","video_like":"77777","comment_id":"4","video_type":"美食","video_picture":"/image/风味人间.jpg"},{"video_id":"3","video_name":"超级工程","video_time":"8小时25分钟","video_framer":"闫非","video_like":"88888","comment_id":"3","video_type":"科技","video_picture":"/image/超级工程.jpg"},{"video_id":"2","video_name":"舌尖上的中国","video_time":"2小时46分钟","video_framer":"陈晓卿","video_like":"55555","comment_id":"2","video_type":"美食","video_picture":"/image/舌尖上的中国.jpg"},{"video_id":"1","video_name":"星球大战","video_time":"1小时56分钟","video_framer":"闫子豪","video_like":"33333","comment_id":"1","video_type":"科幻","video_picture":"/image/星球大战.jpg"}]
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
         * video_id : 4
         * video_name : 风味人间
         * video_time : 8小时47分钟
         * video_framer : 陈晓卿
         * video_like : 77777
         * comment_id : 4
         * video_type : 美食
         * video_picture : /image/风味人间.jpg
         */

        private String video_id;
        private String video_name;
        private String video_time;
        private String video_framer;
        private String video_like;
        private String comment_id;
        private String video_type;
        private String video_picture;

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getVideo_name() {
            return video_name;
        }

        public void setVideo_name(String video_name) {
            this.video_name = video_name;
        }

        public String getVideo_time() {
            return video_time;
        }

        public void setVideo_time(String video_time) {
            this.video_time = video_time;
        }

        public String getVideo_framer() {
            return video_framer;
        }

        public void setVideo_framer(String video_framer) {
            this.video_framer = video_framer;
        }

        public String getVideo_like() {
            return video_like;
        }

        public void setVideo_like(String video_like) {
            this.video_like = video_like;
        }

        public String getComment_id() {
            return comment_id;
        }

        public void setComment_id(String comment_id) {
            this.comment_id = comment_id;
        }

        public String getVideo_type() {
            return video_type;
        }

        public void setVideo_type(String video_type) {
            this.video_type = video_type;
        }

        public String getVideo_picture() {
            return video_picture;
        }

        public void setVideo_picture(String video_picture) {
            this.video_picture = video_picture;
        }
    }
}
