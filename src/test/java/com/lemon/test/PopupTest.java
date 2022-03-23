package com.lemon.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PopupTest {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        //打开测试的App
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "127.0.0.1:62001");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "tv.danmaku.bili");
        capabilities.setCapability("appActivity", ".MainActivityV2");
        //不清除App的数据启动测试App
        capabilities.setCapability("noReset", false);
        //参数一：Appium服务器的地址  参数二：打开指定设备App的相关配置
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //点击搜索栏
        getElement(driver,MobileBy.id("tv.danmaku.bili:id/expand_search")).click();

        //等待3S关闭App
        Thread.sleep(3000);
        driver.close();
    }

    /**
     * 定位元素二次封装--加了弹窗异常处理
     * @param driver 驱动对象
     * @param by 元素定位
     * @return 定位到的元素
     */
    public WebElement getElement(AndroidDriver<WebElement> driver,By by){
        try {
            return driver.findElement(by);
        }catch (Exception e){
            //进入处理弹窗流程...
            handleAlert(driver);
            //最终再定位元素
            return driver.findElement(by);
        }
    }

    public void handleAlert(AndroidDriver<WebElement> driver){
        //得到当前页面源码
        String pageSource = driver.getPageSource();
        //将需要处理的弹窗信息存到黑名单中
        HashMap<String,By> blackMap = new HashMap<>();
        blackMap.put("tv.danmaku.bili:id/agree",MobileBy.id("tv.danmaku.bili:id/agree"));
        //循环遍历黑名单列表，处理弹窗
        for (Map.Entry<String,By> entry :blackMap.entrySet()){
            //判断当前页面是否存在弹窗
            if(pageSource.contains(entry.getKey())){
                //点掉弹窗
                driver.findElement(entry.getValue()).click();
            }
        }
    }
}
