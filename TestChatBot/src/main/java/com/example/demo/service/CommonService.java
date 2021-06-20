package com.example.demo.service;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonService {

	protected WebDriver initDriver() {

		WebDriverManager.chromedriver().setup();
		File profile = new File("src/main/resources/profile");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--user-data-dir=" + profile.getAbsolutePath());

		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	protected void sleep(Long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
