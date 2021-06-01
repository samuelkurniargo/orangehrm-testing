package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class AddJobTitleOrangeHRMTest {
    WebDriver driver;
    private String urlJobAdmin= "https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList";
    File file = new File("call.png");
    String titleID = UUID.randomUUID().toString();
    private File bigSizeFile = new File("all.rar");

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        HashMap<String, Object> map = new HashMap<>();
        map.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", map);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        WebElement elementEmail = driver.findElement(By.xpath("//*[@id = 'txtUsername']"));
        WebElement elementPass = driver.findElement(By.xpath("//*[@id = 'txtPassword']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//*[@id = 'btnLogin']"));

        elementEmail.sendKeys("Admin");
        elementPass.sendKeys("admin123");
        buttonLogin.click();
    }

    @Test
    public void shouldAddJobTitleWithTitleEmpty() {
        WebElement elementBtnAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementBtnAdmin.click();
        WebElement elementBtnJob = driver.findElement(By.id("menu_admin_Job"));
        elementBtnJob.click();
        WebElement elementBtnJobTitle = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        elementBtnJobTitle.click();
        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement textFieldJobTitle = driver.findElement(By.id("jobTitle_jobTitle"));
        textFieldJobTitle.sendKeys("");
        WebElement textAreaJobDescription = driver.findElement(By.id("jobTitle_jobDescription"));
        textAreaJobDescription.sendKeys("This is Description of Job");
        WebElement fileChooserJobTitle = driver.findElement(By.id("jobTitle_jobSpec"));
        fileChooserJobTitle.sendKeys(file.getAbsolutePath());
        WebElement textAreaJobNote = driver.findElement(By.id("jobTitle_note"));
        textAreaJobNote.sendKeys("This is Note of Job");
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        btnSave.click();
//        Assert.assertEquals("Already exists", driver.findElement(By.xpath("//span[text()='Already exists']")).getText());
    }

    @Test
    public void shouldAddJobTitleWithTitleAlreadyExist() {
        WebElement elementBtnAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementBtnAdmin.click();
        WebElement elementBtnJob = driver.findElement(By.id("menu_admin_Job"));
        elementBtnJob.click();
        WebElement elementBtnJobTitle = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        elementBtnJobTitle.click();
        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement textFieldJobTitle = driver.findElement(By.id("jobTitle_jobTitle"));
        textFieldJobTitle.sendKeys(titleID);
        WebElement textAreaJobDescription = driver.findElement(By.id("jobTitle_jobDescription"));
        textAreaJobDescription.sendKeys("This is Description of Job");
        WebElement fileChooserJobTitle = driver.findElement(By.id("jobTitle_jobSpec"));
        fileChooserJobTitle.sendKeys(file.getAbsolutePath());
        WebElement textAreaJobNote = driver.findElement(By.id("jobTitle_note"));
        textAreaJobNote.sendKeys("This is Note of Job");
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        btnSave.click();
        Assert.assertEquals("Already exists", driver.findElement(By.xpath("//span[text()='Already exists']")).getText());
    }

    @Test
    public void shouldAddJobTitleWithSuccess() {
        WebElement elementBtnAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementBtnAdmin.click();
        WebElement elementBtnJob = driver.findElement(By.id("menu_admin_Job"));
        elementBtnJob.click();
        WebElement elementBtnJobTitle = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        elementBtnJobTitle.click();
        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement textFieldJobTitle = driver.findElement(By.id("jobTitle_jobTitle"));
        textFieldJobTitle.sendKeys(titleID);
        WebElement textAreaJobDescription = driver.findElement(By.id("jobTitle_jobDescription"));
        textAreaJobDescription.sendKeys("This is Description of Job");
        WebElement fileChooserJobTitle = driver.findElement(By.id("jobTitle_jobSpec"));
        fileChooserJobTitle.sendKeys(file.getAbsolutePath());
        WebElement textAreaJobNote = driver.findElement(By.id("jobTitle_note"));
        textAreaJobNote.sendKeys("This is Note of Job");
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        btnSave.click();
        Assert.assertEquals(driver.getCurrentUrl(), urlJobAdmin);
    }
    
    @Test
    public void shouldAddJobTitleWithBigSizeFile() {
        String url = "https://opensource-demo.orangehrmlive.com/index.php/admin/saveJobTitle/jobTitleId/";
        WebElement elementBtnAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementBtnAdmin.click();
        WebElement elementBtnJob = driver.findElement(By.id("menu_admin_Job"));
        elementBtnJob.click();
        WebElement elementBtnJobTitle = driver.findElement(By.id("menu_admin_viewJobTitleList"));
        elementBtnJobTitle.click();
        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement textFieldJobTitle = driver.findElement(By.id("jobTitle_jobTitle"));
        textFieldJobTitle.sendKeys("Job1");
        WebElement textAreaJobDescription = driver.findElement(By.id("jobTitle_jobDescription"));
        textAreaJobDescription.sendKeys("This is Description of Job");
        WebElement fileChooserJobTitle = driver.findElement(By.id("jobTitle_jobSpec"));
        fileChooserJobTitle.sendKeys(bigSizeFile.getAbsolutePath());
        WebElement textAreaJobNote = driver.findElement(By.id("jobTitle_note"));
        textAreaJobNote.sendKeys("This is Note of Job");
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        btnSave.click();
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
    @AfterTest
    public void after() {
        driver.quit();
    }
}
