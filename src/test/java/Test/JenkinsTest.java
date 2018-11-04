package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class JenkinsTest {

    private WebDriver driver;




    @BeforeEach
    public void setBrowser() {

        if (System.getenv("JENKINS_HOME") != null){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            try{
                driver = new RemoteWebDriver(new URL("http://chrome:4444/wd/hub/"), capabilities);
            }
            catch (MalformedURLException e){
                System.out.println(e.getMessage());
            }
            Properties p = System.getProperties();
            p.list(System.out);
            Map<String, String> envMap = System.getenv();

            Iterator<String> iterator = envMap.keySet().iterator();
            while (iterator.hasNext()) {
                String iteratorKey = iterator.next();
                System.out.println(iteratorKey + " : " + envMap.get(iteratorKey));
            }
        }
        else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
    }




    @Test
    public void testGutu99() {



        driver.get("http://demo.guru99.com/test/guru99home/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = driver.findElement(By.xpath("//div[@id='site-name']"));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        String title = driver.getTitle();

        assertThat(title).contains("Demo Guru99 Page");

    }
    @AfterEach
    public void closeAfterTest() {
        driver.quit();

    }
}
