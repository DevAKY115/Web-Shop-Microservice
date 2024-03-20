package com.berkan.microservice.webscraperservice.product;

import com.berkan.microservice.webscraperservice.Websites.Caseking;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class ProductService {


    protected Product grabInformation(String url){

        String website = getWebsite(url);

/*        if(website == null){
            return new Product();
        }*/

        switch (website){
            case "caseking":
                Caseking caseking = new Caseking();
                caseking.scrapeProduct(url);
                return caseking;
        }



        return null;
    }

    protected String getWebsite(String urlString){
        try {
            URL url = new URL(urlString);

            String host = url.getHost();
            host = host.substring(host.indexOf('.') + 1);
            host = host.substring(0, host.indexOf('.'));

            return host;

        } catch (MalformedURLException e){
            System.out.println("Couldn't generate URL from urlString");
        }

        return null;
    }
}
