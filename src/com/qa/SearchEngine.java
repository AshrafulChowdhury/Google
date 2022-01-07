package com.qa;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SearchEngine {
	static WebDriver driver;

@BeforeMethod
	public void BrowserOpen() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mehir\\eclipse-workspace\\Google\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
@Test
public void SearchKeyword() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("AmEx");
		List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='G43f7e']//li"));
		System.out.println(searchResults.size());

		for(int i = 0; i < searchResults.size(); i++) {
			String searchIteams = searchResults.get(i).getText();
			if(searchIteams.contains("AmEx")) {
				searchResults.get(i).click();
				break;
			}
		}
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	
@Test
public void TotalLinkText() {
	List<WebElement> links = driver.findElements(By.tagName("a"));
	int linksCount = links.size();
	System.out.println("Total number of links in this page is = " + linksCount);
	for(int i = 0; i < linksCount; i++) {
		WebElement storage = links.get(i);
		String linksText = storage.getText();
		System.out.println(linksText);
	}
}


@Test
public void TotalLinkAttribute() {
	List<WebElement> listlink=driver.findElements(By.tagName("a"));
	System.out.println(listlink.size());
	for (int i=0; i<listlink.size();i++) {
		WebElement element = listlink.get(i);
		String url=element.getAttribute("href");
		System.out.println(url);
	}
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
}
