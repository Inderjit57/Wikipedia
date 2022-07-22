package com.SpeerAssessment.Wikipedia;

import java.util.List;
import java.util.Random;

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
	String url = "https://en.wikipedia.org/wiki/Schitt%27s_Creek";
	Random random = new Random();
	int counter;

	@Test
	public void verifyHomepage() throws Exception {
		/*
		 * Using WebDriverManager API to detect current browser version to setup
		 * WebDriver
		 */
		WebDriverManager.chromedriver().setup();

		// Intantiate Webdriver with the constructor of chromeDriver Class
		wd = new ChromeDriver();

		// Step:1 Accepts a Wikipedia link - return/throw an error if the link is not a
		// valid wiki link

		if (url.contains("https://en.wikipedia.org/wiki/Schitt%27s_Creek")) {
			wd.get(url);
			wait = new WebDriverWait(wd, 10);
			wd.manage().window().maximize();

			counter = random.nextInt(6);

			// Storing all the links in a List using findElements
			List<WebElement> wikiLinkList = wd.findElements(By.xpath("//a[contains(@href,'wikipedia')]"));
			System.out.println("No. of links present on this webpage :" + wikiLinkList.size());

			for (WebElement i : wikiLinkList) {
				System.out.println("Wikipedia Link: " + i.getAttribute("href"));

			}

		} else {
			throw new Exception("Not a valid wiki link");
		}

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
