package com.lemon.test;

import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void test() throws InterruptedException {
        System.out.println("登录前");
        //模拟登录的过程耗时
        Thread.sleep(5000);
        System.out.println("登录后");
    }
}
