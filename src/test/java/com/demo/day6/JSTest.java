package com.demo.day6;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/16.
 */
public class JSTest {
    WebDriver driver;
    @Test
    public  void jsTest(){

        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("打开chrome浏览器成功");

        driver.get("https://www.baidu.com/");
/*      使用JS进行操作

        */
//      讲driver强制转换成JS处理对象
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        JS语句，实现往输入框里面输入“minrichuanqi”
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"mingrichuanqi\")");


    }
}
