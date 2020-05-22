package com.wallethub.review;

/*
 * This  will store all the locators and methods of WalletHub login page
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class wallethubLoginPage {

    WebDriver driver= new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,30);
    JavascriptExecutor js= (JavascriptExecutor) driver;


    public  void launchLoginPage()
    {
        driver.manage().window().fullscreen();
        driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"web-app\"]/header/div/nav[1]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"join-login\"]/form/div[1]/input")));
        driver.findElement(By.xpath("//*[@id=\"join-login\"]/form/div[1]/input")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"join-login\"]/form/div[2]/input")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"join-login\"]/form/div[4]/button[2]")).click();
    }

    public void select_star() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,650)", "");
        Thread.sleep(2000);
        List<WebElement> webElements= driver.findElements(By.className("rvs-star-svg"));
        Actions actions= new Actions(driver);
        for(int i=10;i<=13; i++ )
        {
            actions.moveToElement(webElements.get(i)).build().perform();
            Thread.sleep(500);
        }

        webElements.get(13).click();

    }

    public void dropdown_selection()
    {
        driver.findElement(By.xpath("//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/ng-dropdown/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/ng-dropdown/div/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/div[1]/textarea"))
                .sendKeys("On the reviews section of the page, hover over the stars and click on\n" +
                        "the fourth star. Your code should actually (a) do the hover and (b) make\n" +
                        "sure the stars inside get lit up when you hover over them, then (c) click\n" +
                        "on the fourth star. Simply redirecting the WebDriver to the next page\n" +
                        "isn’t an option.\n");
        driver.findElement(By.xpath("//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/sub-navigation/div/div[2]")).click();

    }

}
