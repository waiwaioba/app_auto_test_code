package com.lemon.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumApiTest {
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
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,capabilities);
        Thread.sleep(3000);
        //1、获取当前前台正在运行的页面名
        //System.out.println(driver.currentActivity());
        //2、获取页面源代码
        //System.out.println(driver.getPageSource());
        //3、获取配置参数
        //System.out.println(driver.getCapabilities().getCapability("deviceName"));
        //4、获取设备时间信息
        /*System.out.println(driver.getDeviceTime());
        //5、获取设备DPI，注意不是分辨率
        System.out.println(driver.getDisplayDensity());
        //获取automation name，默认为null，如果有指定automation name为uiautomator2就为对应的值
        System.out.println(driver.getAutomationName());
        //获取设备横竖屏状态，有PORTRAIT(竖屏)与LANDSCAPE(横屏)
        System.out.println(driver.getOrientation());*/

        //=======================安装卸载启动类API======================
        //1、重置应用数据
        //driver.resetApp();
        //2、activity跳转
        //Activity activity = new Activity("com.lemon.lemonban", "com.lemon.lemonban.activity.LoginActActivity");
        //driver.startActivity(activity);
        //3、判断某个app是否安装
        //driver.isAppInstalled("com.lemon.lemonban");
        //4、安装app
        //driver.installApp("D:\\apk\\baidumap.apk");
        //5、关闭app
        //driver.closeApp();

        //=======================元素操作相关API=======================
        WebElement webElement = driver.findElement(MobileBy.AccessibilityId("题库"));
        webElement.click();
        //1、content-desc
        /*System.out.println(webElement.getAttribute("content-desc"));
        //2、获取元素text属性
        System.out.println(webElement.getAttribute("text"));
        //3、获取元素className属性
        System.out.println(webElement.getAttribute("className"));
        //4、获取元素resourceId
        System.out.println(webElement.getAttribute("resourceId"));*/

        //5、清除输入框的数据
        /*driver.findElement(MobileBy.id("com.lemon.lemonban:id/button_go_login")).click();
        Thread.sleep(1000);
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_mobile")).sendKeys("13323234545");
        Thread.sleep(1000);
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_mobile")).clear();
        */

        //6、截图
        /*File file = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("D:\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //7、发送按键操作
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/button_go_login")).click();
        Thread.sleep(2000);
        KeyEvent key = new KeyEvent();
        key.withKey(AndroidKey.BACK);
        driver.pressKey(key);
    }

    public WebElement waitElementClickable(AndroidDriver driver,By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitElementVisible(AndroidDriver driver,By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementPresence(AndroidDriver driver,By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
