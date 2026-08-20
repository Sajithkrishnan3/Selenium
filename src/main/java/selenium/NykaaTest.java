package selenium;



import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class NykaaTest {

    public static void main(String[] args) throws InterruptedException {

        
        WebDriver driver = new ChromeDriver();
        

        driver.manage().window().maximize();
        

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        
                
        driver.get("https://www.nykaa.com/");

        System.out.println("Nykaa opened");


       
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search on Nykaa']")));

        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys("Kurtis");
        searchBox.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.urlContains("catalogsearch/result"));

        System.out.println("Search URL: " + driver.getCurrentUrl());

        //  Close notification popup

        try {

            WebElement noThanks = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[normalize-space()='No thanks']")));

            noThanks.click();

            System.out.println("Notification popup closed");

        } catch (Exception e) {

            System.out.println("No notification popup");
        }


        // Save Search Window

        String searchWindow = driver.getWindowHandle();

        System.out.println("Search window: " + searchWindow);


        //  Select Product

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("aria-label-27826893-1")
                )
        );

        product.click();

        System.out.println("Product clicked");


        //  Wait for Product Window

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));


        // Switch to Product Window

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(searchWindow)) {

                driver.switchTo().window(window);

                break;
            }
        }

        System.out.println("Product URL: " + driver.getCurrentUrl());


        //  Get Product Name

        WebElement productNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1")
                )
        );

        String productName = productNameElement.getText();

        System.out.println("Product Name: " + productName);


        //  Get Product Price

        List<WebElement> priceElements = driver.findElements(
                By.xpath("//*[normalize-space()='₹480']")
        );

        System.out.println(
                "Price elements found: " +
                priceElements.size()
        );

        String priceText = null;

        for (WebElement element : priceElements) {

            if (element.isDisplayed()
                    && !element.getText().trim().isEmpty()) {

                priceText = element.getText().trim();

                System.out.println(
                        "Selected Price: " + priceText
                );

                break;
            }
        }


        // Convert Price to Number

        if (priceText == null) {

            System.out.println("Price was not found!");

        } else {

            String cleanPrice = priceText
                    .replace("₹", "")
                    .replace(",", "")
                    .trim();

            double price =
                    Double.parseDouble(cleanPrice);

            System.out.println("Price as number: " + price);


            //  Save Product to MySQL

            MySqlConnection.saveProduct(
                    productName,
                    price
            );

            System.out.println("Nykaa product saved to MySQL!");
        }


        //  Select Size M

        WebElement sizeM = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[@aria-label='Select size M'][1]"
                        )
                )
        );

        sizeM.click();

        System.out.println("Size M selected");


        //  Add Product to Bag

        WebElement addToBag = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-at='add-to-bag']"))
        );

        addToBag.click();

        System.out.println("Add to Bag clicked");


        //  Wait for Add to Bag

        Thread.sleep(2000);


        // Open Cart


        driver.get("https://www.nykaafashion.com/?showCart=1");

        System.out.println("Navigated to cart");


        //  Wait for Cart Page

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.tagName("body")
                )
        );

        Thread.sleep(3000);


        //  Print Cart URL

        System.out.println("Cart URL: " + driver.getCurrentUrl());


        //  Print Cart Page Title

        System.out.println(
                "Cart Page Title: " + driver.getTitle()
        );

        //  Verify Cart Page

        if (driver.getCurrentUrl().contains("showCart")) {

            System.out.println(
                    "SUCCESS: Cart page opened!"
            );

        } else {

            System.out.println(
                    "Cart page URL is different."
            );
        }

    }
}


