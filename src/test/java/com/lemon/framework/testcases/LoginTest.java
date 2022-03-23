package com.lemon.framework.testcases;

import com.lemon.framework.common.BaseTest;
import com.lemon.framework.pages.IndexPage;
import com.lemon.framework.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test
    @Parameters({"udid","appium_port","uiautomator2_port"})
    public void test_login_success(String udid, String appium_port, String uiautomator2_port) {
        AndroidDriver driver = openApp(udid,appium_port,uiautomator2_port);
        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("13323234545","234545");

        //断言
        //1、根据用户名昵称来做断言
        myAssertEquals(indexPage.getAvatarText(),"歪歪XX");
    }

    /*@Test(dataProvider = "getLoginFailedDatas")
    public void test_login_failed(String phone, String password, String expected) {
        //打开测试的App
        AndroidDriver driver = openApp();
        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(phone,password);

        //断言
        //1、根据toast信息做断言
        myAssertEquals(loginPage.getToastText(expected),expected);
        //退出app
        driver.quit();
    }*/

    @DataProvider
    public Object[][] getLoginFailedDatas(){
        Object[][] datas = {
                {"13323234545","123456","错误的账号信息"},
                {"13323234545","","手机号码或密码不能为空"},
                {"133232345451","123456","错误的账号信息"},
                {"","123456","手机号码或密码不能为空"}
        };
        return datas;
    }
}
