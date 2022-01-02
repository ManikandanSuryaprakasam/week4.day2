package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAuiMouseActions3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Create objects actions
		
		Actions builder = new Actions(driver);
		
		WebElement Element1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement Element2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement Element3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
//WebElement Element4 = driver.findElement(By.id("//li[text()='Item 4']"));
		
		
		
		//To select CTR+Items
		builder.keyDown(Keys.CONTROL).click(Element1)
		.click(Element2).click(Element3).keyUp(Keys.CONTROL).perform();
		
		
		
				
		
		
	}

}
