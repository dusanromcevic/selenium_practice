package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class suknje {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.romcevic\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        test(driver);
    }

    public static void test (WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.name("search_query")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div[class='product-image-container'] img[class*='img-responsive']"))));
        driver.findElements(By.cssSelector("div[class='product-image-container'] img[class*='img-responsive']")).get(4).click();

        //switch to iFrame

        WebElement fr = driver.findElement(By.cssSelector("iframe[class='fancybox-iframe']"));
        wait.until(ExpectedConditions.visibilityOf(fr));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[class='fancybox-iframe']")));



//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='fancybox-iframe']")));
        System.out.println(driver.findElement(By.cssSelector("div[id='short_description_content'] p")).getText());
/*
        // dropdown handling
        Select velicina = new Select(driver.findElement(By.id("group_1")));
        velicina.selectByValue("2");

        for (int i = 1; i < 3; i++) {
            driver.findElement(By.cssSelector("i[class='icon-plus']")).click();
        }

        driver.findElement(By.cssSelector("button[name='Submit']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("span[class='cross']")).click();

        //in case we need to close the iframe instead of adding items to the cart
//        driver.switchTo().defaultContent();
//        driver.findElement(By.cssSelector("a[class*='fancybox-close']")).click();
*/
    }
}
