package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();
		
        driver.get("http://127.0.0.1:5500/Alert.html");
        
        driver.findElement(By.id("alertButton")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

	}

}
