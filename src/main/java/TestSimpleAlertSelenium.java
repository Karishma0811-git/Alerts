import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSimpleAlertSelenium {
    private WebDriver d;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        d= new ChromeDriver();
    }

    @Test
    public void testSimpleAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        d.findElement(By.id("alertButton")).click();
        Alert alert = d.switchTo().alert();
        alert.accept();
    }

    @Test
    public void enterNameAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        WebElement findPath = d.findElement(By.id("promtButton"));
        ((JavascriptExecutor) d).executeScript("arguments[0].click()", findPath);
        Alert alert = d.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("kim");
        alert.accept();
    }
    @Test
    public void conformBoxAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        WebElement element= d.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) d).executeScript("arguments[0].click()", element);
        Alert alert = d.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

    }

    @Test
    public void testFileUpload(){
        d.get("https://html.com/input-type-file/");
        d.findElement(By.name("fileupload")).sendKeys("C:\\Users\\arora\\OneDrive\\Desktop\\Karishma.txt");
        d.findElement(By.xpath("//input[@value=\"submit\"]")).click();
    }

    @Test
    public void loginWithoutNoUserNameAndPassword(){
        d.get("https://mail.rediff.com/cgi-bin/login.cgi");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[@name=\"proceed\"]")).click();
        Alert alert = d.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Please enter a valid user name",alert.getText());
        alert.accept();
    }
    @Test
    public void loginWithUserNameAndNoPassword(){
        d.get("https://mail.rediff.com/cgi-bin/login.cgi");
        d.manage().window().maximize();
        d.findElement(By.xpath("//input[@id=\"login1\"]")).sendKeys("UserName");
        d.findElement(By.xpath("//input[@name=\"proceed\"]")).click();
        Alert alert = d.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Please enter your password",alert.getText());
    }

    @Test
    public void testBasicAuthenticationWithCredential(){
        d.get("https://the-internet.herokuapp.com/login");
        d.manage().window().maximize();
        d.findElement(By.name("username")).sendKeys("tomsmith");
        d.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        d.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.",d.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]")).getText());

    }


    @Test
    public void facebookAcceptCookies(){
        d.get("http://www.facebook.com");
        d.manage().window().maximize();
        d.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();

    }

}
