package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//click
		driver.findElement(By.xpath("//span[contains(text(),'Fashion')][contains(text(),'Men')][@class='catText']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]")).click();
		//		

		//gettext
		String text = driver.findElement(By.xpath("//div[contains(text(),'Sports Shoes for Men')]/following-sibling::div")).getText();
		System.out.println("Total count of Shoes ");


		//Click
		driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click();				

       
		WebElement price = driver.findElement(By.xpath("//ul[contains(@class,'sort-value hidden')]"));
		Select ddlprice = new Select(price);
		ddlprice.selectByIndex(2);
		
		String text2 = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div")).getText();
		int total = Integer.valueOf(text2);
		Actions scroll =  new Actions(driver);
		WebElement Yesbutton = driver.findElement(By.xpath("//span[@class='btn-yes js-yesFeedback']"));
		
		for (int i = total/20; i >= 1; i--) {
					
		scroll.moveToElement(Yesbutton).perform();
		
		}
		
		
		



	}

}
