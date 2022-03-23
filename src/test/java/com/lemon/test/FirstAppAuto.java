package com.lemon.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstAppAuto {
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
        //设置全局的隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Thread.sleep(4000);
        //元素定位
        //1、ID定位
        //driver.findElement(MobileBy.id("com.lemon.lemonban:id/navigation_my")).click();
        //2、text定位
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"柠檬社区\")")).click();
        //3、className定位
        /*List<WebElement> list = driver.findElements(MobileBy.className("android.widget.LinearLayout"));
        System.out.println(list.size());*/
        //4、accessbility id定位
        //driver.findElement(MobileBy.AccessibilityId("题库")).click();
        //System.out.println(driver.getPageSource());
        //5、xpath定位
        //driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='柠檬社区']")).click();

        //6、xpath轴定位
        //登录
        //1、点击题库
        driver.findElement(MobileBy.AccessibilityId("题库")).click();
        //Thread.sleep(1000);
        //2、点击去登陆按钮
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/button_go_login")).click();
        //Thread.sleep(1000);
        //3、输入手机号码
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_mobile")).sendKeys("13323234545");
        //4、输入密码
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_password")).sendKeys("234545");
        //5、点击登录按钮
        //driver.findElement(MobileBy.id("com.lemon.lemonban:id/btn_login")).click();
        waitElementClickable(driver,MobileBy.id("com.lemon.lemonban:id/btn_login")).click();
        //Thread.sleep(3000);
        //选择题库-Java自动化后面的学习人数
        String text = driver.findElement(MobileBy.
                xpath("//android.widget.TextView[@text='Java自动化']/following-sibling::android.widget.TextView[contains(@text,'人练习')]")).getText();
        System.out.println(text);

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
