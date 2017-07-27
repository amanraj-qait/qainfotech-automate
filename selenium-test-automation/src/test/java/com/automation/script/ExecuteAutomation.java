package com.automation.script;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.connections.Pathreader;
import com.connections.PropertyFileReader;

public class ExecuteAutomation {
	private JavascriptExecutor executor;
	private WebDriver driver;
	private WebdriverSelect loadDriver;
	private PropertyFileReader reader;
	private String url;
	private String result;
	Pathreader data = new Pathreader();

	/**
	 * Initialize objects
	 * 
	 * @throws Exception
	 */
	public ExecuteAutomation() throws Exception {
		loadDriver = new WebdriverSelect();
		reader = new PropertyFileReader();
		url = reader.read_property("url");
		driver = loadDriver.get_driver_for_running_automation();
		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/**
	 * Click on tab to load different page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String click_on_careers_tab() throws Exception {
		Thread.sleep(3000);
		driver.findElement(data.getLocator("Careers")).click();
		result = driver.getCurrentUrl();
		return result;
	}

	/**
	 * Check if dropdown menu is present
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean hover_mouse_button_on_tab() throws Exception {
		Thread.sleep(3000);
		boolean answer = false;
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(data.getLocator("About"));
		action.moveToElement(element);
		action.build().perform();
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(data.getLocator("List"));
		if (options != null) {
			answer = true;
		}
		return answer;
	}

	/**
	 * Display non visible section of page
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean display_nonvisible_data() throws Exception {
		driver.navigate().back();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(data.getLocator("Team")).click();
		return driver.findElement(data.getLocator("Team")).isDisplayed();

	}

	/**
	 * Click on image to move to new page
	 * 
	 * @return
	 * @throws Exception
	 */
	public String navigate_to_content_page() throws Exception {
		Thread.sleep(3000);
		driver.findElement(data.getLocator("Image")).click();
		result = driver.getCurrentUrl();
		return result;

	}

	/**
	 * Enter a word to search
	 * 
	 * @return
	 * @throws Exception
	 */
	public String search_word() throws Exception {
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(data.getLocator("Search_word")).sendKeys(reader.read_property("word"));
		driver.findElement(data.getLocator("Search")).click();
		result = driver.getCurrentUrl();
		return result;

	}

	/**
	 * Check if dropdown menu is absent
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean check_for_absent_dropdown_menu() throws Exception {
		driver.navigate().back();
		Thread.sleep(3000);
		boolean answer = false;
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(data.getLocator("Verticals"));
		action.moveToElement(element);
		action.build().perform();
		Thread.sleep(3000);
		try {
			driver.findElement(data.getLocator("List2")).click();
		} catch (NoSuchElementException e) {
			answer = true;
		}
		return answer;

	}

	/**
	 * Click on Devlabs tab in Our Ventures Section
	 * 
	 * @return
	 * @throws Exception
	 */
	public String open_new_window_on_click() throws Exception {
		Thread.sleep(3000);
		Object element = driver.findElement(data.getLocator("View"));
		String winHandleBefore = driver.getWindowHandle();
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
		element = driver.findElement(data.getLocator("Click"));
		executor.executeScript("arguments[0].click();", element);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		result = driver.getCurrentUrl();
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(winHandleBefore);
		return result;

	}

	/**
	 * close window
	 */
	public void end_automation() {
		driver.close();
		driver.quit();
	}
}
