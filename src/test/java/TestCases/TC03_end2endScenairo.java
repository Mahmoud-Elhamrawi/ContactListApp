package TestCases;

import Pages.*;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC03_end2endScenairo extends TC_TestBase {
    //signUp page
    P01_HomePage hp;
    P02_RegisterPage register;
    SoftAssert sa = new SoftAssert();

    //logout page
    P04_logOutPage logout;

    //loogin page
    P05_loginPAge login;

    //addNewContact page
    P03_AddContactPage addContact;

    //conatctDeatails page
    P06_ContactListPage contactDetails;

    //editContact page
    P07_EditContactPage editContact;
    //delete page
    P08_DeletePage delete;

    @Test(priority = 1)
    public void signUp() throws InterruptedException {
        hp = new P01_HomePage(driver);
        hp.sighIn();
        sa.assertTrue(driver.getCurrentUrl().contains("addUser"));
        System.out.println(driver.getCurrentUrl());

        register = new P02_RegisterPage(driver);

        register.registerSteps("weal", "ali", "weal21@gmail.com", "123456789");

        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));


        sa.assertAll();
    }

    @Test(dependsOnMethods = {"signUp"}, priority = 2)
    public void logOut() {
        logout = new P04_logOutPage(driver);
        logout.logOut();

        sa.assertTrue(driver.getCurrentUrl().contains("contact-list.herokuapp.com"));
        System.out.println(driver.getCurrentUrl());
        sa.assertAll();
    }


    @Test(priority = 3)
    public void login() throws InterruptedException {
        login = new P05_loginPAge(driver);
        login.loginSteps("weal21@gmail.com", "123456789");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));
        sa.assertAll();
    }


    @Test(priority = 4, dependsOnMethods = {"login"})
    public void addNewContact() throws InterruptedException {
        addContact = new P03_AddContactPage(driver);
        addContact.addContact();
        Thread.sleep(1000);
        addContact.addUserContact("ali", "zain", "1991-10-05", "test@test.com", "01278385814", "cairo", "alexandria", "cairo", "6Octoper", "123456", "october");
        Thread.sleep(1000);
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));
        System.out.println(driver.getCurrentUrl());
        sa.assertAll();
    }


    @Test(priority = 5)
    public void viewContactDetails() throws InterruptedException {
        contactDetails = new P06_ContactListPage(driver);
        contactDetails.contactDetails();

        sa.assertTrue(driver.getCurrentUrl().contains("contactDetails"));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        sa.assertEquals("october", contactDetails.assetEleCountry().getText());

        sa.assertAll();
    }

    @Test(priority = 6)
    public void editContact() throws InterruptedException {
        editContact = new P07_EditContactPage(driver);
        editContact.clickOnEditBtn();

        sa.assertTrue(driver.getCurrentUrl().contains("editContact"));
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(1000);
        editContact.clearInputs();
        Thread.sleep(1000);
        editContact.edit("tester", "miser");

        Thread.sleep(2000);
        sa.assertEquals("miser", editContact.assertCountry().getText());
        sa.assertEquals("tester", editContact.asserLanme().getText());


        editContact.returnToList();
        Thread.sleep(1000);
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));
        sa.assertAll();
    }


    @Test(priority = 7, dependsOnMethods = {"editContact"})
    public void addNewContactOther() throws InterruptedException {
        addContact = new P03_AddContactPage(driver);
        addContact.addContact();
        Thread.sleep(2000);
        addContact.addUserContact("momen", "zain", "1991-10-05", "momen@test.com", "01278385814", "cairo", "alexandria", "cairo", "6Octoper", "123456", "ma7tamiser");
        Thread.sleep(1000);
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));
        System.out.println(driver.getCurrentUrl());
        sa.assertAll();
    }

    @Test(priority = 8, dependsOnMethods = {"addNewContactOther"})
    public void viewContactDetailsOther() throws InterruptedException {
        contactDetails = new P06_ContactListPage(driver);
        contactDetails.contactDetails();
        Thread.sleep(1000);
        sa.assertTrue(driver.getCurrentUrl().contains("contactDetails"));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        sa.assertEquals("miser", contactDetails.assetEleCountry().getText());

        sa.assertAll();
    }


    @Test(priority = 9)
    public void delete() throws InterruptedException {
        delete = new P08_DeletePage(driver);
        delete.delete();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        Thread.sleep(2000);
        sa.assertTrue(driver.getCurrentUrl().contains("contactList"));

    }


    @Test(priority = 10)
    public void logOutOther() throws InterruptedException {
        logout = new P04_logOutPage(driver);
        logout.logOut();
        Thread.sleep(3000);
        sa.assertTrue(driver.getCurrentUrl().contains("contact-list.herokuapp.com"));
        System.out.println(driver.getCurrentUrl());
        sa.assertAll();
    }


}
