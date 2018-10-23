package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Balance_Enquiry_Page;
import page_objects.Guru99_Bank_Customised_Statement_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_Bank_Statement_Page;
import page_objects.Guru99_bank_login_page;

public class Customised_Statement_with_non_existing_account_no {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Customised_Statement_with_non_existing_account_nos() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Customised_Statement().click();

		// Guru99_Bank_Statement_Page

		Guru99_Bank_Statement_Page StatementPage = new Guru99_Bank_Statement_Page(driver);
		StatementPage.Account_No().sendKeys("11");
		StatementPage.From_Date().sendKeys("13.02.2016");
		StatementPage.To_Date().sendKeys("15.02.2016");
		StatementPage.Minimum_Transaction_Value().sendKeys("50");
		;
		StatementPage.Number_of_Transaction().sendKeys("3");
		StatementPage.Submit().click();
		Thread.sleep(3000);
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().accept();
		Assert.assertEquals(message, "Account does not exist");

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
