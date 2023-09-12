package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_AddContactPage extends P_PageBase{
    public P03_AddContactPage(WebDriver driver) {
        super(driver);
    }
    private By addContactBtn = By.id("add-contact");

    private By fName = By.id("firstName");
    private By lName = By.id("lastName");
    private By DOB = By.id("birthdate");
    private By email = By.id("email");
    private By phone = By.id("phone");
    private By street1 = By.id("street1");
    private By street2 = By.id("street2");
    private By city = By.id("city");
    private By state = By.id("stateProvince");
    private By postalCode = By.id("postalCode");
    private By country = By.id("country");
    private By submitAdd = By.id("submit");






    public  void addContact()
    {
       clickBtn(driver.findElement(addContactBtn));
    }
    public void addUserContact(String fN,String lN,String brith,String em,String phon ,String st1,String st2,String cit,String stat,String postal,String count)
    {
        sendData(driver.findElement(fName),fN);
        sendData(driver.findElement(lName),lN);
        sendData(driver.findElement(DOB),brith);
        sendData(driver.findElement(email),em);
        sendData(driver.findElement(phone),phon);
        sendData(driver.findElement(street1),st1);
        sendData(driver.findElement(street2),st2);
        sendData(driver.findElement(city),cit);
        sendData(driver.findElement(state),stat);
        sendData(driver.findElement(postalCode),postal);
        sendData(driver.findElement(country),count);

        clickBtn(driver.findElement(submitAdd));

    }





}
