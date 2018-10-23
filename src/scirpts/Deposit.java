package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Amount_Deposit_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Deposit {
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
	public void Creating_new_accounts() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr156657", "vAhEsEs");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Deposit().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Amount_Deposit_Page

		Guru99_Bank_Amount_Deposit_Page AmountDepositPage = new Guru99_Bank_Amount_Deposit_Page(driver);
		AmountDepositPage.Account_No().sendKeys("11070");
		AmountDepositPage.Amount().sendKeys("100");
		AmountDepositPage.Description().sendKeys("depositing my money");
		AmountDepositPage.Submit().click();
		String success = AmountDepositPage.success().getText();
		System.out.println(driver.getTitle());
		System.out.println(success);
		Assert.assertEquals(success, "Transaction details of Deposit for Account 11070");
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
