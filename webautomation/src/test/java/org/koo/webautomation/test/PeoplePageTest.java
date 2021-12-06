package org.koo.webautomation.test;

import org.koo.webautomation.pages.PeoplePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PeoplePageTest {

	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testPeopleCategory() throws InterruptedException {
		PeoplePageClass peoplePageClass = new PeoplePageClass(driver);
		peoplePageClass.navigateToUrl("https://www.kooapp.com/people");
		peoplePageClass.getProfileUrl();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Closing the browser ");
		driver.close();
	}
}
