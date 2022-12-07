package com.LibraryCT.pages;


import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(id = "book_group_id")
    public WebElement categoryDropDown;


    @FindBy(name = "name")
    public WebElement borrowBook;

    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(xpath = "//div[@class='portlet-title']//a")
    public WebElement addBook;

    @FindBy(xpath = "//table[@id='tbl_books']/tbody/tr/td[3]")
    public List<WebElement> verifyBookName;

    @FindBy(xpath = "//form[@id='add_book_form']//button[@type='submit']")
    public WebElement saveChangesBtn;


//    @FindBy(id = "book category")
//    public WebElement category;

    @FindBy(id = "description")
    public WebElement description;
//    @FindBy(xpath = "//table/tbody/tr/td")
//    public WebElement borrowBook;

    @FindBy(xpath = "//table/tbody/tr/td")
    public List<WebElement> allCells;

    @FindBy(xpath = "//table/thead/tr/td")
    public List<WebElement> tableHeaderCells;






    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public WebElement borrowBook(String book){
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public String verifyFileName(List<WebElement> listOfElements, String expected) {
        String actual = "";
        for (WebElement each : listOfElements) {
            if (each.getText().equalsIgnoreCase(expected)) {
                actual += "" + each.getText();
                break;
            }
        }
        return actual;
    }

    public String actualBookName(List<WebElement> listOfElements, String expected) {
        String actual = "";
        for (WebElement each : listOfElements) {
            if (each.getText().equalsIgnoreCase(expected)) {
                actual += "" + each.getText();
                break;
            }
        }
        return actual;
    }

}

