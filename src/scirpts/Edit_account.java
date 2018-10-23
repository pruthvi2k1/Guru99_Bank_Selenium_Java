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
import page_objects.Guru99_Bank_Edit_Account_Entry_Page;
import page_objects.Guru99_Bank_Edit_Account_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Edit_account {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Edit_accounts() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Edit_Account().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Edit_Account_Page

		Guru99_Bank_Edit_Account_Page EditAccountPage = new Guru99_Bank_Edit_Account_Page(driver);
		EditAccountPage.Account_No().sendKeys("11064");
		EditAccountPage.Submit().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Edit_Account_Entry_Page

		Guru99_Bank_Edit_Account_Entry_Page EditAccountEntryPage = new Guru99_Bank_Edit_Account_Entry_Page(driver);
		Select dropdown = new Select(EditAccountEntryPage.Type_of_Account());
		dropdown.selectByIndex(1);
		Thread.sleep(5000);
		EditAccountEntryPage.Submit().click();
		System.out.println(driver.getTitle());

		// Gtpl Bank Customer Registration Page
		// We will use Guru99_Bank_Customer_Registration_Page

		Guru99_Bank_Customer_Registration_Page CustomerRegistrationPage = new Guru99_Bank_Customer_Registration_Page(
				driver);
		String success = CustomerRegistrationPage.success4().getText();
		System.out.println(success);
		Assert.assertEquals(success, "Account details updated Successfully!!!");

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
