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

import page_objects.Guru99_Bank_Customer_Registration_Page;
import page_objects.Guru99_Bank_Edit_Customer_Entry_Page;
import page_objects.Guru99_Bank_Edit_Customer_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Editing_customer {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Editing_customers() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		Boolean log_out_text = ManagerHomePage.log_out_text().isDisplayed();
		Assert.assertTrue(log_out_text);
		// Checking if the test case is passed or failed
		ManagerHomePage.Edit_Customer().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Edit_Customer_Page

		Guru99_Bank_Edit_Customer_Page EditCustomerPage = new Guru99_Bank_Edit_Customer_Page(driver);
		// Entering already existing valid customer
		EditCustomerPage.Customer_ID().sendKeys("19614");
		EditCustomerPage.Submit().click();

		System.out.println(driver.getTitle());

		// Guru99_Bank_Edit_Customer_Entry_Page

		Guru99_Bank_Edit_Customer_Entry_Page EditCustomerEntry_Page = new Guru99_Bank_Edit_Customer_Entry_Page(driver);
		EditCustomerEntry_Page.Address().clear();
		EditCustomerEntry_Page.Address().sendKeys("adress is changing............ ");
		EditCustomerEntry_Page.Submit().click();

		// Guru99_Bank_Customer_Registration_Page

		Guru99_Bank_Customer_Registration_Page CustomerRegistrationPage = new Guru99_Bank_Customer_Registration_Page(
				driver);
		String success = CustomerRegistrationPage.successmessage2().getText();

		System.out.println(success);
		boolean success_text = success.equalsIgnoreCase("Customer details updated Successfully!!!");
		System.out.println(driver.getTitle());
		Assert.assertTrue(success_text);

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
