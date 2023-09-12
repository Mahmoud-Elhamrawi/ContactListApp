package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage extends P_PageBase {
    public P01_HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver ;
      }



    private  By registBtn = By.id("signup");





    public  void sighIn()
    {
        clickBtn(driver.findElement(registBtn));
    }







}
