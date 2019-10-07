package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage ( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash success')]")
    WebElement loginSuccessMsg;

    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement titlePage;

    @FindBy(how = How.XPATH, using = "//*[@id='content']/div/a/i")
    WebElement logoutBtn;

    public void successMsg(){
        if (loginSuccessMsg.isDisplayed()){
            System.out.println("Success login message is present " + loginSuccessMsg.getText());
        }else {
            System.out.println("Success login message is not present " + loginSuccessMsg.getText());
        }

    }

    public void isTitlePageAvailable(){
        if (titlePage.isDisplayed()){
            System.out.println("Title of Home Page is present " + titlePage.getText());
        }else {
            System.out.println("Title of Home Page is not present " + titlePage.getText());
        }
    }

    public void clickLogoutBtn(){
        logoutBtn.click();
    }
}
