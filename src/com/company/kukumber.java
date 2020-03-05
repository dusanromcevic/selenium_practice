package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class kukumber {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.romcevic\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String[] vegetables = {"Cucumber", "Brocolli"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        shopCart(driver,vegetables);

    }


    public static void shopCart(WebDriver driver, String[] vegetables) {

        List vegetablesList = Arrays.asList(vegetables);
        List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
        WebDriverWait wait = new WebDriverWait(driver,5);
        int j = 0;

        for (int i = 0; i < products.size(); i++) {
            String[] prodName = products.get(i).getText().split("-");
            String formattedName = prodName[0].trim();
            if (vegetablesList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                if (j == vegetables.length)
                    break;
            }
        }

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input[class=\'promoCode\']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button[class='promoBtn']")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));

        System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());

    }
}
