package com.SpeerAssessment.Wikipedia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikipediaHomepage {

	WebDriver wd;
	WebDriverWait wait;
	String url = "https://www.wikipedia.or/";

	@Test
	public void verifyHomepage() {
		/*
		 * Using WebDriverManager API to detect current browser version to setup
		 * WebDriver
		 */
		WebDriverManager.chromedriver().setup();

		// Intantiate Webdriver with the constructor of chromeDriver Class
		wd = new ChromeDriver();

		// Navigate to homepage if URL is correct
		if (url.equals("https://www.wikipedia.org/")) {
			wd.get("https://www.wikipedia.org/");
			wait = new WebDriverWait(wd, 10);

			wd.manage().window().maximize();

			List<WebElement> footerLinks = wd
					.findElements(By.cssSelector("div[class='footer'] div[class='other-projects'] div a[href"));
			System.out.println("No. of links present :" + footerLinks.size());
			for (int i = 0; i < footerLinks.size(); i++) {
				System.out.println("Link: " + i + " URL: " + footerLinks);
			}
		} else {
			System.out.println("Please use correct url");
		}

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}