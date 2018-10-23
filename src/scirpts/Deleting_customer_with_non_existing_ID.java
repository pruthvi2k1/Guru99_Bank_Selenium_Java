package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Delete_Customer_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Deleting_customer_with_non_existing_ID {
	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Deleting_customers() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Delete_Customer().click();

		// Guru99_Bank_Delete_Customer_Page

		Guru99_Bank_Delete_Customer_Page DeleteCustomerPage = new Guru99_Bank_Delete_Customer_Page(driver);
		DeleteCustomerPage.Customer_ID().sendKeys("82372");
		DeleteCustomerPage.Submit().click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		String popup_message = driver.switchTo().alert().getText();
		System.out.println(popup_message);
		driver.switchTo().alert().accept();
		Assert.assertEquals(popup_message, "Customer does not exist!!");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
