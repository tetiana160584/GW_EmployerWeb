package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ScreenS;
import utils.WorkWithLogs;
import utils.WorkWithTextFile;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public  void create() {
        driver = DriverFactory.greateDriver(WEBDRIVERS.BNIGARSIA);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterClass
    public  void end() throws InterruptedException {
        Thread.sleep(6000);
        //WorkWithLogs.printAllLogs(driver); //для логов
        WorkWithLogs.writeLogsToFile(driver, "ConsoleLogs"); //для логов

//        List<String>stringList=WorkWithTextFile.readFile("11_12_16-48-01ConsoleLogs.txt");
//        System.out.println(stringList);
        driver.quit();
    }
}
