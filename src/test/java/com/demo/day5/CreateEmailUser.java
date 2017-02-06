package com.demo.day5;

import com.demo.day3.BrowserOpenClose;
import com.demo.day7.PageObject.CreateUserObject;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2017/1/10.
 * 新建邮箱账户
 */
public class CreateEmailUser extends BrowserOpenClose {

    long time = System.currentTimeMillis();


//全局的等待
    @BeforeMethod
    public  void delay(){
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void addEmailUser() throws InterruptedException {

        driverChrome.get("http://mail.163.com/");
        String loginHandle = driverChrome.getWindowHandle();
        WebElement iframeMailLogin = driverChrome.findElement(CreateUserObject.loginFrame);
        driverChrome.switchTo().frame(iframeMailLogin);
        WebElement registerButton = driverChrome.findElement(CreateUserObject.registerButton);
        registerButton.click();
        Thread.sleep(2000);
        for (String handles : driverChrome.getWindowHandles()) {
            if (handles.equals(loginHandle)) {
                continue;
            } else {
                driverChrome.switchTo().window(handles);
            }
        }
//        点击注册字母邮箱
        driverChrome.findElement(CreateUserObject.englishEmail).click();
//        给邮箱地址赋值
        driverChrome.findElement(CreateUserObject.emailAddress).sendKeys("XUAN" + String.valueOf(time));
//        给密码赋值
        driverChrome.findElement(CreateUserObject.passwordFirst).sendKeys("123qwe");
//        给确认密码赋值
        driverChrome.findElement(CreateUserObject.passwordSecond).sendKeys("123qwe");
//        给手号码机赋值
        driverChrome.findElement(CreateUserObject.phoneNo).sendKeys(String.valueOf(time / 100));
//        给图片验证码赋值
        driverChrome.findElement(CreateUserObject.photoCheck).sendKeys("1231");
//        给短信验证码赋值
        driverChrome.findElement(CreateUserObject.smsCheck).sendKeys("123233");
        Thread.sleep(3000);

        driverChrome.findElement(CreateUserObject.submitButton).click();
        Thread.sleep(3000);
        WebElement msgErrorRemindElement1 = driverChrome.findElement(CreateUserObject.checkElement);
        String errorRemind = msgErrorRemindElement1.getText().trim();  //.trim表示忽略空格
        System.out.println("对象提示信息 : " + errorRemind);
        Assert.assertEquals(errorRemind,"手机验证码不正确，请重新填写");
//        WebElement msgRemindElement = DriverChrome.findElement(By.xpath(".//*[@id='conflictTitle']"));
//        String msgRemind = msgRemindElement.getAttribute("innerHTML");
//        System.out.println("对象提示信息 : " + msgRemind);


    }

}
