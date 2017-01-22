package com.demo.Day5Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.security.util.Length;

import java.util.concurrent.TimeUnit;

/**
 * Created by GGF on 2016/12/29.
 * 1.完成163邮箱的注册
 * 2.完成正确账号的登录
 * 3.完成错误账号的登录
 * 4.完成带附件的发送邮件
 */
public class Day5Test  extends  BaseCase{
    @BeforeMethod
    public  void beforeMethod(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    //进入注册页面，进行注册操作流程
    public void LoginTest() throws InterruptedException {
        //进入注册页面
        goRegister();
        //进行注册操作
        gongYong();
    }
    @Test
    //邮箱为空
    public void mailAssertTest1(){
        goRegister();
        mailAssertIsNull(null);
    }
    @Test
    public void mailAssertTest2() throws InterruptedException {
        goRegister();
        mailUrlAserrt("44444444");
    }
    //验证邮箱为空是否有提示
    public void mailAssertIsNull(String mailurl){
        driver.findElement(By.id("nameIpt")).sendKeys(mailurl);
        String mailmessage=driver.findElement(By.id(".//*[@id='m_name']/span")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mailmessage,"请填写邮件地址");
        System.out.print("验证邮箱不能为空--pass");

    }
    //验证邮箱无英文字母开头是否有提示
    public void mailUrlAserrt(String mailurl) throws InterruptedException {
        driver.findElement(By.id("nameIpt")).sendKeys(mailurl);
        WebElement mailInfo = driver.findElement(By.xpath(".//*[@id='conflictDiv']/div[2]/strong"));
        WebElement textElement = driver.findElement(By.xpath(".//*[@id='tabsUl']/li[1]/a"));
        driver.findElement(By.id("mainRegA")).click();
        Thread.sleep(2000);
        String msgRemind = mailInfo.getAttribute("innerHTML");
        System.out.println("提示：" +msgRemind );
        Assert.assertEquals(msgRemind,"邮件地址必需以英文字母开头");
    }
    //验证邮箱长度无6~18个字符是否有提示
    public  void mailUrlLengthAssert(String mailurl){
        driver.findElement(By.id("nameIpt")).sendKeys(mailurl);
        String mailmessage=driver.findElement(By.id("conflictTitle")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mailmessage,"长度应为6~18个字符");
    }
    //验证已被注册邮箱是否有提示
    public  void mailRegisterAssert(String mailurl){
        driver.findElement(By.id("nameIpt")).sendKeys(mailurl);
        String mailmessage=driver.findElement(By.id("conflictTitle")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mailmessage,"该邮件地址已被注册");
    }
    //验证密码长度无6~16个字符是否有提示
    public  void mainPwdAssert(String mainpwd){
        driver.findElement(By.id("mainPwdIpt")).sendKeys(mainpwd);
        String mainPwd=driver.findElement(By.id("conflictTitle")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mainPwd,"密码长度应为6~16个字符");
    }
    //验证密码未填写是否有提示
    public  void mainCfmPwdIsNullAssert(String mainpwd){
        driver.findElement(By.id("mainPwdIpt")).sendKeys(mainpwd);
        String mainPwd=driver.findElement(By.id("conflictTitle")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mainPwd,"请填写密码");
    }
    //验证二次密码长度无6~16个字符是否有提示
    public  void mainCfmPwdAssert(String maincfmpwd){
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys(maincfmpwd);
        String mainCfmPwd= driver.findElement(By.xpath(".//*[@id='m_mainCfmPwd']/span")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mainCfmPwd,"密码长度应为6~16个字符");
    }
    //验证二次密码未填写是否有提示
    public  void mainPwdIsNullAssert(String maincfmpwd){
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys(maincfmpwd);
        String mainCfmPwd= driver.findElement(By.xpath(".//*[@id='m_mainCfmPwd']/span")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mainCfmPwd,"请填写密码");
    }
    //验证二次密码与密码不相等是否有提示
    public  void pwdIsEqualAssert(String maincfmpwd,String mainpwd){
        driver.findElement(By.id("mainPwdIpt")).sendKeys(mainpwd);
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys(maincfmpwd);
        //取哪个元素需要更改
        String mainPwd= driver.findElement(By.xpath(".//*[@id='m_mainCfmPwd']/span")).getText();
        driver.findElement(By.id("mainRegA")).click();
        Assert.assertEquals(mainPwd,"");
    }
    //验证手机号填写错误是否有提示
    public  void mobilePhoneAssert(String mobilephone){
        driver.findElement(By.id("mainMobileIpt")).sendKeys(mobilephone);
        String mobilePhone= driver.findElement(By.xpath(".//*[@id='m_mainMobile']/span")).getText();
        Assert.assertEquals(mobilephone,"请填写密码");
    }
    //进入注册页面
    public void goRegister(){
        String handle=driver.getWindowHandle();
        WebElement loginframe=driver.findElement(By.id("x-URS-iframe"));
        driver.switchTo().frame(loginframe);
        driver.findElement(By.id("changepage")).click();
        for (String hadles:driver.getWindowHandles()){
            if(hadles.equals(handle)){
                continue;
            }driver.switchTo().window(hadles);
        }
        driver.findElement(By.xpath(".//*[@id='tabsUl']/li[1]/a")).click();
    }
    //进行注册操作
    public void gongYong(){
        //邮件地址
        driver.findElement(By.id("nameIpt")).sendKeys("chaojimali");
        //密码
        driver.findElement(By.id("mainPwdIpt")).sendKeys("a111111");
        //确认密码
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("a111111");
        //手机号码
        driver.findElement(By.id("mainMobileIpt")).sendKeys("13774692594");
        //验证码
        driver.findElement(By.id("vcodeIpt")).sendKeys("1111");
        //短信验证码
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("1111");
        //注册按钮
        driver.findElement(By.id("mainRegA")).click();

    }
}
