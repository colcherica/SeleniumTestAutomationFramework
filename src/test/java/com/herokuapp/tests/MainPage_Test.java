package com.herokuapp.tests;

import com.herokuapp.Base;
import com.herokuapp.webpages.A_B_TestingPage;
import com.herokuapp.webpages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPage_Test extends Base {

    @Test
    public void openMainPage() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getTitleText(), "Welcome to the-internet");
        Assert.assertEquals(mainPage.getSubtitleText(), "Available Examples");
        Assert.assertFalse(mainPage.allLinksDisplayed(), "All links from " + MainPage.class.getName() +
                " are displayed on the page");
    }
}