package com.newloads.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        // initialise
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//button[@type='button']/span[contains(text(),'Login')]")
    private WebElement loginBtnTxt ;

    @FindBy(xpath = "(//button[@type='button']/span[contains(text(),'Send OTP')])[2]")
    private WebElement otpBtnTxt ;

    @FindBy(xpath = "(//button[@type='button']/span[contains(text(),'Send OTP')])[2]")
    private WebElement otpValueTxt ;

    @FindBy(xpath = "span[class='ant-checkbox']")
    private WebElement checkBox ;

    @FindBy(xpath = "//*[@id=\"root\"]/section/header/div/div[3]/h3")
    private WebElement helloTxt ;

    @FindBy(xpath = "\"//div[contains(text(),'Vehicles on NewLoads')]\"")
    private WebElement loginTxt ;

    @FindBy(xpath = "input[type=\"tel\"]")
    private WebElement mobileNumberTxt ;


    public void goTo(String mobilenumber, String otp) {
        this.driver.get("https://app.newloads.com/login");
        this.wait.until(ExpectedConditions.visibilityOf(this.loginTxt));
        this.mobileNumberTxt.sendKeys(mobilenumber);
        this.otpBtnTxt.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.loginBtnTxt));
        this.otpValueTxt.sendKeys(otp);
        this.wait.until(ExpectedConditions.visibilityOf(this.helloTxt));
    }
}
