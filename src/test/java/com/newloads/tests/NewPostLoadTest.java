package com.newloads.tests;

import com.newloads.pages.LoginPage;
import com.newloads.pages.NewLoadPage;
import com.newloads.pages.PostLoadSubmitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.cert.TrustAnchor;

public class NewPostLoadTest {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        //set path
        System.setProperty("webdriver.chrome.driver", "C:/NotBackedUp/Numadic/chromedriver.exe");
        this.driver = new ChromeDriver();
    }


    @Test
    public void loginPageTest(){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.goTo("9090909090", "123123");
    }

    @Test (dependsOnMethods = "loginPageTest")
    public  void newloadPageTest(){
        NewLoadPage newLoadPage = new NewLoadPage(driver);
       // execute below in the absence of otp-login
       // newLoadPage.goTo();
        newLoadPage.enterFirstPageLoadDetails("Goa,","Bengaluru", "Truck");
    }

    @Test(dependsOnMethods = "newloadPageTest")
    public  void  postloadSubmitPage(){
        PostLoadSubmitPage postLoadSubmitPage = new PostLoadSubmitPage(driver);
        postLoadSubmitPage.submitLoads();
    }
}
