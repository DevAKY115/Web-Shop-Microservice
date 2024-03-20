package com.berkan.microservice.webscraperservice.Websites;

import com.berkan.microservice.webscraperservice.product.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Caseking extends Product implements Shop {
    @Override
    public Product scrapeProduct(String url) {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-data-dir=C:\\Users\\B\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        //options.addArguments("--headless");

        ChromeDriver driver = new ChromeDriver();
        driver.get(url);

        scrapePrice(driver);
        scrapeName(driver);
        scrapeImage(driver);
        setUrl(url);
        System.out.println(url);

        driver.quit();

        return this;
    }

    @Override
    public void scrapePrice(WebDriver driver) {
        String price = driver.findElement(By.className("article_details_price")).getText();

        price = price.substring(0, price.length()-2);
        price = price.replace(',', '.');

        setPrice(Double.parseDouble(price));

    }


    @Override
    public void scrapeName(WebDriver driver) {
        String name = driver.findElement(By.tagName("h1")).getText();
        name = name.substring(name.indexOf("\n")+1, name.length());

        setName(name);
    }

    @Override
    public void scrapeImage(WebDriver driver) {

    }
}
