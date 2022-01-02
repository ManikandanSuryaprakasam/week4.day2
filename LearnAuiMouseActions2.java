package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAuiMouseActions2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Create objects actions
		
		Actions builder = new Actions(driver);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Point newpoint = drag.getLocation();
		
		//Drag and drop
		builder.dragAndDrop(drag,drop).perform();
		
		//Drag and drop in xy offset
		Point changepoint = drag.getLocation();	
		int xoffset = changepoint.getX() - newpoint.getX();
		int yoffset = changepoint.getY() - newpoint.getY();
		
		if (xoffset ==0 && yoffset==0 )
		{
			System.out.println("Dragged");
		}
		else
		System.out.println("Dragged");
		
		
		
//		builder.dragAndDropBy(drag,100,150).perform();
		
		
		
		
	}

}
