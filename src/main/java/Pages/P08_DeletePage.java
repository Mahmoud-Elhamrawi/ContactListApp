package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_DeletePage extends P_PageBase{
    public P08_DeletePage(WebDriver driver) {
        super(driver);
    }


     private By deleteBtn = By.id("delete");



    public void delete()
    {
        clickBtn(driver.findElement(deleteBtn));
    }




}
