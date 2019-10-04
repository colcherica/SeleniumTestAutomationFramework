package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class TestLogin extends Base {

    @Test
    public void login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.isPageOpened();
        loginPage.isPageContentAvailable();
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginBtn();
    }

    @Test
    public void neg_password_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("ssasda");
        loginPage.clickLoginBtn();
        loginPage.errorPasswordMsg();

    }

    @Test
    public void neg_userName_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserName("t");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginBtn();
        loginPage.errorUserNameMsg();

    }
}
