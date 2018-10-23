package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Customer_Registration_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_Bank_New_Customer_Entry_Page;
import page_objects.Guru99_bank_login_page;

public class Creating_new_cutomer {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Creating_new_cutomers() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.New_Customer().click();

		// Guru99_Bank_New_Customer_Entry_Page

		// Creating new customer account by filling the form
		Guru99_Bank_New_Customer_Entry_Page NewCustomerEntryPage = new Guru99_Bank_New_Customer_Entry_Page(driver);
		NewCustomerEntryPage.Customer_Name().sendKeys("customerone");
		NewCustomerEntryPage.Gender().click();
		NewCustomerEntryPage.Date_of_Birth().sendKeys("11.11.1111");
		NewCustomerEntryPage.Address().sendKeys("address");
		NewCustomerEntryPage.City().sendKeys("city");
		NewCustomerEntryPage.State().sendKeys("state");
		NewCustomerEntryPage.PIN().sendKeys("111111");
		NewCustomerEntryPage.Mobile_Number().sendKeys("1111111111");
		NewCustomerEntryPage.E_mail().sendKeys("customerone3326@example.com");
		NewCustomerEntryPage.Password().sendKeys("password");
		Thread.sleep(10000);
		NewCustomerEntryPage.Submit().click();

		// Guru99_Bank_Customer_Registration_Page

		Guru99_Bank_Customer_Registration_Page CustomerRegistrationPage = new Guru99_Bank_Customer_Registration_Page(
				driver);
		String success = CustomerRegistrationPage.successmessage1().getText();

		boolean success_text = success.equalsIgnoreCase("Customer Registered Successfully!!!");
		Assert.assertTrue(success_text);
		Thread.sleep(10000);
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
