import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Đặt đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
    @Test
    public void testLoginSuccess() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }

    @Test
    public void testLoginInvalidUsername() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Nhập tên người dùng không hợp lệ và mật khẩu hợp lệ
        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Nhấn nút Đăng nhập
        driver.findElement(By.id("submit")).click();

        // Xác nhận thông báo lỗi
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!");
    }

    @Test
    public void testLoginInvalidPassword() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Nhập tên người dùng hợp lệ và mật khẩu không hợp lệ
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");

        // Nhấn nút Đăng nhập
        driver.findElement(By.id("submit")).click();

        // Xác nhận thông báo lỗi
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
