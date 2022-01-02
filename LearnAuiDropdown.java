package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

//Classroom3: http://leafground.com/pages/Dropdown.html select "Selenium" and "Loadrunner" from the multi select combo box using actions class

public class LearnAuiDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebElement Selenium = driver.findElement(By.xpath("//option[text()='Select your programs']/following::option[@value='1']"));
		WebElement UFT = driver.findElement(By.xpath("//option[text()='Select your programs']/following::option[@value='3']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(Selenium).keyDown(Keys.CONTROL).click().perform();
		builder.moveToElement(UFT).click().keyUp(Keys.CONTROL).perform();
		
		
		
		
		

	}

}
