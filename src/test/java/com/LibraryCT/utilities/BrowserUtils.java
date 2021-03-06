package com.LibraryCT.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {


    /*
    This method accepts List<WebElement> and returns List<Strings>
     */

    public static List<String> getElementsText(List<WebElement> webElementList){

        //Placeholder empty list of web element
        List<String> webElementsAsString = new ArrayList<>();

        //Looping through list of web elements and storing text into placeholder list
        for (WebElement each : webElementList) {
            webElementsAsString.add(each.getText());
        }

        //returning final List<String>
        return webElementsAsString;
    }

    public static void titleVerification(String expectedTitle){

        String actualTitle = com.LibraryCT.utilities.Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        //return actualTitle.equals(expectedTitle);
    }

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }
    public static WebElement getElement(String xpath, String value){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(xpath,value))));
    }

    public static WebElement getElement(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xpath)));
    }

    public static List<WebElement> getElements(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public static void clickElement(WebElement element){
        waitUntilClickable(element).click();
    }

    public static void clickAndSend(String xpath,String value) {
        WebElement element = getElement(xpath);
        clickElement(element);
        BrowserUtils.sleep((int) 0.5);
        element.sendKeys(value);
    }

    public static void clickElement(String xpath){
        waitUntilClickable(getElement(xpath)).click();
    }

    public static void clickElement(String xpath, String value){
        waitUntilClickable(getElement(xpath,value)).click();
    }

    public static String getChildWindowTitle() {
        switchToChildWindow();
        return Driver.getDriver().getTitle();
    }

    public static String getChildWindowURL() {
        switchToChildWindow();
        return Driver.getDriver().getCurrentUrl();
    }

    public static void scrollTo(String xpath,String value){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getElement(xpath,value));
    }

    public static void scrollTo(String xpath){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getElement(xpath));
    }

    public static void scrollTo(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                element);
    }

    public static void scrollAndClick(String xpath,String value){
        scrollTo(xpath,value);
        clickElement(xpath,value);
    }

    public static void setParentWindow(){
        String parentWindow = Driver.getDriver().getWindowHandle();
    }

    public static void switchToChildWindow(){
        setParentWindow();
        String parentWindow=Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String each : windows){
            if (!each.equals(parentWindow)){
                Driver.getDriver().switchTo().window(each);
            }
        }
    }

    public static void switchToParentWindow(){
        String parentWindow=Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(parentWindow);
    }

    public static boolean elementDisplayed(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();
    }

    public static boolean elementDisplayed(String xpath,String value){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xpath,value)))).isDisplayed();
    }

    public static boolean elementSelected(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isSelected();
    }

    public static boolean elementSelected(String xpath,String value){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions.elementToBeSelected(By.xpath(String.format(xpath,value))));
    }

    public static List<String> getTextOfElements(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement eachElement : elements) {
            texts.add(eachElement.getText().trim());
        }
        return texts;
    }

    public static WebElement waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickable(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitUntilTextToBe(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        return wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public static void waitUntilUrlToBe(String url) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static boolean waitUntilURLContains(String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        return wait.until(ExpectedConditions.urlContains(text));
    }

    public static void waitUntilTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitUntilTitleIs(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitForVisibility(WebElement element, int i) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void hoverOver(String xpath) {
        Actions act = new Actions(Driver.getDriver());
        act.moveToElement(Driver.getDriver().findElement(By.xpath(xpath))).perform();
    }

    public static void turnOnImplicitWait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void turnOffImplicitWait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static void getScreenshot(String name) throws IOException {
        // name the screenshot with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
    }
}
