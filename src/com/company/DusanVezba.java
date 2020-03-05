package com.company;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DusanVezba {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.romcevic\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.cssSelector("img[class*='logo']")).getAttribute("alt"));
        driver.findElement(By.name("search_query")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).click();
        System.out.println(driver.findElements(By.cssSelector("a[class='product-name']")).get(3).getText());
        driver.findElements(By.cssSelector("div[class='product-image-container'] img[class*='img-responsive']")).get(4).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //switch to iFrame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='fancybox-iframe']")));
        System.out.println(driver.findElement(By.cssSelector("div[id='short_description_content'] p")).getText());

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


        // adding items to the cart
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] vegetables = {"Cucumber", "Brocolli"};

        List vegetablesList = Arrays.asList(vegetables);

        List <WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

        for (int i=0; i<products.size();i++){
           String[] prodName = products.get(i).getText().split("-");
           String formattedName = prodName[0].trim();
           int j=0;
           if (vegetablesList.contains(formattedName)){
               j++;
               driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

               if(j==vegetables.length)
                   break;
           }
        }

        /*

        // static dropdown menus
        driver.get("https://www.spicejet.com/");

        Select selektor = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        selektor.selectByValue("USD");
        selektor.selectByIndex(0);
        selektor.selectByVisibleText("AED");

        // dynamic dropdown menus

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//a[@value='IXM'])[2]")).click();
        driver.findElement(By.cssSelector("div[id=\'glsctl00_mainContent_ddl_destinationStation1_CTNR\'] a[value=\'IXM\']"));

        //Webelement introduction, clearing fields, keyboard actions
        driver.get("https://www.thetrainline.com/");
        WebElement okle = driver.findElement(By.cssSelector("input[id=\'from.text\']"));
        WebElement dokle = driver.findElement(By.cssSelector("input[id=\'to.text\']"));
        WebElement oneWay = driver.findElement(By.cssSelector("input[id*=\'outbound.title\']"));
        okle.sendKeys("mad");
        okle.sendKeys(Keys.ENTER);
        dokle.sendKeys("mala");
        dokle.sendKeys(Keys.ARROW_DOWN);
        dokle.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("input[id='single']")).click();
        oneWay.click();
        oneWay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        oneWay.sendKeys("23.04.2020.");
        oneWay.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("button[id='passenger-summary-btn']")).click();
        driver.findElement(By.xpath("//div[@class='_1kc0rsh']//span")).click();
        driver.findElement(By.cssSelector("button[class='_1abohmdt']")).click();
        //driver.findElement(By.cssSelector("div[class='_1kc0rsh'] span")).click();
        driver.findElement(By.cssSelector("button[data-test='submit-journey-search-button']")).click();

        //handling alerts
        String name = "Dusan";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();


         */

//        List<WebElement> products = driver.findElements(By.cssSelector("div[id='center_column'] a[class='product-name']"));
//
//        System.out.println(products.size());
//        for (int i=0; i<products.size(); i++){
//
//            String prodName = products.get(i).getText();
//
//            if(prodName.contains("ress")){
//
//                //driver.findElements(By.cssSelector("a[class*='ajax_add_to_cart_button']")).get(i).click();
//            }
//
//        }

    }

}
// https://rahulshettyacademy.com/AutomationPractice/

// https://rahulshettyacademy.com/seleniumPractise/#/

