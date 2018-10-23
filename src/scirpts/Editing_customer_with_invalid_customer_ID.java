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

import page_objects.Guru99_Bank_Edit_Customer_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Editing_customer_with_invalid_customer_ID {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Editing_customer_with_invalid_customer_IDs() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		Boolean log_out_text = ManagerHomePage.log_out_text().isDisplayed();
		// Checking if the test case is passed or failed
		Assert.assertTrue(log_out_text);
		ManagerHomePage.Edit_Customer().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Edit_Customer_Page

		Guru99_Bank_Edit_Customer_Page EditCustomerPage = new Guru99_Bank_Edit_Customer_Page(driver);
		// Entering non existing or invalid customer
		EditCustomerPage.Customer_ID().sendKeys("111");
		EditCustomerPage.Submit().click();
		String Alert_message = driver.switchTo().alert().getText();
		Thread.sleep(10000);
		driver.switchTo().alert().accept();
		System.out.println(Alert_message);
		Assert.assertEquals(Alert_message, "Customer does not exist!!");
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
