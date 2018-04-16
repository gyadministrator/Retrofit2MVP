package model;

public class User {

    /**
     * code : 100
     * msg : 处理成功!
     * response : {"user":{"id":84,"username":"admin","password":"21232f297a57a5a743894a0e4a801fc3","star":null,"myStar":null,"collectMusic":null,"image":"http://123.207.93.53/MusicWebServer/upload/MDBJFXN77ZKCVSMQUIFFGD145SI2GC81.jpg","phone":"15508516280"}}
     */

    private int code;
    private String msg;
    private ResponseBean response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * user : {"id":84,"username":"admin","password":"21232f297a57a5a743894a0e4a801fc3","star":null,"myStar":null,"collectMusic":null,"image":"http://123.207.93.53/MusicWebServer/upload/MDBJFXN77ZKCVSMQUIFFGD145SI2GC81.jpg","phone":"15508516280"}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "ResponseBean{" +
                    "user=" + user.toString() +
                    '}';
        }

        public static class UserBean {
            @Override
            public String toString() {
                return "UserBean{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", star=" + star +
                        ", myStar=" + myStar +
                        ", collectMusic=" + collectMusic +
                        ", image='" + image + '\'' +
                        ", phone='" + phone + '\'' +
                        '}';
            }

            /**
             * id : 84
             * username : admin
             * password : 21232f297a57a5a743894a0e4a801fc3
             * star : null
             * myStar : null
             * collectMusic : null
             * image : http://123.207.93.53/MusicWebServer/upload/MDBJFXN77ZKCVSMQUIFFGD145SI2GC81.jpg
             * phone : 15508516280
             */

            private int id;
            private String username;
            private String password;
            private Object star;
            private Object myStar;
            private Object collectMusic;
            private String image;
            private String phone;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public Object getStar() {
                return star;
            }

            public void setStar(Object star) {
                this.star = star;
            }

            public Object getMyStar() {
                return myStar;
            }

            public void setMyStar(Object myStar) {
                this.myStar = myStar;
            }

            public Object getCollectMusic() {
                return collectMusic;
            }

            public void setCollectMusic(Object collectMusic) {
                this.collectMusic = collectMusic;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", response=" + response.toString() +
                '}';
    }
}