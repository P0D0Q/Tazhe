package com.example.tazhe.beans;

public class UserInfo {


    /**
     * msg : null
     * status : 0
     * data : {"user_id":"1","username":"pdq","password":"8542516f8870173d7d1daba1daaaf0a1","phonenumber":"","bornplace":"上海","idcard":"11111","sex":"男","birthday":"1月1日","user_picture":"/image/tou1.ipg","user_state":"0"}
     */

    private Object msg;
    private int status;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 1
         * username : pdq
         * password : 8542516f8870173d7d1daba1daaaf0a1
         * phonenumber :
         * bornplace : 上海
         * idcard : 11111
         * sex : 男
         * birthday : 1月1日
         * user_picture : /image/tou1.ipg
         * user_state : 0
         */

        private String user_id;
        private String username;
        private String password;
        private String phonenumber;
        private String bornplace;
        private String idcard;
        private String sex;
        private String birthday;
        private String user_picture;
        private String user_state;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getBornplace() {
            return bornplace;
        }

        public void setBornplace(String bornplace) {
            this.bornplace = bornplace;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getUser_picture() {
            return user_picture;
        }

        public void setUser_picture(String user_picture) {
            this.user_picture = user_picture;
        }

        public String getUser_state() {
            return user_state;
        }

        public void setUser_state(String user_state) {
            this.user_state = user_state;
        }
    }
}
