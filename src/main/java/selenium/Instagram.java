package selenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Instagram {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/?flo=true");
		
		WebElement enterUsername = driver.findElement(By.id("_R_32d9lplcldcpbn6b5ipamH1_"));
		enterUsername.sendKeys("7904706872");
		
		WebElement enterPassword = driver.findElement(By.id("_R_33d9lplcldcpbn6b5ipamH1_"));
		enterPassword.sendKeys("2Sajiinsta33");
		
		WebElement clickLogin = driver.findElement(By.cssSelector("div[aria-label='Log In'][role='button']"));
		clickLogin.click();
		
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	

  WebElement enterCode = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='email']")));
   enterCode.sendKeys("091711");
   
   WebElement continueButton = driver.findElement(By.xpath("//div[@role='button' and .//span[normalize-space()='Continue']]"));
	continueButton.click();
		
		
	}

}
