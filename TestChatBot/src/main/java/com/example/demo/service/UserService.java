package com.example.demo.service;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.example.demo.util.Constants;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CommonService{
    public void sendMessage(String msg, String userId){
        WebDriver webDriver = initDriver();
        login(webDriver);
        sleep(1000l);
        String url = Constants.URL_SEND_MESSAGE + userId;
        webDriver.get(url);
        sleep(1000l);
        webDriver.findElement(By.xpath("//*[@id=\"composerInput\"]")).sendKeys(msg);
        sleep(2000l);
        webDriver.findElement(By.xpath("//*[@id=\"composer_form\"]/table/tbody/tr/td[2]/input")).click();
        sleep(2000l);
        webDriver.close();
    }

    public void login(WebDriver webDriver){
        webDriver.get("https://www.facebook.com/");
        String title = webDriver.getTitle();
        if (title.matches("^(\\(.*\\) ){0,1}Facebook$")) {
            return;
        }
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Constants.USER_NAME);
        webDriver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Constants.PASS);
        webDriver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Keys.ENTER);

        title = webDriver.getTitle();
        if (title.matches("^(\\(.*\\) ){0,1}Facebook$")) {
            System.out.println("Da login");
        }
    }
}
