package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionDragAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);		
		
		WebElement dragelement = driver.findElement(By.id("draggable"));
		// WebElement dropelement = driver.findElement(By.id("draggable"));
		
		Actions drag= new Actions(driver);
		drag.moveToElement(dragelement).clickAndHold().moveByOffset(174, 58).click().release().perform();
				
		

	}

}
