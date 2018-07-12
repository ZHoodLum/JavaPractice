package com.struts.util;

import java.util.*;

public class UserInfoList {
    private static UserInfoList user = new UserInfoList();
    private Vector vector = null;

    /*
         利用private调用构造函数，
         防止被外界产生新的instance对象
     */
    public UserInfoList() {
        this.vector = new Vector();
    }

    /*外界使用的instance对象*/
    public static UserInfoList getInstance() {
        return user;
    }

    /*增加用户*/
    public boolean addUserInfo(String user) {
        if (user != null) {
            this.vector.add(user);
            return true;
        } else {
            return false;
        }
    }

    /*获取用户列表*/
    public Vector getList() {
        return vector;
    }

    /*移除用户*/
    public void removeUserInfo(String user) {
        if (user != null) {
            vector.removeElement(user);
        }
    }


}

