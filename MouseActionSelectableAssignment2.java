package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionSelectableAssignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);		
		
		WebElement Item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement Item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement Item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		// WebElement dropelement = driver.findElement(By.id("draggable"));
		
		Actions drag= new Actions(driver);
		drag.moveToElement(Item1).click().keyDown(Keys.CONTROL).moveToElement(Item3).click().moveToElement(Item4).click().keyUp(Keys.CONTROL).perform();
				
		

	}

}
