package com.example.demo.service;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.example.demo.util.Constants;

public class UserService extends CommonService{

	public void sendMessage(String msg, String userId) {
		WebDriver driver = initDriver();
		
		login(driver);
		sleep(1000l);
		String url = Constants.URL_SEND_MESSAGE + userId;
		driver.get(url);
		sleep(1000l);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/div/form/div/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div")).sendKeys(msg, Keys.ENTER);
		sleep(2000l);
//		driver.findElement(By.xpath(""))
		driver.close();
	}
	
	public void login(WebDriver driver) {
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		if(title.matches("^(\\(.*\\) ){0,1}Facebook$")) {
			return;
		}
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Constants.USER_NAME);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Constants.PASS, Keys.ENTER);
//		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Constants.PASS);
		
		title = driver.getTitle();
		if(title.matches("^(\\(.*\\) ){0,1}Facebook$")) {
			System.out.println("Da Login");
		}
		
	}
}
