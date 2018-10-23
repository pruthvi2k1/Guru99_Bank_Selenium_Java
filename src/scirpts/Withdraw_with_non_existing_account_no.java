package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Amount_Withdrawal_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Withdraw_with_non_existing_account_no {

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
	public void Withdraw_with_non_existing_account_nos() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr156657", "vAhEsEs");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Withdrawal().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Amount_Withdrawal_Page

		Guru99_Bank_Amount_Withdrawal_Page AmountWithdrawalPage = new Guru99_Bank_Amount_Withdrawal_Page(driver);
		AmountWithdrawalPage.Account_No().sendKeys("11");
		AmountWithdrawalPage.Amount().sendKeys("50");
		AmountWithdrawalPage.Description().sendKeys("withdrawing money");
		AmountWithdrawalPage.Submit().click();
		String Message = driver.switchTo().alert().getText();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		System.out.println(Message);
		Assert.assertEquals(Message, "Account does not exist");
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
