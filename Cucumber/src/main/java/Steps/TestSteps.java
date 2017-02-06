package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.而且;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by thinkpad on 2017/1/24.
 */
public class TestSteps {
    WebDriver driver;
    @假如("^我用正确的帐号\"test1\"登录系统$")
    public void loginTest() {
        System.out.println("用账户登录");
    }

    @那么("^我能登录成功$")
    public void test2() {
        System.out.println("登录成功");
    }

    @当("^我用帐号\"(.*?)\"$")         //正则表达式
    public void testName(String username) {
        System.out.println("登录帐号" + username);
    }


    @而且("^我用\"([^\"]*)\"登录$")       //正则表达式
    public void testPassword(String pwd) throws Throwable {
        System.out.println("登录帐号" + pwd);
    }

    @当("^搜索框输入\"([^\"]*)\"搜索$")
    public void searchTest(String arg0){
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(arg0);
        driver.findElement(By.id("su")).click();
    }
    @那么("^打开搜索页面$")
    public void assertTitle() throws InterruptedException {
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();

    }


    @当("^我打开\"([^\"]*)\"页面$")
    public void openBroswer(String url){
        System.setProperty("webdriver.firefox.bin","D:\\Software\\FireFox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @而且("^输入帐号\"([^\"]*)\"，密码\"([^\"]*)\"$")
    public void inputNamePwd(String userName, String pwd){
        WebElement LoginFrame   = driver.findElement(By.id("x-URS-iframe"));
        driver.switchTo().frame(LoginFrame);
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(pwd);
    }
    @当("^我点击登录按钮$")
    public void clickLoginBtn(){
        driver.findElement(By.xpath(".//*[@id='dologin']")).click();
    }

    @那么("^我登录成功$")
    public void 我登录成功() throws InterruptedException {
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("登录成功");
        driver.quit();

    }
}
