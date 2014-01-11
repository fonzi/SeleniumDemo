package com.developvazquez.www.test;

import com.developvazquez.www.AbstractSeleniumDemo;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

/**
 * Test log in and log out functionality using selenium
 */
public class Navigate extends AbstractSeleniumDemo
{
    @Test
    public void testLogInOut() throws Exception
    {
        boolean clickedButtons = false;
        myDriver.get(myBaseUrl);
        System.out.println(myDriver.toString());
        myDriver.findElement(By.id("javaSamplesButton")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.id("PythonSamplesButton")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.id("ResumeButton")).click();
        Thread.sleep(1000);
        assert clickedButtons : "The button was clicked";
    }
}