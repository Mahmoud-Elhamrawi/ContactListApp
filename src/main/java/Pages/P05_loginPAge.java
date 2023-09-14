package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_loginPAge extends P_PageBase{
    public P05_loginPAge(WebDriver driver) {
        super(driver);
    }

    private By emailLogin = By.id("email");
    private By passLogin = By.id("password");
    private By submitBtn = By.id("submit");


    public void loginSteps(String email , String pass)
    {
        sendData(driver.findElement(emailLogin),email);
        sendData(driver.findElement(passLogin),pass);
        clickBtn(driver.findElement(submitBtn));
    }



}
