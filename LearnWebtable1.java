package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebtable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	
		
		//Dynamic table first column values n all the rows
		int rowCount = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td")).size();
		for (int i = 1; i <= rowCount; i++)
			for (int j = 1; j <= colCount; j++) {
				
				String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td["+j+"]")).getText();
				System.out.println(text);
				
			}
		


	}

}


