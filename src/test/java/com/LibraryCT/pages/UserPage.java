package com.LibraryCT.pages;


import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

    @FindBy(xpath = "(//tbody//a[@role='button'])[1]")
    public WebElement editUser;

    @FindBy(xpath = "//*[@id=\"menu_item\"]/li[3]/a/span[1]")
    public WebElement bookButton;

    @FindBy(xpath = "//*[@id=\"books\"]/div[1]/div[1]/span/a")
    public WebElement addBook;

//    @FindBy(name = "name")
//    public WebElement bookName;


    @FindBy(id = "status")
    public WebElement statusDropdown;

    @FindBy(name = "email")
    public WebElement email;

    @FindBy(xpath = " //button[@type=\"submit\"]")
    public WebElement saveChanges;

    @FindBy(css = " .toast-message")
    public WebElement toastMessage;

    @FindBy(id = "user_status")
    public WebElement userStatusDropdown;


    @FindBy(css = ".dataTables_info")
    private WebElement userCount;

    @FindBy(css = ".form-control.input-sm.input-xsmall.input-inline")
    public WebElement numberOfUsersDropdown;

    @FindBy(id = "tbl_users_info")
    public WebElement usersInfo;

    public WebElement editUser(String email) {
        String xpath = "//td[.='"+ email+ "']/..//a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

}
