package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebtableRail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("ms");
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.TAB);

		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("mdu");
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);

		driver.findElement(By.id("chkSelectDateOnly")).click();


		//Dynamic table first column values n all the rows
		int rowCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]")).size();
		List<String> Trainlist = new ArrayList<String>();
		Set<String> Trainset = new HashSet<String>();

		//int colCount = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td")).size();
		for (int i = 1; i <= rowCount; i++) 
			//for (int j = 1; j <= colCount; j++)
			{
			String text = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td["+i+"]")).getText();
			Trainlist.add(text);
		}

		Trainset.addAll(Trainlist);

		if (Trainset.size()== Trainlist.size())
		{
			System.out.println("No duplicates exists");
		}
		else
		{
			System.out.println("Duplicates Exists");
		}

	}


	//		int colCount = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td")).size();
	//		for (int i = 1; i <= rowCount; i++)
	//			for (int j = 1; j <= colCount; j++) {
	//				
	//				String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td["+j+"]")).getText();
	//				System.out.println(text);





}




