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
        PageFactory.initElements(driver, this);
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
    @FindBy(how = How.TAG_NAME, using = "h4")
    WebElement textContentPage;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash error')]")
    WebElement invalidPassword;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash error')]")
    WebElement invalidUserName;


    public void setUserName(String strUserName){
        userName.sendKeys(strUserName);
    }

    public void setPassword(String srtPassword){
        password.sendKeys(srtPassword);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public boolean isPageOpened(){
        System.out.printf(textTitlePage.getText() + "\n");
        return textTitlePage.getText().contains("Login Page");
    }

    public String isPageContentAvailable(){
        System.out.printf(textContentPage.getText() + "\n");
        return textContentPage.getText();
    }

    public boolean errorPasswordMsg(){
        System.out.println(invalidPassword.getText() + "\n");
        return invalidPassword.getText().contains("Your password is invalid!");
    }

    public boolean errorUserNameMsg(){
        System.out.printf(invalidUserName.getText() + "\n");
        return invalidUserName.getText().contains("Your username is invalid!");
    }


}
