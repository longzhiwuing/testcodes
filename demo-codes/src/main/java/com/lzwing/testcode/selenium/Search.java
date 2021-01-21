package com.lzwing.testcode.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/11/30
 * Time: 14:01
 */
public class Search {
    private WebDriver driver;
    public static final String YOUDAO_HOME_URL = "http://www.youdao.com/";
    public static final String INPUT_HOME_ID = "translateContent";
    public static final String SEARCH_HOME_XPATH = "//*[@id=\"form\"]/button";
    public static final String CLOSE_BTN = "/html/body/div[7]/i/a[1]";
    public static final String INPUT_SEARCH = "query";
    public static final String SEARCH_BTN_XPATH = "//*[@id=\"f\"]/input";
    public static final String TRANSLATION_CLASS = "trans-container";

    //Constructor, initialize web driver
    public Search(WebDriver driver) {
        this.driver = driver;
    }

    //Direct to YoudaoDic homepage, land in the main search page
    public void setUp() {
        //Go to youdao.com
        driver.get(YOUDAO_HOME_URL);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Go to the main search page
        driver.findElement(By.id(INPUT_HOME_ID)).sendKeys("test");
        driver.findElement(By.xpath(SEARCH_HOME_XPATH)).click();
        driver.findElement(By.xpath(CLOSE_BTN)).click();
    }

    //Search word and get the translation
    public String searchword(String s) {
        //Find the input element, input the word and click the button
        WebElement input_search = driver.findElement(By.id(INPUT_SEARCH));
        input_search.clear();
        input_search.sendKeys(s);
        driver.findElement(By.xpath(SEARCH_BTN_XPATH)).click();
        //Get the text inside translation div
        String result = driver.findElement(By.className(TRANSLATION_CLASS)).getText();
        return result;
    }

    //Quit the Driver
    public void quit() {
        driver.quit();
    }

    //Search the word and write down
    public static void searchWord(String word) {
        //Initialize driver
        WebDriver driver = new ChromeDriver();
        Search search = new Search(driver);
        search.setUp();
        String results = search.searchword(word);
        System.out.printf("results:%s%n", results);
        search.quit();
    }

    public static void main(String[] args) {
        searchWord("test");
    }

}
