package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearntoExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
	   WebElement invisiblebtn = driver.findElement(By.id("btn"));
	   
	   WebDriverWait wait=   new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.invisibilityOf(invisiblebtn));
	   
	   WebElement text = driver.findElement(By.tagName("strong"));
	   System.out.println(text);

	}

}
