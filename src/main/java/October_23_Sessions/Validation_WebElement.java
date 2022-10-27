package October_23_Sessions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Validation_WebElement {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rediff.com");
		//url validation
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String ActualCurrentUrl = "https://www.rediff.com/";
		String ActualTitle = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
		String ExpectedCurrentUrl = driver.getCurrentUrl();
		String ExpectedTitle = driver.getTitle();

		if(ActualTitle.equals(ExpectedTitle) && ActualCurrentUrl.equals(ExpectedCurrentUrl)){
		System.out.println("My url is correct");
		}else {
		System.out.println("My url is not correct");
		}

		WebElement signinLink = driver.findElement(By.className("signin"));
		if(signinLink.isEnabled() == true && signinLink.isDisplayed() == true) {
		signinLink.click();
		}else {
		System.out.println("The link is not working");
		}

		WebElement usernameTextBox = driver.findElement(By.id("login1"));
		if(usernameTextBox.isEnabled() == true && usernameTextBox.isDisplayed() == true) {
		usernameTextBox.sendKeys("seleniumpanda@rediffmail.com");
		}else {
		System.out.println("The username textbox field is not enabled or displayed");
		}

		WebElement passwordTextBox = driver.findElement(By.id("password"));
		if(passwordTextBox.isEnabled() == true && passwordTextBox.isDisplayed() == true) {
		passwordTextBox.sendKeys("Selenium@123");
		}else {
		System.out.println("The password textbox field is not enabled or displayed");
		}

		WebElement signinButton = driver.findElement(By.name("proceed"));
		if(signinButton.isEnabled() == true && signinButton.isDisplayed() == true) {
		signinButton.click();
		}else {
		System.out.println("The button is not enabled or displayed");
		}

		WebElement logOutLink = driver.findElement(By.className("rd_logout"));
		if(logOutLink.isEnabled() == true && logOutLink.isDisplayed() == true) {
		logOutLink.click();
		}else {
		System.out.println("The logout link is not enabled or displayed");
		}

		WebElement successfulSignOutMessage = driver.findElement(By.xpath("//p[contains(text(), 'You have successfully signed out of Rediffmail.')]"));
		if(successfulSignOutMessage.isDisplayed() == true) {
		System.out.println("Successful signout");
		}else {
		System.out.println("Not a success");
		}

		WebElement RediffHomePageLink = driver.findElement(By.xpath("//b[contains(text(), 'Rediff Home')]"));
		if(RediffHomePageLink.isEnabled() == true && RediffHomePageLink.isDisplayed() == true) {
		RediffHomePageLink.click();
		}else {
		System.out.println("The homepage link  is not enabled or displayed");
		}
	}

}
