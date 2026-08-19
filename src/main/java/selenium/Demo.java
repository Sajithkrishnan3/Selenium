package selenium;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws IOException {
		
		
		//Handling Inputs:
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://127.0.0.1:5500/index.html");
		
		WebElement enterName = driver.findElement(By.id("fname"));
		enterName.sendKeys("Sajith");
		
		WebElement clearText = driver.findElement(By.id("fname"));
		clearText.clear();
		
		WebElement getTexts = driver.findElement(By.id("loginBtn"));
		String text = getTexts.getText();
		System.out.println(text);
	
		
		WebElement getAttributes = driver.findElement(By.id("registerBtn"));
		String text2 = getAttributes.getAttribute("id");
		System.out.println(text2);
		
		WebElement clickButton = driver.findElement(By.id("loginBtn"));
		clickButton.click();
		
		
		//Handling button
		
	          WebElement button = driver.findElement(By.id("registerBtn"));
              System.out.println(button.isEnabled());
              
              
		        WebElement displaybutton = driver.findElement(By.id("registerBtn"));
		        System.out.println(displaybutton.isDisplayed());
		        
		        
		        TakesScreenshot ts = (TakesScreenshot) driver;
		        File src = ts.getScreenshotAs(OutputType.FILE);
		        
		     File dest = new File("/Users/sajith/Desktop/HomePageimage4.png");

		        Files.copy(src.toPath(), dest.toPath());

		        System.out.println("Screenshot saved successfully!");
		        
		        
		        //Alert

		        driver.findElement(By.id("alertButton")).click();

		        Alert al = driver.switchTo().alert();

		        System.out.println(al.getText());

		        al.accept();


		        driver.findElement(By.id("confirmButton")).click();

		        Alert al1 = driver.switchTo().alert();

		        System.out.println(al1.getText());

		        al1.dismiss();


		        driver.findElement(By.id("promptButton")).click();

		        Alert al2 = driver.switchTo().alert();

		        System.out.println(al2.getText());

		        al2.sendKeys("Sajith");

		        al2.accept();
              


              
		
		
		
		
		
	//navigation comnands
		driver.get("https://www.google.com");
		
		driver.navigate().to("http://127.0.0.1:5500/index.html");
		
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
