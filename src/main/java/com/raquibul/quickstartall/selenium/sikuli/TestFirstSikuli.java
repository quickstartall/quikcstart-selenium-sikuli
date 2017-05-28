package com.raquibul.quickstartall.selenium.sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TestFirstSikuli {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/MyWork/raquibul-selenium-test/src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		try {
			Screen screen = new Screen();
			Pattern imageSearch = new Pattern(
					"src/main/resources/images/google-search.png");
			
			screen.wait(imageSearch, 2);
			screen.click(imageSearch);
			screen.type("Sikuli");
			Thread.sleep(2000);
			screen.type(Key.ENTER);
			Thread.sleep(2000);
			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close the browser
		driver.quit();
	}
	
	
	
}
