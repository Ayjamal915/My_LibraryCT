package com.LibraryCT.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath ="//*[@id='menu_item']/li[1]/a/span[1]")
    public WebElement dashBoardTab;

    @FindBy(xpath="//*[@id='user_count']")
    public WebElement userCount;

    @FindBy(xpath = "//img[@id='user_avatar']")
    public WebElement userAvatar;

    @FindBy(css="a.dropdown-item")
    public WebElement logoutButton;

    @FindBy(xpath ="//*[@id='menu_item']/li[2]/a/span[1]")
    public WebElement usersTab;

    @FindBy(xpath = "//*[@id='menu_item']/li[2]/a/span[1]")
    public WebElement borrowingBooksLink;


}
