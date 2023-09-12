package TestCases;

import Pages.P01_HomePage;
import Pages.P02_RegisterPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_RegisterTest extends TC_TestBase {

    P01_HomePage hp ;
    P02_RegisterPage register ;
    SoftAssert sa  = new SoftAssert();

    @Test
    public void register() throws InterruptedException {
        hp = new P01_HomePage(driver);
        hp.sighIn();
        sa.assertTrue(driver.getCurrentUrl().contains("addUser"));
        System.out.println(driver.getCurrentUrl());

         register = new P02_RegisterPage(driver);

         register.registerSteps("xyz","zyx","ahah@gmail.com","123456789");
         Thread.sleep(3000);
         System.out.println(driver.getCurrentUrl());
         sa.assertTrue(driver.getCurrentUrl().contains("contactList"));


        sa.assertAll();
    }







}
