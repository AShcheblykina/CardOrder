import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest {
    private WebDriver driver;

   @BeforeAll
    static void setUpAll() {
       System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearnDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest1() throws InterruptedException {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Василий Иванов");
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("+79384988568");
        driver.findElement(By.tagName("label")).click();
        driver.findElement(By.cssSelector("button[type='button']")).click();
        String expected = " Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.tagName("p")).getText();

        assertEquals(expected, actual);

    }


}
