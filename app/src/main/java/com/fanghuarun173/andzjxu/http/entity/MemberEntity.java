package com.fanghuarun173.andzjxu.http.entity;

import java.io.Serializable;

public class MemberEntity implements Serializable {
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

    @Override
    public String toString() {
        return "MemberEntity{" +
                "member_id=" + member_id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastlogin=" + lastlogin +
                ", image='" + image + '\'' +
                ", memberAddresses='" + memberAddresses + '\'' +
                '}';
    }
}
