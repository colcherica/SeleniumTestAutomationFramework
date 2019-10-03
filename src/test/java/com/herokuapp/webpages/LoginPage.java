package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

//    constructor page
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

//    Locators

    @FindBy(how = How.ID,using = "username")
    WebElement userName;
    @FindBy(how = How.ID, using = "password")
    WebElement password;
    @FindBy(how = How.XPATH,using = ".//button[contains(@type, 'submit')]")
    WebElement loginBtn;
    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement textTitlePage;

    public void setUserName(String strUserName){
        userName.sendKeys(strUserName);
    }

    public void setPassword(String srtPassword){
        password.sendKeys(srtPassword);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String getTextTitlePage(){
        return textTitlePage.getText();

    }


}
