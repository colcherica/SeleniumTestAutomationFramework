package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.DropDownPage;
import com.herokuapp.webpages.HomePage;
import com.herokuapp.webpages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;


public class TestLogin extends Base {
    Logger log = Logger.getLogger(TestLogin.class.getName());

    @Test()
    public void login_validation () {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        log.info("Login to " + driver.getCurrentUrl());
        loginPage.isTitlePageAvailable();
        loginPage.isPageContentAvailable();
        loginPage.loginToInternet("tomsmith", "SuperSecretPassword!");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.successMsg();
        homePage.isTitlePageAvailable();
        homePage.clickLogoutBtn();

    }

    @Test
    public void login_validation_with_response_code() throws IOException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        log.info("Login to" + driver.getCurrentUrl());

        loginPage.loginToInternet("tomsmith", "SuperSecretPassword!");
        loginPage.getRespondsCode("http://the-internet.herokuapp.com/secure");
        homePage.clickLogoutBtn();

    }

    @Test
    public void neg_password_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToInternet("tomsmith", "Super");
        loginPage.errorPasswordMsg();

    }

    @Test
    public void neg_userName_login_validation(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToInternet("toms", "SuperSecretPassword!");
        loginPage.errorUserNameMsg();

    }

    @Test
    public void dropdownClick() throws Exception {
        DropDownPage ddp = PageFactory.initElements(driver, DropDownPage.class);
        ddp.clickOnDropDownMenu();
    }
}
