package com.raquibul.quickstartall.selenium.sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSikuliWithSeleniumTest {
	private static WebDriver driver = null;
	private static final String CHROME_DRIVER = "C:/Users/raquibul.hasan/Documents/Softwares/chromeDriver/chromedriver.exe";
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		driver = new ChromeDriver();
	}
	
	@Test
	public void  testGoogleSearch() throws InterruptedException, FindFailed {
		driver.get("http://www.google.com"); //open the google page
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000); //give some time for the google page to fully load
		
		Screen screen = new Screen();
		Pattern imageSearch = new Pattern(
				"src/main/resources/images/google-search.png");

		// Wait 10ms for image 
		screen.wait(imageSearch, 2); //wait for 10 ms until the image is opened
		screen.click(imageSearch);
		screen.type("Sikuli"); //The text to search
		Thread.sleep(2000); //just give some time so that you can see the action in slow motion :)
		screen.type(Key.ENTER); //press the enter key
		
		Thread.sleep(2000); //wait for 2ms before exiting the testcase
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
		//any other cleanup work goes here
	}
}
