package com.lemon.framework.pages;

import com.lemon.framework.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    //1、手机号码输入框
    private By phone_by = MobileBy.id("com.lemon.lemonban:id/et_mobile");
    //2、密码输入框
    private By password_by = MobileBy.id("com.lemon.lemonban:id/et_password");
    //3、登录按钮
    private By login_button_by = MobileBy.id("com.lemon.lemonban:id/btn_login");
    //4、错误的账号信息对应的toast元素
    private By error_account_toast_by = MobileBy.xpath("//*[contains(@text,'错误的账号信息')]");

    public LoginPage(AndroidDriver driver){
        super(driver);
    }

    public void login(String phone, String password){
        //3、输入手机号码
        type(phone_by,phone);
        //4、输入密码
        type(password_by,password);
        //5、点击登录按钮
        click(login_button_by);
    }

    public String getToastText(String text){
        return getElementText(MobileBy.xpath("//*[contains(@text,'"+text+"')]"));
    }

}
