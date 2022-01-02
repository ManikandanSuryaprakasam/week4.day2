package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAuiMouseActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Create objects actions
		
		Actions builder = new Actions(driver);
		
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		
		//Mouse Over
		builder.moveToElement(men).perform();
		
		//Right Click
		builder.contextClick(men).perform();
		
		//Double Click
		builder.doubleClick(men).perform();
		
		
	}

}
