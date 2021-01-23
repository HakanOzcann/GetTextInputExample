package GetTextExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class getText
{
    WebDriver driver;

    @BeforeTest
    public void chromeDriver()
    {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
        driver = new ChromeDriver();
        String baseUrl = "http://www.htmlcodes.ws/textboxes/";
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void getTextboxInfo()
    {
        WebElement sampleMessage = driver.findElement(By.name("textbox_message"));
        sampleMessage.sendKeys(" TEST ");

        String textValue = sampleMessage.getAttribute("value");
        System.out.println("Website Text: " + textValue);

    }

    @AfterTest
    public void driverClose()
    {
        driver.close();
    }

}
