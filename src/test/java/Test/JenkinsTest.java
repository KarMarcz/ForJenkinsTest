package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class JenkinsTest {

    private WebDriver driver;




//    @BeforeEach
//    public void setBrowser() {
//
//    }




    @Test
    public void testGutu99() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://chrome:4444/wd/hub/"), capabilities);
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = driver.findElement(By.xpath("//div[@id='site-name']"));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        String title = driver.getTitle();

        assertThat(title).contains("Demo Guru99 Page");
        driver.quit();
    }
    @AfterEach
    public void closeAfterTest() {

    }
}
