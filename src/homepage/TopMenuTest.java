package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String menu ="Desktops";
    @Before
    //launch browser
    public void setUp(){
        openBrowser();
    }
@Test
     //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
     public void verityShouldNavigateToDesktopsPageSuccessfully(){
     //1.1 Mouse hover on “Desktops” Tab and click
     mouseHoverOn(By.linkText("Desktops"));
     //1.2 call selectMenu method and pass the menu = “Show All Desktops”
     String menu = "Show AllDesktops";
      selectMenu(menu);
      //1.3 Verify the text ‘Desktops’
      verifyElements(By.xpath("//h2[normalize-space()='Desktops']"),"Desktops");
    }
    @Test
    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    mouseHoverOn(By.linkText("Laptops & Notebooks"));
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    selectMenu("Show AllLaptops & Notebooks");
    //2.3 Verify the text ‘Laptops & Notebooks’
    verifyElements(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"),"Laptops & Notebooks");
    }
    @Test
    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
    //3.1 Mouse hover on “Components” Tab and click
    mouseHoverOnAndClick(By.linkText("Components"));
    //3.2 call selectMenu method and pass the menu = “Show All Components”
    selectMenu("Show AllComponents");
    //3.3 Verify the text ‘Components’
    verifyElements(By.xpath("//h2[normalize-space()='Components']"),"Components");
    }
@After
 //closing browser
    public void tearDown(){
        closeBrowser();
 }
}
