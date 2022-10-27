package October_23_Sessions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Facebook_Testing {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		driver.getTitle();
		String actualurl = "https://www.facebook.com/";
		String actualtitle = "Facebook - log in or sign up";
		String expectedurl = driver.getCurrentUrl();
		String expectedtitle = driver.getTitle();
		if(actualurl.equals(expectedurl) && actualtitle.equals(expectedtitle)){
		System.out.println("Your Url is Correct");
		System.out.println("Your title is Correct");
		}
		else {
		System.out.println("Your Url is not Correct");
		System.out.println("Your title is not Correct");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement createacc = driver.findElement(By.xpath("//a[text() = 'Create new account']"));
		System.out.println(createacc.isDisplayed());
		createacc.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//input[@id = 'u_j_b_4u']")).sendKeys("hello@gmail.com");
		WebElement firstname = driver.findElement(By.xpath("//input[@name = 'firstname']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name = 'lastname']"));


		firstname.isDisplayed();
		firstname.sendKeys("Syeda");
		lastname.sendKeys("Binte Salem");
		//email
		WebElement emailormobile = driver.findElement(By.xpath("//input[@name = 'reg_email__']"));
		emailormobile.sendKeys("nazidaisboss@gmail.com");
		//password
		WebElement password = driver.findElement(By.xpath("//input[@name = 'reg_passwd__']"));
		password.sendKeys("inshallah123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//input[id='yesRadio']
		 WebElement gender = driver.findElement(By.xpath("//label[text() = 'Female']"));
		 gender.click();
	}

}
