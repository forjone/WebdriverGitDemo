package com.demo.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by thinkpad on 2017/1/12.
 */
public class EmailLoginCase {
    public static void loginEmail(WebDriver driverChrome , String userName , String password) throws InterruptedException {
        Thread.sleep(5000);
        WebElement LoginFrame = driverChrome.findElement(By.id("x-URS-iframe"));
        driverChrome.switchTo().frame(LoginFrame);
        driverChrome.findElement(By.name("email")).sendKeys(userName);
        driverChrome.findElement(By.name("password")).sendKeys(password);
        driverChrome.findElement(By.xpath(".//*[@id='dologin']")).click();


    }
}
