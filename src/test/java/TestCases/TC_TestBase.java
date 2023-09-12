package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TC_TestBase {

    public WebDriver driver ;

    @BeforeClass
    public  void  openBrowser()
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");


    }


    @AfterClass
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




}
