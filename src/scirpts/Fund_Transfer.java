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

public class Fund_Transfer {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Fund_Transfers() throws InterruptedException {

		// Guru99_bank_login_page
		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Fund_Transfer().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Fund_Transfer_Entry_Page

		Guru99_Bank_Fund_Transfer_Entry_Page FundTransferEntryPage = new Guru99_Bank_Fund_Transfer_Entry_Page(driver);
		FundTransferEntryPage.Payers_account_no().sendKeys("11070");
		FundTransferEntryPage.Payees_account_no().sendKeys("11069");
		FundTransferEntryPage.Amount().sendKeys("100");
		FundTransferEntryPage.Description().sendKeys(" money ");
		FundTransferEntryPage.Submit().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Customised_Statement_Page

		Guru99_Bank_Customised_Statement_Page CustomisedStatementPage = new Guru99_Bank_Customised_Statement_Page(
				driver);
		String success = CustomisedStatementPage.success().getText();
		System.out.println(success);
		Assert.assertEquals(success, "Fund Transfer Details");
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
