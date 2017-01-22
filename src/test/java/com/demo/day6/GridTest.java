package com.demo.day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by thinkpad on 2017/1/20.
 */
public class GridTest {
    WebDriver driverChrome;
    @Test
    public  void gridSlaveTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities chromeDc = DesiredCapabilities.firefox();
        driverChrome = new RemoteWebDriver(new URL("http://172.16.0.37:5505/wd/hub"),chromeDc);
        driverChrome.get("http://www.baidu.com");
        Thread.sleep(5000);
        driverChrome.quit();
    }
}
