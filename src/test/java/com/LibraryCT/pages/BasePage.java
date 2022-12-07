package com.LibraryCT.pages;


import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
// PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!
// PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!
// PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!

/**
 * parent class for concrete Page object classes
 * provides constructor with initElements method for re-usability
 * abstract - to prevent instantiation.
 */
public abstract  class BasePage {

    // PLEASE DO NOT MAKE ANY CHANGES IN THIS CLASS WITHOUT COMMUNICATION WITH THE TEAM! THANK YOU!

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[@class='title'][.='Users']")
    public WebElement users;

    @FindBy(xpath = "//span[@class='title'][.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//span[@class='title'][.='Books']")
    public WebElement books;

    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;

    @FindBy(linkText = "Log Out")
    public WebElement logOutLink;

    public void logOut(){
        accountHolderName.click();
        logOutLink.click();
    }

    public void navigateModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("//span[@class='title'][.='"+moduleName+"']")).click();
    }
}
