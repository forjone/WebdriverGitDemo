package com.demo.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/12.
 */
public class SendEmail extends BaseCaseBroswer {
    @Test
    public void sendEmailFile() throws InterruptedException {
        driverChrome.get("http://mail.163.com/");
        EmailLoginCase.loginEmail(driverChrome, "dreamingxuanyu", "wclggf0916");
//        Thread.sleep(10000);
//        显式等待
        WebDriverWait elementWait = new WebDriverWait(driverChrome, 10);
        elementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")));
        WebElement sendEmailElement = driverChrome.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]"));

        sendEmailElement.click();
        WebElement receivePerson = driverChrome.findElement(By.xpath(".//*[@class='bz0']/div[2]/div/input"));
        WebElement emailTitle = driverChrome.findElement(By.xpath(".//*[@class='tH0']/header/div[2]/div/div/div/input"));
        WebElement addFile = driverChrome.findElement(By.xpath(".//*[@class='ia0']/div/div[2]/input"));
        receivePerson.sendKeys("dreamingxuanyu@163.com");
        emailTitle.sendKeys("测试附件邮件");
        addFile.sendKeys("C:\\Users\\thinkpad\\Pictures\\5.jpg");

        //        编写邮件正文
        driverChrome.switchTo().frame(driverChrome.findElement(By.className("APP-editor-iframe")));
        WebElement emailBody = driverChrome.findElement(By.xpath("html/body"));
        emailBody.sendKeys("这是一封测试的邮件");

//        页面控制回到主页面
        driverChrome.switchTo().defaultContent();

//点击“发送”按钮
        driverChrome.findElement(By.xpath(".//*[@id='dvContainer']/div/header/div/div[1]/div/span[2]")).click();
        elementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='发送成功']")));
//        结果判断，但是不成功，无法获取H1中的文本内容
        WebElement checkStatus = driverChrome.findElement(By.xpath(".//*[text()='发送成功']"));
        String checkStatusText = checkStatus.getAttribute("innerText");
        System.out.println("执行结果 ： " + checkStatusText);
        boolean resultStatus = checkStatus.isDisplayed();
        Assert.assertTrue(resultStatus,"发送失败");

    }
}
