package com.wallethub.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class review_Thanks_Page {

    WebDriver driver= new ChromeDriver();

    public void profile_page_redirection()
    {
        driver.findElement(By.xpath("//*[@id=\"web-app\"]/header/div/nav[1]/div[5]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"web-app\"]/header/div/nav[1]/div[5]/div/a[1]")).click();

    }
}
