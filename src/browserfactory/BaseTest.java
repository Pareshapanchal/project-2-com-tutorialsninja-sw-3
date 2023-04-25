package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {public static WebDriver driver;//static Webdriver variable declared
//launch browser
    public void openBrowser(){
        String baseUrl ="http://tutorialsninja.com/demo/index.php";
        String browser ="Chrome";

        driver = new ChromeDriver();
        //open Url
        driver.get(baseUrl);
        //maximise the window
        driver.manage().window().maximize();
        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){
        //closing brower
        driver.close();
    }
}
