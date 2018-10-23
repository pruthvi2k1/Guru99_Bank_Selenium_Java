package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Customised_Statement_Page;
import page_objects.Guru99_Bank_Fund_Transfer_Entry_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Fund_Transfer_with_non_existing_accunt_no {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Fund_Transfer_with_non_existing_accunt_nos() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Fund_Transfer().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Fund_Transfer_Entry_Page

		Guru99_Bank_Fund_Transfer_Entry_Page FundTransferEntryPage = new Guru99_Bank_Fund_Transfer_Entry_Page(driver);
		FundTransferEntryPage.Payers_account_no().sendKeys("11");
		FundTransferEntryPage.Payees_account_no().sendKeys("12");
		FundTransferEntryPage.Amount().sendKeys("100");
		FundTransferEntryPage.Description().sendKeys(" money ");
		FundTransferEntryPage.Submit().click();
		String success = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		System.out.println(success);
		Assert.assertEquals(success, "Account 11does not exist!!!");
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
