package com.fanghuarun173.andzjxu.http.entity;

public class MemberResult {
    public int status;
    public String msg;
    public MemberEntity data;

    public class MemberEntity{
        public int member_id;
        public String uname;
        public String password;
        public String email;
        public int sex;
        public String mobile;
        public long regtime;
        public long lastlogin;
        public String image;
        public String memberAddresses;
    }
}
