package com.lemon.test;


import com.lemon.framework.common.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseTest {
    @Test
    public void test() throws InterruptedException, IOException {
        /*AndroidDriver driver = openApp();
        Thread.sleep(3000);
        //截图
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        //目标地址file对象
        //File dstFile = new File("D:\\software\\app\\test.png");
        //保存到本地的项目工程目录下
        File dstFile = new File(System.getProperty("user.dir")+"\\test.png");
        //保存到本地
        FileUtils.copyFile(srcFile,dstFile);*/

    }
}
