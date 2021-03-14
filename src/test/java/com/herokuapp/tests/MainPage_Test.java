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

    @Test
    public void gotoAB_Page() {
        MainPage mainPage = new MainPage(driver);
        mainPage.click_on_ABPage();
        A_B_TestingPage a_b_testingPage = new A_B_TestingPage(driver);
        Assert.assertEquals(a_b_testingPage.getPagedescription(),"Also known as split testing. This is a way" +
                " in which businesses are able to simultaneously test and learn different versions of a page to see" +
                " which text and/or functionality works best towards a desired outcome (e.g. a user action such as a" + "" +
                " click-through).");
    }
}