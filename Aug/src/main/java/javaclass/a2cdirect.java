package javaclass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class a2cdirect {
	public static RemoteWebDriver driver ;
	private static String gettxt;
	private static WebDriver window;
	private static WebElement creatNew;
	private static WebElement clickonContinue;
	private static WebElement radiobtn;
	private static WebElement beginbtn;
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.navigate().to("https://qmat.axis.deloitte.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='qauth.us.deloitte.com']").click();
		driver.findElementById("userNameInput").sendKeys("pkona@usqaex");
		driver.findElementById("passwordInput").sendKeys("Portal123!");
		driver.findElementByXPath("//span[text()='Sign in']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='typeahead_block'])[1]/input").sendKeys("American Bank");
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='AMERICAN BANK']").click();


		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='your_audit_process']/ul/li")); 


		for (WebElement element: allElements) {
			element.getText();
			System.out.println(element.getText());
			Thread.sleep(2000);
			if(element.getText().equals("Manage Engagement Data"))
			{
				driver.findElementByXPath("//span[text()='Manage Engagement Data']").click();
			}
		}
		List<WebElement> listele=driver.findElementsByXPath("//div[@class='btn-group sp-fy-select year_profile_list']/label");

		for (WebElement element1: listele) {
			gettxt = element1.getText();
			System.out.println(element1.getText());
			Thread.sleep(2000);
			if(element1.getText().equals("2019"))
			{
				driver.findElementByXPath("(//span[text()='2019'])[1]").click();

			}

		}
		Thread.sleep(3000);
		try {
			creatNew = driver.findElementByXPath("//div[@class='sp_flyout_menu_footer sp_flyout_menu_item']/span/a/strong[2]");
			boolean CreateNewFind=creatNew.isDisplayed()||creatNew.isEnabled();
			creatNew.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element No Found");
		}
		Thread.sleep(3000);
		try {
			radiobtn = driver.findElementByXPath("(//div[@class='sp_flyout_menu_item']/div[@class='radio-inline'])[2]");
			boolean radfind=radiobtn.isDisplayed()||radiobtn.isEnabled();
			radiobtn.click();
		} catch (NoSuchElementException r) {
			System.out.println("radio button not found!");
		}

		

		Thread.sleep(3000);
		try {
			beginbtn = driver.findElementByXPath("//button[text()='Begin']");
			boolean isBeing=beginbtn.isDisplayed()|| beginbtn.isEnabled();
			beginbtn.click();
		} catch (NoSuchElementException b) {
			System.out.println("Being button not found!!");
		}
//		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
//		Thread.sleep(3000);
//		driver.findElementByXPath("//div[@class='modal-content']");
//		Thread.sleep(3000);
//		try {
//			clickonContinue = driver.findElementByXPath("//div[@class='modal-content']/div[3]/button[text()='Continue']");
//			boolean findCont=clickonContinue.isDisplayed()||clickonContinue.isEnabled();
//					clickonContinue.click();
//		} catch (NoSuchElementException e2) {
//			System.out.println("The continue button is not available.");
//		}
	}
}





