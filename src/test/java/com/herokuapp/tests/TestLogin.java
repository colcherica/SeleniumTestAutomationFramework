package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class TestLogin extends Base {

    @Test
    public void login_validation() throws Exception{


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginBtn();
        loginPage.getTextTitlePage();
    }
}
