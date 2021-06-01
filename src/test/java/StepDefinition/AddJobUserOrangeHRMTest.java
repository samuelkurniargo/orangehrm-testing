package StepDefinition;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AddJobUserOrangeHRMTest {
    WebDriver driver;

    @BeforeTest
    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        HashMap<String, Object> map = new HashMap<>();
        map.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", map);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        WebElement elementEmail = driver.findElement(By.xpath("//*[@id = 'txtUsername']"));
        WebElement elementPass = driver.findElement(By.xpath("//*[@id = 'txtPassword']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//*[@id = 'btnLogin']"));

        elementEmail.sendKeys("Admin");
        elementPass.sendKeys("admin123");
        buttonLogin.click();
    }

    @Test
    public void shouldAddUserSuccess () {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();
        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement elementUserRole = driver.findElement(By.id("systemUser_userType"));
        //elementUserRole.click();
        Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
        userRole.selectByVisibleText("Admin");
        WebElement elementEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        elementEmployeeName.sendKeys("John Smith");
        WebElement elementUsername = driver.findElement(By.id("systemUser_userName"));
        elementUsername.sendKeys("UsernameJohn");
        WebElement elementStatus = driver.findElement(By.id("systemUser_status"));
        //elementStatus.click();
        Select status = new Select(driver.findElement(By.id("systemUser_status")));
        status.selectByVisibleText("Enabled");
        WebElement elementPassword = driver.findElement(By.id("systemUser_password"));
        elementPassword.sendKeys("123456789");
        WebElement elementConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        elementConfirmPassword.sendKeys("123456789");
        WebElement elementBtnSave = driver.findElement(By.id("btnSave"));

        elementBtnSave.click();
    }

    @Test
    public void addUserWithEmptyEmployeeName() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();

        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement elementUserRole = driver.findElement(By.id("systemUser_userType"));
        //elementUserRole.click();
        Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
        userRole.selectByVisibleText("Admin");
        WebElement elementEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        elementEmployeeName.sendKeys(""); // --> empty employee name
        WebElement elementUsername = driver.findElement(By.id("systemUser_userName"));
        elementUsername.sendKeys("UsernameJohn");
        WebElement elementStatus = driver.findElement(By.id("systemUser_status"));
        //elementStatus.click();
        Select status = new Select(driver.findElement(By.id("systemUser_status")));
        status.selectByVisibleText("Enabled");
        WebElement elementPassword = driver.findElement(By.id("systemUser_password"));
        elementPassword.sendKeys("123456789");
        WebElement elementConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        elementConfirmPassword.sendKeys("123456789");
        WebElement elementBtnSave = driver.findElement(By.id("btnSave"));

        elementBtnSave.click();
        //Assert.assertEquals("Required", driver.findElement(By.xpath("//span[@class = 'validation-error']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class = 'validation-error']")).getText(), "Required");

    }

    @Test

    public void addUserWithRandomEmployeeName() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();

        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement elementUserRole = driver.findElement(By.id("systemUser_userType"));
        //elementUserRole.click();
        Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
        userRole.selectByVisibleText("Admin");
        WebElement elementEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        elementEmployeeName.sendKeys("cekusernamebebeas"); // --> Random Employee Name
        WebElement elementUsername = driver.findElement(By.id("systemUser_userName"));
        elementUsername.sendKeys("UsernameJohn");
        WebElement elementStatus = driver.findElement(By.id("systemUser_status"));
        //elementStatus.click();
        Select status = new Select(driver.findElement(By.id("systemUser_status")));
        status.selectByVisibleText("Enabled");
        WebElement elementPassword = driver.findElement(By.id("systemUser_password"));
        elementPassword.sendKeys("123456789");
        WebElement elementConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        elementConfirmPassword.sendKeys("123456789");
        WebElement elementBtnSave = driver.findElement(By.id("btnSave"));

        elementBtnSave.click();
        System.out.println(driver.findElement(By.xpath("//span[@class = 'validation-error']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class = 'validation-error']")).getText(), "Employee does not exist");
    }
    
    @Test
    public void addUserWithEmptyUsername() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();

        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement elementUserRole = driver.findElement(By.id("systemUser_userType"));
        //elementUserRole.click();
        Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
        userRole.selectByVisibleText("Admin");
        WebElement elementEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        elementEmployeeName.sendKeys("David Morris");
        WebElement elementUsername = driver.findElement(By.id("systemUser_userName"));
        elementUsername.sendKeys("");
        WebElement elementPassword = driver.findElement(By.id("systemUser_password"));
        elementPassword.sendKeys("123456789");
        WebElement elementConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        elementConfirmPassword.sendKeys("123456789");
        WebElement elementBtnSave = driver.findElement(By.id("btnSave"));
        elementBtnSave.click();
        Assert.assertEquals("Required", driver.findElement(By.xpath("//span[text()='Required']")).getText());
    }

    @Test
    public void addUserWithUsernameAlreadyExist() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();

        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
        userRole.selectByVisibleText("Admin");
        WebElement elementEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        elementEmployeeName.sendKeys("David Morris");
        WebElement elementUsername = driver.findElement(By.id("systemUser_userName"));
        elementUsername.sendKeys("admin123");
        WebElement elementStatus = driver.findElement(By.id("systemUser_status"));
        //elementStatus.click();
        Select status = new Select(driver.findElement(By.id("systemUser_status")));
        status.selectByVisibleText("Enabled");
        WebElement elementPassword = driver.findElement(By.id("systemUser_password"));
        elementPassword.sendKeys("123456789");
        WebElement elementConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        elementConfirmPassword.sendKeys("123456789");
        WebElement elementBtnSave = driver.findElement(By.id("btnSave"));
        elementBtnSave.click();
        Assert.assertEquals("Already exists", driver.findElement(By.xpath("//span[text()='Already exists']")).getText());
    }

    @Test
    public void addUserWithCharacterLessThanFive() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();

        WebElement elementBtnAdd = driver.findElement(By.id("btnAdd"));
        elementBtnAdd.click();
        WebElement elementUserRole = driver.findElement(By.id("systemUser_userType"));
        //elementUserRole.click();
        Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
        userRole.selectByVisibleText("Admin");
        WebElement elementEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        elementEmployeeName.sendKeys("David Morris");
        WebElement elementUsername = driver.findElement(By.id("systemUser_userName"));
        elementUsername.sendKeys("admi");
        WebElement elementStatus = driver.findElement(By.id("systemUser_status"));
        //elementStatus.click();
        Select status = new Select(driver.findElement(By.id("systemUser_status")));
        status.selectByVisibleText("Enabled");
        WebElement elementPassword = driver.findElement(By.id("systemUser_password"));
        elementPassword.sendKeys("123456789");
        WebElement elementConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        elementConfirmPassword.sendKeys("123456789");
        WebElement elementBtnSave = driver.findElement(By.id("btnSave"));
        elementBtnSave.click();
        Assert.assertEquals("Should have at least 5 characters", driver.findElement(By.xpath("//span[text()='Should have at least 5 characters']")).getText());
    }

    @Test
    public void addUserWithNormalPassword() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();
        WebElement btnAddUser = driver.findElement(By.id("btnAdd"));
        btnAddUser.click();
        Select selectRole = new Select(driver.findElement(By.id("systemUser_userType")));
        WebElement textFieldUsername = driver.findElement(By.id("systemUser_userName"));
        WebElement textFieldEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        WebElement textFieldPassword = driver.findElement(By.id("systemUser_password"));
        WebElement textFieldConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        selectRole.selectByVisibleText("Admin");
        textFieldEmployeeName.sendKeys("David Morris");
        textFieldUsername.sendKeys("admin123");
        textFieldPassword.sendKeys("admin12345");
        textFieldConfirmPassword.sendKeys("admin12345");
        btnSave.click();
    }

    @Test
    public void addUserWithEmptyPassword() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();
        WebElement btnAddUser = driver.findElement(By.id("btnAdd"));
        btnAddUser.click();
        Select selectRole = new Select(driver.findElement(By.id("systemUser_userType")));
        WebElement textFieldUsername = driver.findElement(By.id("systemUser_userName"));
        WebElement textFieldEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        WebElement textFieldPassword = driver.findElement(By.id("systemUser_password"));
        WebElement textFieldConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        selectRole.selectByVisibleText("Admin");
        textFieldEmployeeName.sendKeys("David Morris");
        textFieldUsername.sendKeys("StevenSand");
        textFieldPassword.sendKeys("");
        textFieldConfirmPassword.sendKeys("");
        btnSave.click();
        Assert.assertEquals("Required", driver.findElement(By.xpath("//span[text()='Required']")).getText());
    }

    @Test
    public void addUserWithDifferentWithConfirm() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();
        WebElement btnAddUser = driver.findElement(By.id("btnAdd"));
        btnAddUser.click();
        Select selectRole = new Select(driver.findElement(By.id("systemUser_userType")));
        WebElement textFieldUsername = driver.findElement(By.id("systemUser_userName"));
        WebElement textFieldEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        WebElement textFieldPassword = driver.findElement(By.id("systemUser_password"));
        WebElement textFieldConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        selectRole.selectByVisibleText("Admin");
        textFieldEmployeeName.sendKeys("David Morris");
        textFieldUsername.sendKeys("StevenSanjaya");
        textFieldPassword.sendKeys("admin12345");
        textFieldConfirmPassword.sendKeys("admin12345678");
        btnSave.click();
        Assert.assertEquals("Passwords do not match", driver.findElement(By.xpath("//span[text()='Passwords do not match']")).getText());
    }

    @Test
    public void addUserWithAtLeastEightCharacter() {
        WebElement elementAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        elementAdmin.click();
        WebElement btnAddUser = driver.findElement(By.id("btnAdd"));
        btnAddUser.click();
        Select selectRole = new Select(driver.findElement(By.id("systemUser_userType")));
        WebElement textFieldUsername = driver.findElement(By.id("systemUser_userName"));
        WebElement textFieldEmployeeName = driver.findElement(By.id("systemUser_employeeName_empName"));
        WebElement textFieldPassword = driver.findElement(By.id("systemUser_password"));
        WebElement textFieldConfirmPassword = driver.findElement(By.id("systemUser_confirmPassword"));
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        selectRole.selectByVisibleText("Admin");
        textFieldEmployeeName.sendKeys("David Morris");
        textFieldUsername.sendKeys("StevenSanjayaPPPPP");
        textFieldPassword.sendKeys("1234");
        textFieldConfirmPassword.sendKeys("1234");
        btnSave.click();
        Assert.assertEquals("Please enter at least 8 characters.", driver.findElement(By.xpath("//span[text()='Please enter at least 8 characters.']")).getText());
    }
    @AfterTest
    public void after() {
        driver.quit();
    }
}
