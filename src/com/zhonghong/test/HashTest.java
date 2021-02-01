package com.zhonghong.test;

/**
 * @author: zhonghong
 * @description: hashMap
 * @date: 2020/12/23
 */
public class HashTest {

    private static native void registerNatives();

    static {
//        registerNatives();
    }

    static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Number number = 10D;
        Class numClass =  number.getClass();
        System.out.println(numClass);
    }
}
