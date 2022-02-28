package com.newloads.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostLoadSubmitPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//button[@type='button']/span[contains(text(),'Post Load')])[2]")
    private WebElement submitPostLoadsTxt ;

    @FindBy(xpath = "//button[@type='button']/span[contains(text(),'Continue')]")
    private WebElement continueTxt ;

    @FindBy(xpath = "//span[contains(text(),\"Load posted successfully\")]")
    private WebElement successNotificationTxt ;

    public PostLoadSubmitPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void submitLoads(){

        this.wait.until(ExpectedConditions.visibilityOf(this.successNotificationTxt));
        System.out.println("Load posted successfully");
    }
}
