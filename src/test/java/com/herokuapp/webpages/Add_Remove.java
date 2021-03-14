package com.herokuapp.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class Add_Remove {

     WebDriver driver;

    public Add_Remove ( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    Locators
    @FindBy(tagName = "h3")
    WebElement titlePage;

    @FindBy(tagName = "button")
    WebElement add_btn;

    @FindBy(className = "added-manually")
    WebElement delete_btn;

    @FindBy(id = "elements")
    WebElement delete_section;
//    Actions
    public String getTitlePageText(){
        return titlePage.getText();
    }

    public void click_add_btn(){
        add_btn.click();
    }

    public void click_detele_btn(){
        delete_btn.click();
    }

    public boolean isDeleteBtnDisplayed(){
        delete_btn.isDisplayed();
        return false;
    }

    public boolean deleteBtnNotDisplayed(){
        delete_section.isEnabled();
        return false;
    }

}
