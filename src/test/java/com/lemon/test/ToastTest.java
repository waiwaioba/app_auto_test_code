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

public class ToastTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //打开测试的App
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.lemon.lemonban");
        capabilities.setCapability("appActivity", ".activity.WelcomeActivity");
        //参数一：Appium服务器的地址  参数二：打开指定设备App的相关配置
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        Thread.sleep(4000);
        //1、点击题库
        driver.findElement(MobileBy.AccessibilityId("题库")).click();
        Thread.sleep(1000);
        //2、点击去登陆按钮
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/button_go_login")).click();
        Thread.sleep(1000);
        //Thread.sleep(1000);
        //3、输入手机号码
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_mobile")).sendKeys("13323234545");
        //4、输入密码
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_password")).sendKeys("123456");
        //5、点击登录按钮
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/btn_login")).click();

        //获取toast元素
        /*WebElement webElement = driver.findElement(MobileBy.xpath("//*[contains(@text,'错误的账号信息')]"));
        System.out.println(webElement.getText());*/

        WebDriverWait webDriverWait = new WebDriverWait(driver,8);
        WebElement webElement1 = webDriverWait.until(ExpectedConditions.
                elementToBeClickable(MobileBy.xpath("//*[contains(@text,'错误的账号信息')]")));
        System.out.println(webElement1.getText());
    }
}
