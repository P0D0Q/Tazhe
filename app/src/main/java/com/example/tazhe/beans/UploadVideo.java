package com.example.tazhe.beans;

import java.util.List;

public class UploadVideo {

    /**
     * msg :
     * code : 0
     * data : {"src":["/image/a82900447c75443f9e8f5e42e70f28ea.PNG"]}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> src;

        public List<String> getSrc() {
            return src;
        }

        public void setSrc(List<String> src) {
            this.src = src;
        }
    }
}
