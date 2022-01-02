package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionSortableAssignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);		


		List<Point> newpoint = new ArrayList<Point>();
		ArrayList<ArrayList<Integer>> pointxy = new ArrayList<ArrayList<Integer>>();
		List<WebElement> Items = driver.findElements(By.xpath("//li[contains(text(),'Item')]"));

		//Get location of elements
		for (WebElement it:Items) {
			//						
			Point location = it.getLocation();
			newpoint.add(location);
			System.out.println("XY locations:"+location.getX()+" "+location.getY());

		}

		Actions drag= new Actions(driver);

		//Drag and drop the elements in descending order works in 1920*960 resolutions
		int size = Items.size()-1;
		for (WebElement webElement : Items) {


			if(size >= 0) {
				drag.clickAndHold(webElement).moveByOffset(newpoint.get(size).getX(), newpoint.get(size).getY()).click().release().perform();
			}
			size =size-1;


		}


	}


}


