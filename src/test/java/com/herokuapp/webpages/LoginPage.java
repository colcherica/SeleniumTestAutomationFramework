package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
        System.out.printf(String.valueOf(textTitlePage.getText()));
        return textTitlePage.getText().toString().contains("Login Page");
    }

    public String isPageContentAvailable(){
        System.out.printf(textContentPage.getText());
        return textContentPage.getText();
    }

    public boolean errorPasswordMsg(){
        System.out.println(invalidPassword.getText());
        return invalidPassword.getText().toString().contains("Your password is invalid!");
    }

    public boolean errorUserNameMsg(){
        System.out.printf(invalidUserName.getText());
        return invalidUserName.getText().toString().contains("Your username is invalid!");
    }


}
