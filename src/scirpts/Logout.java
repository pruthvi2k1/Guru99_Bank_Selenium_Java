package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Logout {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void logout_test() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr156657", "vAhEsEs");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.log_out_text().click();
		Thread.sleep(3000);
		String message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(message);
		// Checking if the test case is passed or failed
		Assert.assertEquals(message, "You Have Succesfully Logged Out!!");

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
