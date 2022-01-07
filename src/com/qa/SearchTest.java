package com.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest {

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