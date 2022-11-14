package com.jpc.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
    public static void main(String[] args) {
        // 将java对象转JSON
        User user = new User();
        user.setId(1);
        user.setUsername("jpc");
        user.setPassword("pjpc");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString); //{"id":1,"password":"pjpc","username":"jpc"}

        // JSON转java
        User u = JSON.parseObject("{\"id\":1,\"password\":\"pjpc\",\"username\":\"jpc\"}", User.class);
        System.out.println(u);
    }
}
