package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DesktopsTest extends Utility {
    @Before
    //launch browser
    public void setUp(){
        openBrowser();
    }
    @Test
    //  Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder(){
    //1.1 Mouse hover on Desktops Tab.and click
    mouseHoverOn(By.linkText("Desktops"));
    //1.2 Click on “Show All Desktops”
    String menu = "Show AllDesktops";
    selectMenu(menu);
     //this list will store the default display of the product
    List<WebElement> list = driver.findElements(By.xpath("//div[@class='caption']//h4"));
    List<String> acctuallistOfTitle = new LinkedList<>();
       for(int i =0; i<list.size();i++){
            String s = list.get(i).getText();
            acctuallistOfTitle.add(s);  }
        //reverse the default display
        Collections.reverse(acctuallistOfTitle);
        //1.3 Select Sort By position "Name: Z to A"
        selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
        // 1.4 Verify the Product will arrange in Descending order
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> expectedListOfTitle = new LinkedList<>();
        for(int i =0; i<list1.size();i++){
            String s = list1.get(i).getText();
            expectedListOfTitle.add(s);
        }
        Assert.assertEquals("not match",expectedListOfTitle.toString(),acctuallistOfTitle.toString());
   }
    @Test
      //  Test name verifyProductAddedToShoppingCartSuccessFully()
      public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException {
      //2.1 Mouse hover on Desktops Tab. and click
      mouseHoverOn(By.linkText("Desktops"));
      //2.2 Click on “Show All Desktops”
      String menu = "Show AllDesktops";
      selectMenu(menu);
      //2.3 Select Sort By position "Name: A to Z"
      selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
      //2.4 Select product “HP LP3065”
      clickElement(By.linkText("HP LP3065"));
      // 2.5 Verify the Text "HP LP3065"
      verifyElements(By.xpath("//h1[normalize-space()='HP LP3065']"),"HP LP3065");
      //2.6 Select Delivery Date "2022-11-30"
      String monthAndYear ="November 2022";
      String day= "30";
      String date;
      clickElement(By.xpath("//i[@class='fa fa-calendar']"));
      Thread.sleep(2000);
         while(true) {
             date = getTextMethod(By.xpath("//th[@class='picker-switch']"));
            if(date.equals(monthAndYear)){
                break;
            }else {
                clickElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }
       clickElement(By.xpath("//td[contains(text(),'30')]"));
       //2.7.Enter Qty "1” using Select class.
       clearBox(By.xpath("//input[@id='input-quantity']"));
       sendValue(By.xpath("//input[@id='input-quantity']"),"1");
       //2.8 Click on “Add to Cart” button
       clickElement(By.xpath("//button[@id='button-cart']"));
       //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
       String acctualMessage = getTextMethod(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
       String expectedMessage ="Success: You have added HP LP3065 to your shopping cart!";
       boolean message = acctualMessage.contains(acctualMessage.trim());
       Assert.assertTrue(message);
       //2.10 Click on link “shopping cart” display into success messagedriver.findElement(By.xpath("//span[normalize-space()='Shopping Cart']"))
       clickElement(By.xpath("//div[@id='cart']"));
        clickElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
       //2.11 Verify the text "Shopping Cart"
        Thread.sleep(1000);
        String cart2 =getTextMethod(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        String expectedcart ="Shopping Cart  (1.00kg)";
        Assert.assertEquals("not match",expectedcart,cart2);
        System.out.println(cart2);
       //2.12 Verify the Product name "HP LP3065"
       verifyElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
       //2.13 Verify the Delivery Date "2022-11-30"
       String expectedDate ="2022-11-30";
       String accturalDate1 =getTextMethod(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
       String[] a = accturalDate1.split(":");
       Assert.assertEquals("Not Matching",expectedDate,a[1]);
       //2.14 Verify the Model "Product21"
       verifyElements(By.xpath("//td[normalize-space()='Product 21']"),"Product 21");
       //2.15 Verify the Todat "£74.73"
       verifyElements(By.xpath("(//td[contains(text(),'$122.00')])[4]"),"$122.00");
    }
    @After
    //closing browser
    public void tearDown(){
        closeBrowser();
    }
}
