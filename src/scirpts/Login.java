package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Login {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Owner/selenium/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/bin/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void login_test() {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr156657", "vAhEsEs");

		// Guru99_Bank_Manager_HomePage

		Boolean log_out_text = ManagerHomePage.log_out_text().isDisplayed();

		// Checking if the test case is passed or failed
		Assert.assertTrue(log_out_text);

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
