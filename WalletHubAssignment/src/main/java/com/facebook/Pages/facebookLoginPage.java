package com.facebook.Pages;

/*
* This  will store all the locators and methods of facebook login page
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookLoginPage {

    WebDriver driver= new ChromeDriver();

    public  void launchLoginPage()
    {
        driver.manage().window().fullscreen();
        driver.get("https://www.facebook.com/");
    }

    public void enterUsername(String clientUsername)
    {
        driver.findElement(By.id("email")).sendKeys(clientUsername);

    }

    public void enterPassword(String clientPassword)
    {
        driver.findElement(By.id("pass")).sendKeys(clientPassword);
    }

    public void clickOcLoginButton()
    {
        driver.findElement(By.id("u_0_b")).click();
    }

}

