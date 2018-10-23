package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Customer_Registration_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_add_new_account_page;
import page_objects.Guru99_bank_login_page;

public class Creating_new_account {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Creating_new_accounts() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.New_Account().click();
		System.out.println(driver.getTitle());
		int savings = 0;
		int current = 1;
		Create_Account(savings);
		ManagerHomePage.New_Account().click();
		Create_Account(current);

	}

	public void Create_Account(int type) throws InterruptedException {

		// Guru99_bank_add_new_account_page

		Guru99_bank_add_new_account_page addnewaccountpage = new Guru99_bank_add_new_account_page(driver);
		addnewaccountpage.Customer_id().sendKeys("32114");
		Select account_type = new Select(addnewaccountpage.Account_type());
		account_type.selectByIndex(type);
		addnewaccountpage.Initial_deposit().sendKeys("500");
		addnewaccountpage.submit().click();
		System.out.println("now title is  " + driver.getTitle());
		Thread.sleep(5000);

		// Title is Gtpl Bank Customer Registration Page but We will use
		// Guru99_Bank_Customer_Registration_Page
		// Guru99_Bank_Customer_Registration_Page

		Guru99_Bank_Customer_Registration_Page CustomerRegistrationPage = new Guru99_Bank_Customer_Registration_Page(
				driver);
		String success = CustomerRegistrationPage.successmessage3().getText();
		System.out.println(success);
		Assert.assertEquals(success, "Account Generated Successfully!!!");
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
