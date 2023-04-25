package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.*;

public class LaptopsAndNotebooksTest extends Utility {
    @Before
    //launch browser
    public void setUp(){
        openBrowser();
    }
    @Test
    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
    mouseHoverOnAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
    //1.2 Click on “Show All Laptops & Notebooks”
    selectMenu("Show AllLaptops & Notebooks");
    //1.3 Select Sort By "Price (High > Low)"
    List<WebElement> list = driver.findElements(By.xpath("//p[@class='price']"));
    List<String> expectedlistOfPrice= new ArrayList<>();

        for(int i =0; i<list.size();i++){
            String s = list.get(i).getText();
            String[] a = s.split("E");
            String s1 = a[0].substring(1);
            expectedlistOfPrice.add(s1.trim());
        }
        Collections.reverse(expectedlistOfPrice);
        System.out.println(expectedlistOfPrice);
        selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
       //1.4 Verify the Product price will arrange in High to Low order.1.1 Mouse hover on Laptops & Notebooks Tab.and click
        List<WebElement> list1 = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> acctuallistOfPrice = new LinkedList<>();
        for(int i =0; i<list1.size();i++){
            String s = list1.get(i).getText();
            String[] a = s.split("E");
            String s1 = a[0].substring(1);
            acctuallistOfPrice.add(s1.trim());
        }

        System.out.println(acctuallistOfPrice);
        System.out.println("Compare List: "+ expectedlistOfPrice.toString().contentEquals(acctuallistOfPrice.toString()));
    }
    @Test
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void veiryfyThatUserPlaceOrderSuccessfully()throws InterruptedException{
    //2.1 Mouse hover on Laptops & Notebooks Tab and click
    mouseHoverOnAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
    //2.2 Click on “Show All Laptops & Notebooks”
    selectMenu("Show AllLaptops & Notebooks");
    // 2.3 Select Sort By "Price (High > Low)"
    selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
    // 2.4 Select Product “MacBook”
    clickElement(By.xpath("//a[normalize-space()='MacBook']"));
    //2.5 Verify the text “MacBook”
    verifyElements(By.xpath("//h1[normalize-space()='MacBook']"),"MacBook");
    //2.6 Click on ‘Add To Cart’ button
    clickElement(By.xpath("//button[@id='button-cart']"));
    //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    String acctualMessageSuccess = getTextMethod(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    String expectedMessageSuccess ="Success: You have added MacBook to your shopping cart!";
    boolean message =acctualMessageSuccess.contains(expectedMessageSuccess.trim());
    Assert.assertTrue(message);
    // 2.8 Click on link “shopping cart” display into success message
    clickElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']"));
    clickElement(By.xpath("//strong[normalize-space()='View Cart']"));
    //2.9 Verify the text "Shopping Cart"
    verifyElements(By.xpath("//h1[contains(text(),'Shopping Cart')]"),"Shopping Cart  (0.00kg)");
    //2.10 Verify the Product name "MacBook"
    verifyElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");
    //2.11 Change Quantity "2"
    Thread.sleep(1000);
    //driver.findElement(By.xpath("//input[@name='quantity")).sendKeys("2");
    sendValue(By.xpath("//input[@type='text']"),"2");
    //2.12 Click on “Update”Tab
    clickElement(By.xpath("//i[@class='fa fa-refresh']"));
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    String messageShoppingCart= getTextMethod(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    String expectedMessage = "Success: You have modified your shopping cart!";
    boolean messageShopping = acctualMessageSuccess.contains(expectedMessageSuccess.trim());
    Assert.assertTrue(messageShopping);
    //2.14 Verify the Total £737.4
    String total = getTextMethod(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
    verifyElements(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),"$602.00");
    //2.15 Click on “Checkout” button
    clickElement(By.xpath("//a[@class='btn btn-primary']"));
    Thread.sleep(1000);
    //2.16 Verify the text “Checkout”
    verifyElements(By.xpath("//h1[normalize-space()='Checkout']"),"Checkout");
    //2.17 Verify the Text “New Customer”
    verifyElements(By.xpath("//h2[normalize-space()='New Customer']"),"New Customer");
    //2.18 Click on “Guest Checkout” radio button
    clickElement(By.xpath("//label[normalize-space()='Guest Checkout']"));
    //2.19 Click on “Continue” tab
    clickElement(By.xpath("//input[@id='button-account']"));
    //2.20 Fill the mandatory fields
    sendValue(By.xpath("//input[@id='input-payment-firstname']"),"Jass");
    sendValue(By.xpath("//input[@id='input-payment-lastname']"),"Davis");
    sendValue(By.xpath("//input[@id='input-payment-email']"),"jassdavis@gmail.com");
    sendValue(By.xpath("//input[@id='input-payment-telephone']"),"012546345");
    sendValue(By.xpath("//input[@id='input-payment-address-1']"),"4,keek road");
    sendValue(By.xpath("//input[@id='input-payment-city']"),"London");
    sendValue(By.xpath("//input[@id='input-payment-postcode']"),"ha3 4sk");
    selectFromDropDown(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");
    selectFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Cardiff");
    //2.21 Click on “Continue” Buttondriver.findElement()
    clickElement(By.xpath("//div[@class='pull-right']//input[@value='Continue']"));
    //2.22 Add Comments About your order into text area
    sendValue(By.xpath("//textarea[@name='comment']"),"All good");
    //2.23 Check the Terms & Conditions check box
        Thread.sleep(1000);
    clickElement(By.xpath("//input[@name='agree']"));
    //2.24 Click on “Continue” button
    clickElement(By.xpath("//div[@class='panel-collapse collapse in']//input[@value='Continue']"));
    //2.25 Verify the message “Warning: Payment method required!”driver.findElement(By.xpath("//div[@class='alert alert-warning alert-dismissible']"))
    String warning= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
    String expectedWarning ="Warning: Payment method required!";
    boolean messageWarning = warning.contains(expectedWarning.trim());
     System.out.println(warning);
    Assert.assertTrue(messageWarning);
    }
    @After
    //closing browser
    public void tearDown(){closeBrowser();}
}
