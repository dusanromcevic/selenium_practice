package com.company;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class UI_assignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\d.romcevic\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://cleartrip.com");
        driver.findElement(By.id("Adults")).click();
        Select NoOfAdults = new Select(driver.findElement(By.id("Adults")));
        NoOfAdults.selectByValue("3");
        Select NoOfChildren = new Select(driver.findElement(By.id("Childrens")));
        NoOfChildren.selectByVisibleText("2");
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        driver.findElement(By.id("MoreOptionsLink")).click();
        driver.findElement(By.id("AirlineAutocomplete")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("HeyThere");
        driver.findElement(By.id("SearchBtn")).click();
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
        // driver.close();
    }
}