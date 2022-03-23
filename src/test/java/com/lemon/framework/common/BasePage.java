package com.lemon.framework.common;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/3/19 15:48
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BasePage {

    private AndroidDriver driver;
    private Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(AndroidDriver driver){
        this.driver=driver;
    }

    public void click(By by){
        waitElementClickable(by).click();
        logger.info("点击了元素【"+by+"】");
    }

    public void type(By by,String data){
        waitElementVisible(by).sendKeys(data);
        logger.info("往输入框元素【"+by+"】输入了数据【"+data+"】");
    }

    public String getElementText(By by){
        String str = waitElementPresence(by).getText();
        logger.info("获取元素【"+by+"】文本【"+str+"】");
        return str;
    }

    public WebElement waitElementClickable(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitElementVisible(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitElementPresence(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
