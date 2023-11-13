package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenS {    //метод скрин во время ошибки всей страницы
    static public void takeScreenShot(WebDriver driver, String fileName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        File DestFile = new File("pictures/"+new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime()) + fileName + ".png");
//Copy file at destination
        try {
            FileUtils.copyFile(file, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // метод скрин элемента
    public static void getWebElementPNG(WebElement ele, WebDriver driver, String fileName) {   // create PNG

// Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg;
        try {
            fullImg = ImageIO.read(screenshot);
        } catch (IOException e) {
            return;

        }

// Get the location of element on the page
        Point point = ele.getLocation();

// Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        try {
            ImageIO.write(eleScreenshot, "png", screenshot);
        } catch (IOException e) {
            return;
        }

// Copy the element screenshot to disk
        File screenshotLocation = new File("pictures/"+new SimpleDateFormat("MM_dd_HH-mm-ss").format(Calendar.getInstance().getTime()) + fileName + ".png");

        try {
            FileUtils.copyFile(screenshot, screenshotLocation);
        } catch (IOException e) {
        }

    }
}
