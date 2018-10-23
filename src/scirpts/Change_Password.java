package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_objects.Guru99_Bank_Balance_Enquiry_Page;
import page_objects.Guru99_Bank_Change_password_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Change_Password {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Change_Passwords() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Change_Password().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_New_Customer_Entry_Page is the title
		// but we use Guru99_Bank_Change_password_Page

		Guru99_Bank_Change_password_Page ChangepasswordPage = new Guru99_Bank_Change_password_Page(driver);
		ChangepasswordPage.Old_Password().sendKeys("pYgubuz");
		ChangepasswordPage.New_Password().sendKeys("pYgubuz");
		ChangepasswordPage.Confirm_Password().sendKeys("pYgubuz");
		ChangepasswordPage.Submit().click();

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
