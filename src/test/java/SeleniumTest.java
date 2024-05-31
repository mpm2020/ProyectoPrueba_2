import com.google.common.annotations.VisibleForTesting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeleniumTest {
    private static final Logger logger = LogManager.getLogger(SeleniumTest.class);

    @Test
    public void TestPrueba() {
        WebDriver driver = new ChromeDriver();
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



