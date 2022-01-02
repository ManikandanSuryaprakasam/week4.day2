package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAuiSnapdealMouseOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
				
		//Mouse over the Mens Fashion and Click the Shirts	
		WebElement MensFashion = driver.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct ']/span[contains(text(),'Men')][contains(text(),'Fashion')]"));
		WebElement Shirts = driver.findElement(By.xpath("//span[contains(text(),'Shirts')][@class='linkTest']/parent::a[@href='https://www.snapdeal.com/products/men-apparel-shirts']"));
		
 
//		Click the Quickview button after mouse over
		Actions builder = new Actions(driver);
		builder.moveToElement(MensFashion).pause(1000).click(Shirts).perform();
		
		WebElement Photohover = driver.findElement(By.xpath("(//span[@class='animated-icon'])[1]"));
		builder.moveToElement(Photohover).perform();
		
		WebElement Quickview = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		Quickview.click();		
				
		

	}

}
