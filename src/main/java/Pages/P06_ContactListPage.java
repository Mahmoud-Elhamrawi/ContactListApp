package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P06_ContactListPage extends P_PageBase{


    public P06_ContactListPage(WebDriver driver)
    {
        super(driver);
        this.driver= driver ;
    }

    private By td2 = By.cssSelector("tr[class=\"contactTableBodyRow\"] td:nth-child(2)");
    private By countryAssert = By.cssSelector("span[id=\"country\"]");


    public void contactDetails()
    {
        clickBtn(driver.findElement(td2));

    }

    public WebElement assetEleCountry()
    {
        return driver.findElement(countryAssert);

    }



}
