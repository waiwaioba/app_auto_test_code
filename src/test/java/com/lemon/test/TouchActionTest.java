package com.lemon.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TouchActionTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //打开测试的App
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.baidu.BaiduMap");
        capabilities.setCapability("appActivity", "com.baidu.baidumaps.WelcomeScreen");
        //参数一：Appium服务器的地址  参数二：打开指定设备App的相关配置
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.findElement(MobileBy.id("com.baidu.BaiduMap:id/ok_btn")).click();
        Thread.sleep(6000);
        //swipeDown(driver,1000);
        //swipeLeft(driver,4);
        zoom(driver);
        driver.close();
    }

    public void swipeDown(AndroidDriver<WebElement> driver,long times) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(driver);
        PointOption startPoint = PointOption.point(width / 2, height / 4);
        PointOption endPoint = PointOption.point(width / 2, 3 * height / 4);
        Duration duration = Duration.ofMillis(times);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
    }

    public void swipeLeft(AndroidDriver<WebElement> driver,int num){
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        PointOption startPoint = PointOption.point(width / 4, height / 2);
        PointOption endPoint = PointOption.point(width * 3 / 4, height / 2);
        for (int i = 0; i < num; i++) {
            TouchAction touchAction = new TouchAction(driver);
            Duration dd = Duration.ofMillis(500);
            WaitOptions waitOptions = WaitOptions.waitOptions(dd);
            touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release().perform();
        }
    }

    public void zoom(AndroidDriver<WebElement> driver){
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        //手势放大
        //第一根手指的手势(B->A) B:0.4  A:0.2
        PointOption pointOptionB = PointOption.point(width*2/5,height*2/5);
        PointOption pointOptionA = PointOption.point(width/5,height/5);
        //第二根手指的手势(C->D) D:0.6  D:0.8
        PointOption pointOptionC = PointOption.point(width*3/5,height*3/5);
        PointOption pointOptionD = PointOption.point(width*4/5,height*4/5);
        //设置滑动
        WaitOptions waitOptions = new WaitOptions();
        waitOptions.withDuration(Duration.ofMillis(800));
        //分别创建两根手势触摸对象-TouchAction
        TouchAction touchAction1 = new TouchAction(driver);
        touchAction1.press(pointOptionB).waitAction(waitOptions).moveTo(pointOptionA).waitAction(waitOptions).release();
        TouchAction touchAction2 = new TouchAction(driver);
        touchAction2.press(pointOptionC).waitAction(waitOptions).moveTo(pointOptionD).waitAction(waitOptions).release();
        //两根手指的动作是需要同时进行的
        MultiTouchAction multiTouchAction = new MultiTouchAction(driver);
        multiTouchAction.add(touchAction1);
        multiTouchAction.add(touchAction2);
        multiTouchAction.perform();
    }
}
