package com.demo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by thinkpad on 2016/12/30.
 */
public class ActionTest extends BrowserOpenClose {


    @Test
    public  void ActionOperation() throws InterruptedException {
    Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement baiduButton = Driver.findElement(By.id("su"));
//        实例化Action类
        Actions actions = new Actions(Driver);
//        右键百度一下按钮
        actions.contextClick(baiduButton).perform();
        Thread.sleep(5000);
        actions.doubleClick().perform();

    }


    @Test
    public void moveToElement () throws InterruptedException {
        Driver.get("http://www.baidu.com");
        WebElement xialaButton = Driver.findElement(By.name("tj_briicon"));
        WebElement baiduButton = Driver.findElement(By.id("su"));
        Actions moveElement = new Actions(Driver);
        moveElement.moveToElement(xialaButton).perform();
        Thread.sleep(5000);
        //移动元件到特定位置（x，y）
//        moveElement.dragAndDropBy(baiduButton,1001,1000).perform();

    }

    @Test
    public void selectChooseMoreChrome() throws InterruptedException {
        driverChrome.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement selectMore = driverChrome.findElement(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']"));
        Actions selectAvtion = new Actions(driverChrome);
        List<WebElement> list = selectMore.findElements(By.tagName("option"));
//        selectAvtion.click(list.get(1));
//  点下选项，按下shift，在点击另一个，实现两个选项之间的连选
//        selectAvtion.keyDown(Keys.SHIFT).click(list.get(1)).click(list.get(3)).perform ();

//        selectAvtion.click(list.get(1)).keyDown(Keys.SHIFT).click(list.get(3)).perform ();
        selectAvtion.click(list.get(1)).keyDown(Keys.CONTROL).click(list.get(3)).perform();
        Thread.sleep(10000);

    }

    @Test
    public void selectChooseMoreFirefox() throws InterruptedException {
        Driver.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement selectMore = Driver.findElement(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']"));
        Actions selectAvtion1 = new Actions(Driver);
        List<WebElement> list = selectMore.findElements(By.tagName("option"));
//        selectAvtion.click(list.get(1));
//  点下选项，按下shift，在点击另一个，实现两个选项之间的连选
//        selectAvtion.keyDown(Keys.SHIFT).click(list.get(1)).click(list.get(3)).perform ();

        selectAvtion1.click(list.get(1)).keyDown(Keys.SHIFT).click(list.get(3)).perform ();
        Thread.sleep(10000);


    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
//        DriverChrome.get("http://www.baidu.com");
        driverChrome.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement inputBox= driverChrome.findElement(By.xpath("//*[@id=\"user\"]"));
        inputBox.sendKeys("sfhsdfksdhfsdfsa");
        Thread.sleep(5000);
        inputBox.clear();
        Thread.sleep(1000);
        inputBox.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);

        int s1 = (int) new Character('A');
        int s2 = (int) new Character('S');



//        Robot无法区分输入的大小写
/*

        System.out.println("A = "+ s1);
        System.out.println("S = "+ s2);
        robot.keyPress(s1);
        robot.keyPress(s2);
        String textCheck = inputBox.getAttribute("innerHTML");
        System.out.println("result :"+ textCheck);

*/
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    @Test
    public void test1(){
        int s1 = (int) new Character('A');
        int s2 = (int) new Character('a');
        System.out.println("A = "+ s1);
        System.out.println("a = "+ s2);
    }

    @Test
    public  void upload(){
        driverChrome.get("file:///E:/selenium_test/selenium_html/index.html");
        WebElement uploadButton = driverChrome.findElement(By.xpath(".//*[@id='load']"));
        uploadButton.sendKeys("E:\\mf\\foldersizeportable.zip");
    }


}
