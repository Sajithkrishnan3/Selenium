package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {

	public static void main(String[] args) {
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']")));
	    closeButton.click();
	  
		WebElement searchItem = driver.findElement(By.name("q"));
		searchItem.sendKeys("ADIDAS ADIZERO SL Running Shoes For Men");
		
		WebElement clickSrchBtn = driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']"));
		clickSrchBtn.click();
		
		  
//		WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable("By.xpath("(//a[contains(@href,'itma9cc05829bfac')])[2]")));
//		selectProduct.click();
		
//		WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'itma9cc05829bfac')])[1]")));
//        selectProduct.click();
//		
//		WebElement select = driver.findElement(By.xpath("(//a[@class='atJtCj' and @title='ADIZERO SL Running Shoes For Men'])[1]"));
//		select.click();
//		
//		
//		
//		String parentWindow = driver.getWindowHandle();
//
//		driver.findElement(
//		    By.xpath("(//a[@title='ADIZERO SL Running Shoes For Men'])[1]")
//		).click();
//
//		Set<String> windows = driver.getWindowHandles();
//
//		for (String window : windows) {
//		    if (!window.equals(parentWindow)) {
//		        driver.switchTo().window(window);
//		        break;
//		    }
//		}
		
		String parentWindow = driver.getWindowHandle();

		WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'itma9cc05829bfac')])[2]")));
		selectProduct.click();
		
		wait.until(d -> d.getWindowHandles().size() > 1);
		for (String window : driver.getWindowHandles()) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        break;
	   }
		}
		
		
		
		
		
	
	}

}
