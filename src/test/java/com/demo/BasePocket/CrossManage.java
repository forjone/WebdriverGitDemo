package com.demo.BasePocket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by thinkpad on 2017/1/11.
 */
public class CrossManage  {
    @Test
    public void test(WebDriver driverChrome)   {


         driverChrome = BroswerInit.getInstans();

//        driverChrome.get("http://www.baidu.com");

    }

}
