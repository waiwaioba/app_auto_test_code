package com.lemon.framework.listener;

import com.lemon.framework.common.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class TestResultListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //保证测试方法能够正常执行
        callBack.runTestMethod(testResult);
        //监听用例的执行状态-异常情况
        if(testResult.getThrowable() != null){
            //用例异常之后处理-截图
            //当前测试类的实例
            BaseTest baseTest = (BaseTest) testResult.getInstance();
            takeScreenshotToAllure(baseTest.driver);
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshotToAllure(AndroidDriver driver){
        //输出截图，格式是为字节数组
        byte[] datas = driver.getScreenshotAs(OutputType.BYTES);
        return datas;
    }
}
