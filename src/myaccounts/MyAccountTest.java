package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountTest extends Utility {
    @Before
    //launch browser
    public void setUp() {
        openBrowser();
    }
    //Create the class MyAccountsTest
    // 1.1 create method with name "selectMyAccountOptions" it has one parameter name
    // "option" of type string1.2 This method should click on the options whatever name is passed as parameter.
    // (Hint: Handle List of Element and Select options)
    public void selectMyAccountOptions(String option) {
        driver.findElement(By.linkText(option)).click();
    }
    @Test
    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Clickr on My Account Link.
        mouseHoverOnAndClick(By.xpath("//span[normalize-space()='My Account']"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        verifyElements(By.xpath("//h1[normalize-space()='Register Account']"), "Register Account");
    }
    @Test
    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
       // 2.1 Clickr on My Account Link.
        mouseHoverOnAndClick(By.xpath("//span[normalize-space()='My Account']"));
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        // 2.3 Verify the text “Returning Customer”.
        verifyElements(By.xpath("//h2[normalize-space()='Returning Customer']"),"Returning Customer");
    }
    @Test
    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Clickr on My Account Link.
        mouseHoverOnAndClick(By.xpath("//span[normalize-space()='My Account']"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendValue(By.xpath("//input[@id='input-firstname']"),"Anns");
        // 3.4 Enter Last Name
        sendValue(By.xpath("//input[@id='input-lastname']"),"Davis");
        // 3.5 Enter Email
        sendValue(By.xpath("//input[@id='input-email']"),"annsdavis@gmail.com");
        // 3.6 Enter Telephone
        sendValue(By.xpath("//input[@id='input-telephone']"),"12355611");
        // 3.7 Enter Password
        sendValue(By.xpath("//input[@id='input-password']"),"ann@123");
        // 3.8 Enter Password Confirm
        sendValue(By.xpath("//input[@id='input-confirm']"),"ann@123");
        // 3.9 Select Subscribe Yes radio button
        clickElement(By.xpath("//label[normalize-space()='Yes']"));
        // 3.10 Click on Privacy Policy check box
        clickElement(By.xpath("//input[@type='checkbox']"));
        // 3.11 Click on Continue button
        clickElement(By.xpath("//input[@class='btn btn-primary']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyElements(By.xpath("//div[@id='content']/h1"),"Your Account Has Been Created!");
        // 3.13 Click on Continue button
        clickElement(By.xpath("//a[normalize-space()='Continue']"));
        // 3.14 Clickr on My Account Link.
        clickElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        // 3.16 Verify the text “Account Logout”
        verifyElements(By.xpath("//h1[normalize-space()='Account Logout']"),"Account Logout");
          // 3.17 Click on Continue button
        clickElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @Test
    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        // 4.1 Clickr on My Account Link.
        mouseHoverOnAndClick(By.xpath("//span[normalize-space()='My Account']"));
        // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendValue(By.xpath("//input[@id='input-email']"),"annsdavis@gmail.com");
        // 4.5 Enter Password
        sendValue(By.xpath("//input[@id='input-password']"),"ann@123");
        // 4.6 Click on Login button
        clickElement(By.xpath("//input[@value='Login']"));
        // 4.7 Verify text “My Account”
        verifyElements(By.xpath("//h2[normalize-space()='My Account']"),"My Account");
        // 4.8 Clickr on My Account Link.
        clickElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        // 4.10 Verify the text “Account Logout”
        verifyElements(By.xpath("//h1[normalize-space()='Account Logout']"),"Account Logout");
        // 4.11 Click on Continue button
        clickElement(By.xpath("//a[normalize-space()='Continue']"));
    }
    @After
    //closing brower
    public void tearDown(){
        closeBrowser();
    }
}