//package selenium;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class NykaaTest {
//
//    public static void main(String[] args) throws InterruptedException {
//
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//
//
//        driver.get("https://www.nykaa.com/");
//
//        System.out.println("Nykaa opened");
//
//
//       
//       // 3. Searching product
//        
//        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search on Nykaa']")));
//
//        searchBox.click();
//        searchBox.clear();
//        searchBox.sendKeys("Kurtis");
//        searchBox.sendKeys(Keys.ENTER);
//
//        wait.until(ExpectedConditions.urlContains("catalogsearch/result"));
//
//        System.out.println("Search URL: " + driver.getCurrentUrl());
//
//
//        // 4. Closing notification popup
//       
//        try {
//
//            WebElement noThanks = new WebDriverWait(driver,Duration.ofSeconds(5)).until(
//            ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='No thanks']")));
//            noThanks.click();
//
//            System.out.println("Notification popup closed");
//
//        } catch (Exception e) {
//
//            System.out.println("No notification popup");
//        }
//
//
//
//        // 5. Saving search-results window
//
//        String searchWindow = driver.getWindowHandle();
//
//        System.out.println("Search window: " + searchWindow);
//
//
//        // 6. Selecting Product
//
//        WebElement product = wait.until(
//        ExpectedConditions.elementToBeClickable(By.id("aria-label-27826893-1")));
//        product.click();
//
//        System.out.println("Product clicked");
//
//
//
//        // 7. Wait for second window
//
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//
//
//        // 8. Switching to Product Window
//
//        Set<String> windows = driver.getWindowHandles();
//
//        for (String window : windows) {
//
//            if (!window.equals(searchWindow)) {
//
//                driver.switchTo().window(window);
//
//                break;
//            }
//        }
//
//        System.out.println("Product URL: " + driver.getCurrentUrl());
//        
//        
//     // 9. Get Product Name
//
//        WebElement productNameElement = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//h1")
//                )
//        );
//
//        String productName = productNameElement.getText();
//
//        System.out.println("Product Name: " + productName);
//
//
//     // 10. Get Product Price
//
//        List<WebElement> priceElements = driver.findElements(
//                By.xpath("//*[normalize-space()='₹480']")
//        );
//
//        System.out.println("Price elements found: " + priceElements.size());
//
//        String priceText = null;
//
//        for (WebElement element : priceElements) {
//
//            if (element.isDisplayed() && !element.getText().trim().isEmpty()) {
//
//                priceText = element.getText().trim();
//
//                System.out.println("Selected Price: " + priceText);
//
//                break;
//            }
//        }
//
//
//        // Check whether price was found
//
//        if (priceText == null) {
//
//            System.out.println("Price was not found!");
//
//        } else {
//
//            // Remove ₹ and commas
//
//            String cleanPrice = priceText
//                    .replace("₹", "")
//                    .replace(",", "")
//                    .trim();
//
//            double price = Double.parseDouble(cleanPrice);
//
//            System.out.println("Price as number: " + price);
//
//
//            // Save to MySQL
//
//            MySqlConnection.saveProduct(productName, price);
//
//            System.out.println("Nykaa product saved to MySQL!");
//        }
//        
//  
//    }}






//
//        
//        
//        // 10. Get Product Price
//
//        WebElement priceElement = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//div[@id='aria-label-27826893-price']//span[@aria-label='Discounted price']")
//                )
//        );
//
//        String priceText = priceElement.getText();
//
//        System.out.println("Product Price: " + priceText);
//
//
//
//        // 9. Selecting Size M
//
//        WebElement sizeM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Select size M'][1]")));
//        sizeM.click();
//
//        System.out.println("Size M selected");
//
//
//        
//        // 10. Add Product to Bag
//
//        WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-at='add-to-bag']")));
//        addToBag.click();
//
//        System.out.println("Add to Bag clicked");
//
//
//
//        // 11. Wait for Add to Bag
//
//        Thread.sleep(2000);
//
//
//        
//        // 12. Open Cart
//        
//        driver.get("https://www.nykaafashion.com/?showCart=1");
//
//        System.out.println("Navigated to cart");
//
//
//        // 13. Wait for Cart Page
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//
//        Thread.sleep(3000);
//
//
//        
//        // 14. Printing Cart URL
//
//        System.out.println("Cart URL: " + driver.getCurrentUrl());
//
//
//
//        // 15. Print Page Title
//
//        System.out.println("Cart Page Title: " + driver.getTitle());
//
//
//        // 16. Verify Cart Page
//
//        if (driver.getCurrentUrl().contains("showCart")) {
//
//            System.out.println("SUCCESS: Cart page opened!");
//
//        } else {
//        	
//            System.out.println("Cart page URL is different.");
//        }
//
//    }
//}