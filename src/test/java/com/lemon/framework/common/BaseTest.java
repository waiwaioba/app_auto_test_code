package com.lemon.framework.common;


import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private Logger logger = Logger.getLogger(BaseTest.class);
    //驱动
    public AndroidDriver driver;
    /**
     * 打开App的通用方法
     */
    public AndroidDriver<WebElement> openApp(String udid, String appium_port, String uiautomator2_port){
        //打开测试的App
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("deviceName", "XXX");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.lemon.lemonban");
        capabilities.setCapability("appActivity", ".activity.WelcomeActivity");
        //设置UIAutomator2端口
        capabilities.setCapability("systemPort", uiautomator2_port);
        //参数一：Appium服务器的地址  参数二：打开指定设备App的相关配置
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:"+appium_port+"/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<WebElement>(url, capabilities);
        logger.info("=================打开测试App===============");
        logger.info("配置参数【"+driver.getCapabilities()+"】");
        return driver;
    }

    public void myAssertEquals(String actual, String expected){
        logger.info("断言期望值【"+expected+"】实际值【"+actual+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(int actual, int expected){
        logger.info("断言期望值【"+expected+"】实际值【"+actual+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(float actual, float expected){
        logger.info("断言期望值【"+expected+"】实际值【"+actual+"】");
        Assert.assertEquals(actual,expected);
    }

    public void myAssertEquals(boolean actual, boolean expected){
        logger.info("断言期望值【"+expected+"】实际值【"+actual+"】");
        Assert.assertEquals(actual,expected);
    }
}
