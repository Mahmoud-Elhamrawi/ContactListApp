package TestCases;

import Pages.P01_HomePage;
import Pages.P02_RegisterPage;
import Pages.P03_AddContactPage;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_02ADDContactTest extends TC_TestBase{

    P03_AddContactPage addcontact ;
    P01_HomePage hp ;
    P02_RegisterPage register ;
    SoftAssert sa = new SoftAssert();




    @Test(priority = 1)
    public void register() throws InterruptedException {
        hp = new P01_HomePage(driver);
        hp.sighIn();
        sa.assertTrue(driver.getCurrentUrl().contains("addUser"));
        System.out.println(driver.getCurrentUrl());

        register = new P02_RegisterPage(driver);
        register.registerSteps("ali","tester","ali@gmail858s5ffd.com","123456987");

        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));

    }



    @DataProvider(name = "testDataContact")
    public Object [][] provider( ) throws Exception
    {
        String path = "./src\\test\\java\\DataSource\\userContact.csv" ;
        ExtUtils ext = new CSVUtils(path, true);
        return ext.parseData();
    }




    @Test(dataProvider ="testDataContact" , priority = 2)
    public void addContactUser(String firstName, String lastName,String DOB,String Email,String Phone,String  ADD1 ,String ADD2,String City,String State,String postalCode,String Country) throws InterruptedException {
        addcontact = new P03_AddContactPage(driver);
        addcontact.addContact();
        sa.assertTrue(driver.getCurrentUrl().contains("addContact"));
        System.out.println(driver.getCurrentUrl());

         addcontact.addUserContact(firstName,lastName,DOB,Email,Phone,ADD1,ADD2,City,State,postalCode,Country);
         sa.assertTrue(driver.getCurrentUrl().contains("contactList"));
         System.out.println(driver.getCurrentUrl());


    }
}
