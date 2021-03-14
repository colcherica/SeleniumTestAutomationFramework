package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
     WebDriver driver;

    public MainPage ( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    Locators
    @FindBy(tagName = "h1")
    WebElement headingTitle;

    @FindBy(tagName = "h2")
    WebElement subtitleHeading;

    @FindBy(linkText = "A/B Testing")
    WebElement A_B_Testing;
    @FindBy(linkText = "Add/Remove Elements")
    WebElement Add_Remove;

    @FindBy(tagName = "a") public List<WebElement> allLinks;

    public String getTitleText(){
        return headingTitle.getText();
    }

    public String getSubtitleText(){
        return subtitleHeading.getText();
    }

//    Actions
    public boolean allLinksDisplayed() {
        for (WebElement link : allLinks) {
            link.isDisplayed();
        }
        return false;
    }

    public void click_on_ABPage(){
        A_B_Testing.click();
    }

    public void click_on_add_remove(){
        Add_Remove.click();

    }
}
