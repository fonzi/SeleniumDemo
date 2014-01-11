package com.developvazquez.www;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;
import java.util.Properties;
import static org.junit.Assert.fail;

public abstract class AbstractSeleniumDemo
{
    private boolean myAcceptNextAlert = true;

    private StringBuffer myVerificationErrors = new StringBuffer();

    protected WebDriver myDriver;
    protected String myBaseUrl;
    protected String myBrowser = "browser.property";
    protected Properties myProp = System.getProperties();

    /**
     * Initializes the webDriver that is given. Takes myBrowser from build.xml and sets appropriate property
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {

        System.out.println("val " + myBrowser + " is " + myProp.getProperty(myBrowser));

        if(myProp.getProperty(myBrowser) == null)
        {
            System.err.println("The property was not passed. Prop == null");
        }
        else if(myProp.getProperty(myBrowser).equals("firefox"))
        {
            myDriver = new FirefoxDriver();
            myBaseUrl = "https://bugtracker2.mediabeacon.com/";
            myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        else if(myProp.getProperty(myBrowser).equals("chrome"))
        {
            //need to change to match machine location.
            System.setProperty("webdriver.chrome.driver", "/Users/alfonsovazquez/Downloads/chromedriver");
            myDriver = new ChromeDriver();
            myBaseUrl = "https://bugtracker2.mediabeacon.com/";
            myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        else if(myProp.getProperty(myBrowser).equals("safari"))
        {
            myDriver = new SafariDriver();
            myBaseUrl = "https://bugtracker2.mediabeacon.com/";
            myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }
    /**
     * Stops the webDriver
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception
    {
        myDriver.quit();
        String aVerificationErrorString = myVerificationErrors.toString();
        if (!"".equals(aVerificationErrorString))
        {
            fail(aVerificationErrorString);
        }
    }

    /**
     * Checks if a Web element is present.
     * @param theBy
     * @return a boolean expression.
     */
    private boolean isElementPresent(By theBy)
    {
        try
        {
            myDriver.findElement(theBy);
            return true;
        } catch (NoSuchElementException e)
        {
            return false;
        }
    }
    /**
     * Checks if the alert is Present
     * @return boolean value
     */
    private boolean isAlertPresent()
    {
        try
        {
            myDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    /**
     * Sets alert to webDriver.
     * @return alertText if success or not.
     */
    private String closeAlertAndGetItsText()
    {
        try
        {
            Alert anAlert = myDriver.switchTo().alert();
            String alertText = anAlert.getText();
            if (myAcceptNextAlert)
            {
                anAlert.accept();
            } else
            {
                anAlert.dismiss();
            }
            return alertText;
        } finally
        {
            myAcceptNextAlert = true;
        }
    }
}
