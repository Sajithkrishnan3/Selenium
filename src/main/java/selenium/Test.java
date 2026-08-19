package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Files;




public class Test {

	public static void main(String[] args) throws IOException {
		        WebDriver driver = new ChromeDriver();

//        driver.get("http://127.0.0.1:5500/index.html");
//        
//        WebElement firstName = driver.findElement(By.id("fname"));
//        firstName.sendKeys("Sajith");
//        
//        WebElement lastName = driver.findElement(By.name("lastname"));
//        lastName.sendKeys("Krishnan");
//        
//        WebElement email = driver.findElement(By.id("email"));
//        email.sendKeys("Sajith@gmail.com");
//        
//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("asdffaf");
//        
//        WebElement gender = driver.findElement(By.id("male"));
//        gender.click();
//        
////        WebElement selectCountry =driver.findElement(By.id("country"));
////        selectCountry.click();
        
        
        
        
        //Navigation Commands
//		        
//		        driver.get("https://www.google.com/");
//        
//        driver.navigate().to("https://www.flipkart.com/");
//        
//        
//        driver.navigate().back();
//        
//        driver.navigate().forward();
//        
//        driver.navigate().refresh();
		        
		        
		//Click 
//		driver.get("http://127.0.0.1:5500/index.html");
//		
//		WebElement Click = driver.findElement(By.id("loginBtn"));
//		Click.click();
		
		
		
//		driver.get("http://127.0.0.1:5500/index.html");
//		
//		WebElement getText = driver.findElement(By.id("registerBtn"));
//		String text = getText.getText();
//
//		System.out.println(text);
		        
		        
//			driver.get("http://127.0.0.1:5500/index.html");
//  
//		        WebElement button = driver.findElement(By.id("registerBtn"));
//
//		        System.out.println(button.isEnabled());
		        
//		        
//
//		        driver.get("http://127.0.0.1:5500/index.html");
//		        
//		        WebElement button = driver.findElement(By.id("registerBtn"));
//
//		        System.out.println(button.isDisplayed());
		        
        
        
        
   driver.get("http://127.0.0.1:5500/index.html");
       
   
   TakesScreenshot ts = (TakesScreenshot) driver;
   File src = ts.getScreenshotAs(OutputType.FILE);
   
File dest = new File("/Users/sajith/Desktop/HomePage.png");

   Files.copy(src.toPath(), dest.toPath());

   System.out.println("Screenshot saved successfully!");
  
        
	}

}
