package TestCases;

import Pages.P01_HomePage;
import Pages.P02_RegisterPage;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_RegisterTest extends TC_TestBase {

    P01_HomePage hp ;
    P02_RegisterPage register ;
    SoftAssert sa  = new SoftAssert();

        @DataProvider(name = "testData")
        public Object [][] provider( ) throws Exception
        {

            String path = "./src\\test\\java\\DataSource\\data.csv" ;
            ExtUtils ext = new CSVUtils(path, true);
            return ext.parseData();
        }






    @Test(dataProvider ="testData")
    public void register(String firstName , String lastName, String Email, String Password) throws InterruptedException {
        hp = new P01_HomePage(driver);
        hp.sighIn();
        sa.assertTrue(driver.getCurrentUrl().contains("addUser"));
        System.out.println(driver.getCurrentUrl());

         register = new P02_RegisterPage(driver);

        register.registerSteps(firstName ,lastName ,Email,Password);

         Thread.sleep(3000);
         System.out.println(driver.getCurrentUrl());
         sa.assertTrue(driver.getCurrentUrl().contains("contactList"));

         register.logout();

        sa.assertAll();
    }







}
