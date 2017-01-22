package com.demo.day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/16.
 */
public class PhantomJsTest {
    @Test
    public void phantomTest(){

//        使用phantom浏览器测试，但是浏览器并不会打开一个可见的浏览器，这是一个纯后台的浏览器，可以用于制作爬虫爬取数据

         System.setProperty("phantomjs.binary.path",".\\drivers\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com/");
        System.out.println(driver.getTitle());
    }
}
