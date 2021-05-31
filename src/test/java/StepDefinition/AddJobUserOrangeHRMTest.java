package StepDefinition;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AddJobUserOrangeHRMTest {
    WebDriver driver;

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        HashMap<String, Object> map = new HashMap<>();
        map.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", map);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

        WebElement elementEmail = driver.findElement(By.xpath("//*[@id = 'txtUsername']"));
        WebElement elementPass = driver.findElement(By.xpath("//*[@id = 'txtPassword']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//*[@id = 'btnLogin']"));

        elementEmail.sendKeys("Admin");
        elementPass.sendKeys("admin123");
        buttonLogin.click();
    }

    @Test
    public void shouldAddUserSuccess () {
        
    }
}
