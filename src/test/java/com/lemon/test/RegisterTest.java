package com.lemon.test;

import org.testng.annotations.Test;

public class RegisterTest {
    @Test
    public void test() throws InterruptedException {
        System.out.println("注册前");
        //模拟注册的过程耗时
        Thread.sleep(7000);
        System.out.println("注册后");
    }
}
