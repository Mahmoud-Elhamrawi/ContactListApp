package TestCases;

import Helper.HelperScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TC_TestBase {

    public WebDriver driver ;

    @BeforeClass
    @Parameters({"Browser"})
    public  void  openBrowser(@Optional("chrome") String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");


    }


    @AfterClass
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @AfterMethod
    public void screenshotfail(ITestResult result)
    {

        System.out.println("Fail");
        System.out.println("taking screenshot.....");
        HelperScreenShot.capturescreenshot(driver,result.getName());

    }





}
