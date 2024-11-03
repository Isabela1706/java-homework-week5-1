package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/**
 * EdgeBrowser
 */

public class EdgeBrowser {

    static String baseURL = "https://demowebshop.tricentis.com/";

    public static void main(String[] args) {
        //Launch the Edge Browser
        WebDriver driver = new EdgeDriver();
        driver.get(baseURL);


        //Fullscreen
        driver.manage().window().fullscreen();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
