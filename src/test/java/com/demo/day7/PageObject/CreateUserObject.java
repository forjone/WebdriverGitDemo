package com.demo.day7.PageObject;


import org.openqa.selenium.By;

/**
 * Created by thinkpad on 2017/1/20.
 */
public class CreateUserObject {
    public static By loginFrame     =By.id("x-URS-iframe");   // 登录界面Iframe
    public static By registerButton =By.id("changepage");     //去注册按钮
    public static By englishEmail   =By.xpath(".//*[@id='tabsUl']/li[1]/a");  // 注册英文邮箱
    public static By emailAddress   =By.xpath(".//*[@id='nameIpt']");  // 邮箱地址填写框
    public static By passwordFirst  =By.xpath(".//*[@id='mainPwdIpt']");  // 一次密码输入框
    public static By passwordSecond =By.xpath(".//*[@id='mainCfmPwdIpt']");  // 二次密码输入框
    public static By phoneNo        =By.xpath(".//*[@id='mainMobileIpt']");  // 手机号码输入框
    public static By photoCheck     =By.xpath(".//*[@id='vcodeIpt']");  // 图片验证码输入框
    public static By smsCheck       =By.xpath(".//*[@id='mainAcodeIpt']");  // 短信验证码输入框
    public static By submitButton   =By.xpath(".//*[@id='mainRegA']");  // 提交按钮
    public static By checkElement =By.xpath(".//*[@id='m_mainAcode']/span");  //  校验元素



}
