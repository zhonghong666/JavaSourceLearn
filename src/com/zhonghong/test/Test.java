package com.zhonghong.test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author: zhonghong
 * @description: 测试
 * @date: 2021/1/8
 */
public class Test {
    public static void main(String[] args) {

        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            secureRandom = new SecureRandom();
        }

        System.out.println(secureRandom.nextInt());

        System.out.println(secureRandom.nextInt(5));

        System.out.println(Color.BLUE);

    }
}

enum Color {
    RED, BLUE
}

class Base {
    public Base() {
        System.out.println("Base Construct");
        preProcess();
    }

    public void preProcess() {
        System.out.println("Base preProcess()");
    }
}

class Derived extends Base {
    public String whenAmISet = "set when declared";

    public Derived() {
        super();
        System.out.println("Derived Construct");
        System.out.println("whenAmISet ==> " + whenAmISet);
    }

    @Override
    public void preProcess() {
        System.out.println("Derived preProcess()");
        whenAmISet = "set in preProcess()";
    }
}
