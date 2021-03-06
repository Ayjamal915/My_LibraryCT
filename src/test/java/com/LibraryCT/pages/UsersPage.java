package com.LibraryCT.pages;


import com.LibraryCT.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UsersPage extends BasePage {
    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//*[@id='users']/div[1]/div[1]/span/a")
    public WebElement userAdd;

    @FindBy(xpath = "//*[@id='tbl_users']/thead/tr/th")
    public List<WebElement> tableHeaders;

    @FindBy(id = "user_status")
    public WebElement statusDropDown;

    @FindBy(id = "user_groups")
    public WebElement userGroupDropDown;

    // @FindBy(tagName = "th")
    @FindBy(xpath = "//*[@id='tbl_books']/thead/tr/th")
    public List<WebElement> bookTableHeaders;

    @FindBy(xpath = "//*[@id='borrowed_list']/thead/tr/th")
    public List<WebElement> borrowedBooksTableHeaders;

    @FindBy(xpath = "//*[@id='tbl_users_length']/label/select")
    public WebElement showRecordsDropDown;

    // @FindBy(xpath = "//*[@id=\"add_user_form\"]/div[1]/div/div[1]/div/div/input")
    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullNameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    //@FindBy(xpath = "//input[@name='start_date']")
    @FindBy(xpath="//*[@id='start_date']/input")
    public WebElement startDateBox;

    @FindBy(xpath="//*[@id='end_date']/input")
    //@FindBy(xpath = "//input[@name='end_date']")
    public WebElement endDateBox;

    @FindBy(xpath="//*[@id='user_group_id']")
    //@FindBy(xpath = "//select[@id='user_group_id']")
    public WebElement userGroupDropDownAy;

    //@FindBy(xpath="//*[@id='status']")
    @FindBy(id = "status")
    public WebElement statusDropDownAy;

    @FindBy(id = "address")
    public WebElement addressBox;

    @FindBy(xpath="//*[@id='add_user_form']/div[2]/button[2]")
    public WebElement addUserSave;

    //@FindBy(xpath = "//*[@id='add_user_form']/div[2]/button[1]")
    @FindBy(xpath = "//button[.='Close']")
    public WebElement addUserClose;
    Faker faker = new Faker();
    public void addUser() {
        String streetName = faker.address().streetName();
        String name = faker.name().fullName();
        BrowserUtils.waitForVisibility(fullNameBox, 5);
        fullNameBox.sendKeys(name);
        passwordBox.sendKeys(faker.internet().password());
        emailBox.sendKeys(faker.internet().emailAddress());
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusYears(2);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userGroupDropDownAy.click();
        Select newStat = new Select(userGroupDropDownAy);
        newStat.selectByVisibleText("Students");

        //actions.moveToElement(usersPage.statusDropDownAy).perform();
        //actions.perform();
        statusDropDownAy.click();

        Select newDrop = new Select(statusDropDownAy);
        newDrop.selectByVisibleText("ACTIVE");

        startDateBox.sendKeys(futureDate.format(df));
        endDateBox.sendKeys(futureDate.format(df));

        addressBox.sendKeys(faker.address().fullAddress());


    }


}

