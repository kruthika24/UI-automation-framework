package com.newloads.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLoadPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath="(//button[@type='button']/span[contains(text(),'Post Loads')]")
    private WebElement postLoadsText;

    @FindBy(xpath = "//a[contains(text(),'Create a new load')]")
    private WebElement createLoadstxt ;

    @FindBy(xpath = "//*[@id=\"root\"]/section/header/div/div[3]/h3")
    private WebElement helloTxt ;

    @FindBy(xpath = "(//button[@type='button']/span[contains(text(),'Post Load')])[2]")
    private WebElement submitPostLoadsTxt ;

    @FindBy(xpath = "//button[@type='button']/span[contains(text(),'Continue')]")
    private WebElement continueTxt ;

    @FindBy(xpath = "(//table[@class='ant-calendar-table']/tbody[@class='ant-calendar-tbody']/tr[@role ='row']/td[@title =\"March 20, 2022\"]/div[contains(text(), '1')])[2]")
    private WebElement fromDateTxt ;

    @FindBy(xpath = "//span[@class='ant-form-item-children']/textarea[@id='notes']")
    private WebElement notesTxt ;

    @FindBy(xpath = "//table[@class='ant-calendar-table']/tbody[@class='ant-calendar-tbody']/tr[@role ='row']/td[@title ==\"March 25, 2022\"]/div]/div[contains(text(), '1')])[2]")
    private WebElement ToDateTxt ;


    public  NewLoadPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        // initialise
        PageFactory.initElements(driver,this);
    }

    public void goTo() {
    this.driver.get("https://app.newloads.com/loads");
    this.wait.until(ExpectedConditions.visibilityOf(this.helloTxt));
    }


    public void enterFirstPageLoadDetails(String pickUp, String dropOff, String vehicleType ){
        this.createLoadstxt.sendKeys(pickUp);
        this.createLoadstxt.sendKeys(dropOff);
        this.createLoadstxt.sendKeys(vehicleType);
        this.continueTxt.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.submitPostLoadsTxt));
        this.submitPostLoadsTxt.click();
    }
}
