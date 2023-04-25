package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
//1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
//1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    public void mouseHoverOn(By by){// method will perform mouse hover action on elements
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    public void mouseHoverOnAndClick(By by){ // method will perform mouse hover and click on elements actions
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void verifyElements(By by,String expected){// this method will verify two value expected and acctual
        String acctual = driver.findElement(by).getText();
        Assert.assertEquals("not match",expected,acctual);
    }
    public void selectFromDropDown(By by, String text){// this method will select text from dropdown list
        WebElement sortBy = driver.findElement(by);
        Select select = new Select(sortBy);
        select.selectByVisibleText(text);
    }
    public void storeListElement(By by){// store elements in the arraylist
        List<WebElement> productName = driver.findElements(by);
        for ( WebElement element : productName){
            System.out.println(element.getText());
        }
    }
    public void sendValue(By by,String text){
        driver.findElement(by).sendKeys(text);
    }// this method will send values to the field
    public void clearBox(By by){// this method will delete the value from the field
        WebElement element = driver.findElement(by);
        element.clear();
    }
    public String getTextMethod(By by){// this method will return value from the field
        return driver.findElement(by).getText();

    }
    public void clickElement(By by){// this method will click on elements
        driver.findElement(by).click();
    }
}
