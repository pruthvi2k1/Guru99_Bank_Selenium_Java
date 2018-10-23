package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;
import page_objects.Guru99_Bank_Delete_Account_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Delete_Account {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Delete_Accounts() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Delete_Account().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Delete_Account_Page

		Guru99_Bank_Delete_Account_Page DeleteAccountPage = new Guru99_Bank_Delete_Account_Page(driver);
		DeleteAccountPage.Account_No().sendKeys("11069");
		DeleteAccountPage.submit().click();
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().accept();
		String message1 = driver.switchTo().alert().getText();
		System.out.println(message1);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Assert.assertEquals("Account Deleted Sucessfully", message1);
	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
