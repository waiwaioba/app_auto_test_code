package com.lemon.framework.pages;

import com.lemon.framework.common.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class IndexPage extends BasePage {
    private By mylemon_by = MobileBy.AccessibilityId("我的柠檬");
    private By myavatar_by = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_layout");
    private By myavatar_title_by = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");

    public IndexPage(AndroidDriver driver){
        super(driver);
    }

    public void enterLoginPage(){
        //1、点击我的柠檬
        click(mylemon_by);
        //2、点击我的头像
        click(myavatar_by);
    }

    public String getAvatarText(){
        return getElementText(myavatar_title_by);
    }

}
