package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_RegisterPage extends P_PageBase{
    public P02_RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By fName = By.id("firstName");
    private By lName = By.id("lastName");
    private By email = By.id("email");
    private By pass = By.id("password");
    private By submitBtn = By.id("submit");

    public  void  registerSteps(String FN , String LN ,String emi ,String password)
    {
        sendData(driver.findElement(fName),FN);
        sendData(driver.findElement(lName),LN);
        sendData(driver.findElement(email),emi);
        sendData(driver.findElement(pass),password);
        clickBtn(driver.findElement(submitBtn));
    }

}
