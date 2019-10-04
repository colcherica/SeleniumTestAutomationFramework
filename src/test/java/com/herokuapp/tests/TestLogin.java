package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.HomePage;
import com.herokuapp.webpages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class TestLogin extends Base {

    @Test
    public void login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.isPageOpened();
        loginPage.isPageContentAvailable();
        try {
            loginPage.loginToInternet("tomsmith", "SuperSecretPassword!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.successMsg();
        homePage.isTitlePageavailable();
        homePage.clickLogoutBtn();

    }

    @Test
    public void neg_password_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        try {
            loginPage.loginToInternet("tomsmith", "Super");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginPage.clickLoginBtn();
        loginPage.errorPasswordMsg();

    }

    @Test
    public void neg_userName_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        try {
            loginPage.loginToInternet("toms", "SuperSecretPassword!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginPage.clickLoginBtn();
        loginPage.errorUserNameMsg();

    }
}
