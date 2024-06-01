import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;



public class SeleniumTest {
    private static final Logger logger = LogManager.getLogger(SeleniumTest.class);

    @Test
    public void TestPrueba() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Configurar Chrome en modo headless
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://www.saucedemo.com/");
            // Site
            logger.info("SAUCE DEMO");

            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("..\\ProyectoPrueba_2\\ScreenShots\\pantalla.png"));
        } catch (IOException e) {
            logger.error("Error al guardar la captura de pantalla: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}



