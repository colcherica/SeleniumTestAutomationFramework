package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'flash success')]")
    WebElement loginSuccessMsg;

    @FindBy(how = How.TAG_NAME, using = "h2")
    WebElement titlePage;

    @FindBy(how = How.XPATH, using = "//*[@id='content']/div/a/i")
    WebElement logoutBtn;

    public String getSuccessMsgText() {
        return loginSuccessMsg.getText();
    }

    public String getTitlePage() {
        return titlePage.getText();
    }

    public void clickLogoutBtn() {
        if (logoutBtn.isDisplayed()) {
            System.out.println("Logout button is present in the page" + logoutBtn.getText());
        } else {
            System.out.println("Logout button is not present in the page" + logoutBtn.getText());
        }
        logoutBtn.click();
    }
}
