package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_logOutPage extends P_PageBase{
    public P04_logOutPage(WebDriver driver) {
        super(driver);
    }


    private By logOutBtn = By.id("logout");




    public void logOut()
    {
        clickBtn(driver.findElement(logOutBtn));
    }






}
