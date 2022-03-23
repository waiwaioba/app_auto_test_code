package com.lemon.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ElementUnableLocateTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //打开测试的App
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "tv.danmaku.bili");
        capabilities.setCapability("appActivity", ".MainActivityV2");
        //参数一：Appium服务器的地址  参数二：打开指定设备App的相关配置
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        //点击【同意并继续】
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/agree")).click();
        //点击【登录】按钮
        driver.findElement(MobileBy.id("tv.danmaku.bili:id/avatar")).click();
        Thread.sleep(2000);
        //System.out.println(driver.getPageSource());
        //点击【密码登录】选项
        driver.findElement(MobileBy.id("android:id/button1")).click();

    }
}
