package utils;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.imageio.ImageIO;
import org.openqa.selenium.support.ui.Select;
import stepdefs.ServiceHooks;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class SeleniumUtils {

    private static WebDriver driver;
    private EnvironmentsVariables env = new EnvironmentsVariables();
    private GeneralUtils gu = new GeneralUtils();
    private static String FOLDERNAME = "Evidence";
    private String baseUrl;
    private String nodeUrl;
    DesiredCapabilities capability;
    //private boolean driver_local = true ;

    public void setUp()throws Exception{
        SetProperties();
        baseUrl = System.getProperty("PortalUrl");
        //nodeUrl = "http://10.6.195.1:4444/wd/hub"; //ip estatica mac vpn
        nodeUrl = "http://192.168.1.117:4444/wd/hub"; //ip estatica mac
        //nodeUrl = "http://159.203.183.129:4444/wd/hub"; //maquina virtual ip
        capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        capability.setVersion("69.0.3497.100");
        //driver = new RemoteWebDriver(new URL(nodeUrl), capability);
    }

    private void SetProperties()throws Exception{
        env.ReadJSONProperties();
    }
    public String ReadTexts(String name, String object)throws Exception{
        return env.ReadTextsOnWizard(name, object);
    }
    public void OpenBrowser(String url)throws Exception{
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();
    }
    public void GoToUrl(String url){
        driver.get(url);
    }
    public void maximizeBrowser(){
        //driver.manage().timeouts().pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
    }
    public void CloseBrowser() {
        driver.close();
    }
    public void changeIFrame(String newIFrame){
        driver.switchTo().frame(newIFrame);
    }
    public String validateValueinXPath(String path)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        return driver.findElement(By.xpath(path)).getText();
    }
    public void clickButtonInXPath(String path)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        driver.findElement(By.xpath(path)).click();
    }
    public void sendValuesXpath(String xpath, String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }
    public String validateTextInCss(String css)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        return driver.findElement(By.cssSelector(css)).getText();
    }
    public boolean CompareXpathWithValue(String xpath, String value)throws Throwable{
        return validateValueinXPath(xpath).equals(value);

    }
    public String getCSSColor(String path)throws Throwable{
        Thread.sleep(2000);
        return driver.findElement(By.xpath(path)).getCssValue("background-color");
    }

    public boolean containsValueInXPath(String xpath, String value){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String path = driver.findElement(By.xpath(xpath)).getText();
       // assert path.contains(value);
        return path.contains(value);
    }

    public boolean compareStringsInXpath(String xpath,String value) throws Throwable{
        Thread.sleep(4000);
        String path = driver.findElement(By.xpath(xpath)).getText();
        return value.equals(path);
    }


    public String GetXpathByName(String buttonName, String PO)throws Exception{
        String className = "pageObjects."+PO;
        Class<?> innerClass = Class.forName(className); // convert string classname to class
        String methodName = buttonName;
        Object aux = innerClass.newInstance(); // invoke empty constructor
        Method getNameMethod = aux.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(aux); // explicit cast
        //Thread.sleep(2000);
        return name;
    }


}
