package com.berkan.microservice.webscraperservice.Websites;

import com.berkan.microservice.webscraperservice.product.Product;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface Shop {

    /**
     * Passes the url to a WebDriver and gathers the necessary information.
     * Returns an Item with the information filled in.
     * @param url
     * @return
     */
    Product scrapeProduct(String url);

    /**
     * Grabs the price of the product.
     * @param driver the WebDriver containing the product information.
     */
    void scrapePrice(WebDriver driver);



    /**
     * Grabs the name of the product.
     * @param driver the WebDriver containing the product information.
     */
    void scrapeName(WebDriver driver);

    /**
     * Grabs the name of the website from its url.
     * @param driver the WebDriver containing the product information.
     */
    void scrapeImage(WebDriver driver);


    /**
     * updates the price of the item
     * @param urlString URL of the item
     * @return the price of the item
     */
//    double updatePrice(String urlString);

}