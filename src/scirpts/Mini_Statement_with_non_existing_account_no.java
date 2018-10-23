package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_Bank_Mini_Statement_Page;
import page_objects.Guru99_bank_login_page;

public class Mini_Statement_with_non_existing_account_no {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Mini_Statements() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Mini_Statement().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Mini_Statement_Page

		Guru99_Bank_Mini_Statement_Page MiniStatementPage = new Guru99_Bank_Mini_Statement_Page(driver);
		MiniStatementPage.Account_No().sendKeys("11");
		MiniStatementPage.Submit().click();
		String success = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(success);
		Assert.assertEquals("Account does not exist", success);

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
