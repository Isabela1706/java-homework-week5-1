package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Testing all the browser
 */

public class MultiBrowser {

    static String browser = "Chrome";
    static String baseURL = "https://demowebshop.tricentis.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("FireFox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
//Open URL.
        driver.get(baseURL);

        //Fullscreen
        driver.manage().window().fullscreen();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        //Print the title of the page.
        String title = driver.getTitle();
        System.out.println(title);

        //Print the current URL.
        String currentURL = driver.getCurrentUrl();
        System.out.println("This is the current Url " + currentURL);

        //Print the page source.
        String source = driver.getPageSource();
        System.out.println("This is the page source " + source);


        //Navigate to Url for log in page
        String loginUrl = "https://demowebshop.tricentis.com/login";
        driver.navigate().to(loginUrl);

        //Print the current URL.
        System.out.println("This is now our current url " + loginUrl);

        //Navigate back to the home page.
        driver.navigate().back();
        System.out.println("We are navigated back to the home page " + currentURL);

        //Navigate to the login page.
        driver.navigate().to(loginUrl);
        System.out.println("We are now navigated to login page " +loginUrl);

        //Print the current URL.
        System.out.println("This is now our current url " + loginUrl);

        //Refresh the page.
        driver.navigate().refresh();

        //Enter the email in the email field.
        WebElement searchBox = driver.findElement(By.id("Email"));
        searchBox.sendKeys("abc123@gmail.com");

        //Enter the password in the password field.
        WebElement passwordBox = driver.findElement(By.className("password"));
        passwordBox.sendKeys("agbcjs123");

        //Click on the Login Button.
        WebElement loginLink = driver.findElement(By.className("login-button"));
        loginLink.click();










        //Close the browser after the work
        driver.close();

    }
}
