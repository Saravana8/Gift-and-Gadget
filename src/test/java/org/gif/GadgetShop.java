package org.gif;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GadgetShop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sadhana\\eclipse-workspace\\selenium\\GiftGadget\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.thegiftandgadgetstore.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.id("cn-accept-cookie")).click();

		//Actions acc = new Actions(driver);

		driver.findElement(By.xpath("(//a[starts-with(text(),'Gift Finder')])[3]")).click();

		driver.findElement(By.xpath("(//a[contains(text(),'Gifts for Babies & Toddlers')])[3]")).click();

		driver.findElement(By.xpath(
				"//div[@id=\"st-container\"]/div[1]/div/div/div/div[4]/div/div/div[1]/div[4]/div[1]/div/div[2]/div[1]/a"))
				.click();
		driver.findElement(By.xpath("//button[@value='6184']")).click();
		driver.findElement(By.xpath("//*[@id=\"product-6184\"]/div/div[1]/div/a")).click();
		WebElement amount = driver.findElement(By.xpath("//*[@id=\"st-container\"]/div[1]/div/div/div/div[4]/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div/table/tbody/tr[3]/td/strong/span"));
		System.out.println(amount.getText());
		
		WebElement chkout = driver.findElement(By.xpath("//*[@id=\"basket\"]/a/span"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(false)", chkout);
		//acc.moveToElement(chkout).perform();
		
		driver.findElement(By.xpath("//*[@id=\"st-container\"]/div[1]/div/div/div/div[3]/div/div/div/div[3]/div/div/div[2]/div[3]/a[2]")).click();


	}

}
