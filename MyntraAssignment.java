package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.jna.IntegerType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver =new ChromeDriver(options);

		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement Men = driver.findElement(By.xpath("//a[@data-group='men']"));
		Actions men = new Actions(driver);
		men.moveToElement(Men).perform();
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		String titlecount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println(titlecount);
		titlecount = titlecount.replaceAll("[-\\sa-zA-Z]","");
		int temp1 = Integer.parseInt(titlecount);
		List<WebElement> catTotal = driver.findElements(By.xpath("//span[@class='categories-num']"));
		int sum = 0;
		int temp2 =0;
		for (WebElement webElement : catTotal) {

			String text = webElement.getText();
			text= text.replaceAll("[()]","");
			temp2 = Integer.parseInt(text);
			sum = sum + temp2;

		}

		if(sum==temp1)
		{
			System.out.println("Counts are equal");
		}

		else
		{
			System.out.println("Total count:"+temp1);
			System.out.println("Sub count:"+sum);
		}


		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//input[@type='checkbox'][@value='Duke']/following::div[@class='common-checkboxIndicator'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

		String xpath = "//h3[@class='product-brand']";
		List<WebElement> brands = driver.findElements(By.xpath(xpath)); 
		System.out.println(brands.size());

		String nextxpath = "//a[@rel='next']";
		boolean displayed = driver.findElement(By.xpath(nextxpath)).isDisplayed();
		System.out.println(displayed);
		
		do
		{
			
						
					for (WebElement webElement : brands) 
					{
						if (webElement.getText().equals("Duke"))
						{
							System.out.println("brand is  Duke");
						}
						else
						{
							System.out.println("brand is not Duke");
							
						}
		
						driver.findElement(By.xpath(nextxpath)).click();
					}
		}
		while(displayed == true);
							
	}}
