package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(brand).perform();		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		driver.getTitle();
		driver.findElement(By.xpath("//span[contains(text(),'Sort By : popularity')]/parent::button")).click();
		driver.findElement(By.xpath("//label[contains(@for,'radio_customer')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//label[contains(@for,'checkbox_Color Protection')]")).click();
		boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'Shampoo')][@class='filter-value']")).isDisplayed();
		if(displayed)
			System.out.println("Filtered by Shampoo");
		else
			System.out.println("Not filtered by shampoo");
		
		WebElement img = driver.findElement(By.xpath("(//img[contains(@alt,'Oreal Paris Colour Protect Shampoo')])[1]"));
		img.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handllist = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handllist.get(1));
		WebElement ddlsize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select select = new Select(ddlsize);
		select.selectByVisibleText("175ml");
		String text = driver.findElement(By.xpath("//h1[contains(text(),'Paris Colour Protect Shampoo')]/following-sibling::span[2]")).getText();
		System.out.println("MRP rate:"+text);
		
		WebElement Addbutton = driver.findElement(By.xpath("(//span[@class='btn-text'])[1]/parent::button"));
		mouse.moveToElement(Addbutton).click().perform();
		
		driver.findElement(By.xpath("//span[contains(@class,'cart-count')]")).click();
		WebElement framecart = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(framecart);
		String text2 = driver.findElement(By.xpath("//div[@class='payment-tbl-data']//div[@class='value medium-strong']")).getText();
		text2 = text2.replaceAll("[^0-9]","" );
		System.out.println("Grand Total:"+text2);
		driver.findElement(By.xpath("//button[contains(@class,'proceed' )]")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String text3 = driver.findElement(By.xpath("(//div[@class='value']/span)[2]")).getText();
		System.out.println(text3);
		if (text2.equals(text3))
		{
			System.out.println("Both amounts are equal");
		}
		else
		{
			System.out.println(" Amounts are not equal");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
