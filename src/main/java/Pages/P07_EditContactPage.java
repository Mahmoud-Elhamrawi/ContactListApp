package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P07_EditContactPage extends P_PageBase{
    public P07_EditContactPage(WebDriver driver) {
        super(driver);
    }


    private By editBtn = By.id("edit-contact");
    private By ln = By.id("lastName");
    private By count = By.id("country");

     private By submitBtn = By.id("submit");

     private By returnBtn = By.id("return");


    public void clickOnEditBtn()
    {
        clickBtn(driver.findElement(editBtn));
    }

    public void clearInputs()
    {
        clearInput(driver.findElement(ln));
        clearInput(driver.findElement(count));
    }
    public void edit(String lname , String country)
    {
        sendData(driver.findElement(ln),lname);
        sendData(driver.findElement(count),country);
        clickBtn(driver.findElement(submitBtn));
    }


    public WebElement assertCountry()
    {
        return driver.findElement(count);
    }

    public WebElement asserLanme()
    {
        return driver.findElement(ln);
    }

    public  void  returnToList()
    {
         clickBtn(driver.findElement(returnBtn));
    }

}
