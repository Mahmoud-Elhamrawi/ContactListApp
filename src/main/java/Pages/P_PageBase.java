package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P_PageBase {
public WebDriver driver ;
    public P_PageBase(WebDriver driver)
    {
        this.driver = driver ;
    }


   public  void  sendData(WebElement ele ,  String txt)
   {
       WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOf(ele));
       ele.sendKeys(txt);

   }

   public  void clickBtn(WebElement ele)
   {
       WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
       wait.until(ExpectedConditions.elementToBeClickable(ele));
       ele.click();
   }



    public  void clearInput(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.clear();
    }




}
