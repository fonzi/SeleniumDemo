package com.developvazquez.www.test;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.developvazquez.www.AbstractSeleniumDemo;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;

/**
 * Test log in and log out functionality using selenium
 */
@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "benchmark-lists")
@BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 0)
public class Navigate extends AbstractSeleniumDemo
{
    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    @Test
    public void navigateByID() throws Exception
    {
        boolean clickedButtons = false;
        myDriver.get(myBaseUrl);
        System.out.println("ID selection");
        myDriver.findElement(By.id("javaSamplesButton")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.id("PythonSamplesButton")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.id("ResumeButton")).click();
        Thread.sleep(1000);
        assert clickedButtons : "The button was clicked";
    }

    @Test
    public void navigateByCssSelector() throws Exception
    {
        boolean clickedButtons = false;
        System.out.println("Css Selector");
        myDriver.get(myBaseUrl);
        System.out.println(myDriver.toString());
        myDriver.findElement(By.cssSelector("input[id*='javaSamplesButton']")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.cssSelector("input[id*='PythonSamplesButton']")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.cssSelector("input[id*='ResumeButton']")).click();
        Thread.sleep(1000);
        assert clickedButtons : "The button was clicked";
    }

    @Test
    public void navigateByXpath() throws Exception
    {
        System.out.println("Xpath Selection");
        boolean clickedButtons = false;
        myDriver.get(myBaseUrl);
        System.out.println(myDriver.toString());
        myDriver.findElement(By.xpath("//input[@id='javaSamplesButton']")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.xpath("//input[@id='PythonSamplesButton']")).click();
        Thread.sleep(1000);
        myDriver.findElement(By.xpath("//input[@id='ResumeButton']")).click();
        Thread.sleep(1000);
        assert clickedButtons : "The button was clicked";
    }
}