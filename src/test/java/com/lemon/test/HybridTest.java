package com.lemon.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HybridTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //打开测试的App
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","127.0.0.1:62001");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.lemon.lemonban");
        capabilities.setCapability("appActivity",".activity.WelcomeActivity");
        //参数一：Appium服务器的地址  参数二：打开指定设备App的相关配置
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<>(url,capabilities);
        Thread.sleep(4000);
        //1、点击【柠檬社区】
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"柠檬社区\")")).click();
        Thread.sleep(3000);
        //获取当前的所有状态-->context
        System.out.println(driver.getContextHandles());
        //2、从【原生页面】状态切换到【web页面】状态
        //NATIVE_APP -->原生页面的对应context状态
        //WEBVIEW_com.lemon.lemonban -->web页面对应的context状态
        //driver.context切换到了web的状态之后，此时driver相当于是webdriver
        driver.context("WEBVIEW_com.lemon.lemonban");

        Thread.sleep(2000);
        //3、点击web页面的【注册】
        driver.findElement(By.xpath("//span[contains(text(),'注册')]")).click();

        //要回到原生页面定位元素的时候，必须要要切换回原生模式的context状态
        driver.context("NATIVE_APP");
    }
}
