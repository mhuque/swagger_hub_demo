package Utilities;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import swaglabs.basepage.BasePage;

public class CommonUtility extends BasePage {

	public static void jsClick(WebElement elm) {
		JavascriptExecutor excuter = (JavascriptExecutor) driver;
		excuter.executeScript("arguments[0].click();", elm);
	}
	
	public static void getHighLighter(WebElement elm) {
		
		JavascriptExecutor executer = (JavascriptExecutor) driver; 
		executer.executeScript("arguments[0].setAttribute('style','background: yellow; border: 4px solid red;');", elm);		
	}

	public static void acctionClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.click(ele).build().perform();

	}

	public static WebElement getExplicitWait(WebElement elem, WebDriver driver, long time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;

	}
	
	public static void takeScreenShot() throws IOException {
//		
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir") + "//screenshot/screenshot.png");
//		targetFile.getParentFile().mkdir();
//		srcFile.createNewFile();
//		Files.copy(srcFile, targetFile);
			
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String time = timeStamp + ".png";
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "//screenshot/screenshot-" + time);
		targetFile.getParentFile().mkdir();
		srcFile.createNewFile();
		Files.copy(srcFile, targetFile);
		
	}
	

	public static void getWindowHandles() {	  
		String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles(); 
	        Iterator<String> iterator = allWindowHandles.iterator(); 
	        
	        while (iterator.hasNext()) { 
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                    driver.switchTo().window(ChildWindow);
	                    driver.close();
	                    System.out.println("Child window closed");
	                 }	      
	        }        
	       
	        driver.switchTo().window(mainWindowHandle);
	      
	}
	
	 
		public static void getAlert() {
	               
	        Alert alert = driver.switchTo().alert();		    
	        String alertMessage= driver.switchTo().alert().getText();			
	        System.out.println(alertMessage);	
	        alert.accept();	
	          
	    }
	
		public static void getIframe() {
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		}

}