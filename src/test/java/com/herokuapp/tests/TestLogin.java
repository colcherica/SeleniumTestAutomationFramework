package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.HomePage;
import com.herokuapp.webpages.LoginPage;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;


public class TestLogin extends Base {
    Logger log = Logger.getLogger(TestLogin.class.getName());
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test()
    public void login_logout_validation () {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.navigate().to(configFileReader.getApplicationUrl() + "/login");
        log.info("Login to " + driver.getCurrentUrl());

        loginPage.loginToInternet("tomsmith", "SuperSecretPassword!");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Assert.assertEquals(homePage.getSuccessMsgText().substring(0,30), "You logged into a secure area!");
        Assert.assertEquals(loginPage.getTitlePageText(),"Secure Area");

        homePage.clickLogoutBtn();
        Assert.assertEquals(loginPage.getLogoutSuccessMsg().substring(0,34), "You logged out of the secure area!");
    }

    @Test
    public void login_validation_with_response_code() throws IOException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        driver.navigate().to(configFileReader.getApplicationUrl() + "/login");

        log.info("Login to" + driver.getCurrentUrl());
        loginPage.loginToInternet("tomsmith", "SuperSecretPassword!");
        loginPage.getRespondsCode(configFileReader.getApplicationUrl() + "/secure");
        homePage.clickLogoutBtn();

    }

    @Test
    public void neg_password_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.navigate().to(configFileReader.getApplicationUrl() + "/login");

        loginPage.loginToInternet("tomsmith", "Super");
        Assert.assertEquals(loginPage.getErrorPassMsgText().substring(0,25),"Your password is invalid!");

    }

    @Test
    public void neg_userName_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.navigate().to(configFileReader.getApplicationUrl() + "/login");

        loginPage.loginToInternet("toms", "SuperSecretPassword!");
        Assert.assertEquals(loginPage.getErrorUserNameMsg().substring(0,25),"Your username is invalid!");
    }
}
