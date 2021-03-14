package com.timrobot.robot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.opencsv.CSVReader;
import com.timrobot.variables.MyVariables;

public class MyBusinessRobot {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\devi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get(MyVariables.urlMyBusiness);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement closeCookieMy = driver.findElement(MyVariables.closeCookieMy);
		closeCookieMy.click();
		Thread.sleep(2000);

		CSVReader reader = new CSVReader(new FileReader(MyVariables.csvfileM));
		String cell[];

		reader.readNext();
		while ((cell = reader.readNext()) != null) {

			for (int i = 0; i < cell.length + 1; i++) {

				String name = cell[0];
				String password = cell[1];

				cell = reader.readNext();

				WebElement usernameMy = driver.findElement(MyVariables.usernameMy);
				usernameMy.sendKeys(name);
				Thread.sleep(2000);

				WebElement passwordMy = driver.findElement(MyVariables.passwordMy);
				passwordMy.sendKeys(password);
				Thread.sleep(2000);

				WebElement accediMy = driver.findElement(MyVariables.accediMy);
				accediMy.click();
				Thread.sleep(2000);

				//dropdown navigation bar
				if (driver.findElement(MyVariables.dropDownMenuMy).isDisplayed()) {
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(MyVariables.dropDownMenuMy)).perform();
					driver.findElement(MyVariables.telefoniaMobMy).click();
				}
				Thread.sleep(10000);
				

				WebElement fatureAziendaliMy = driver.findElement(MyVariables.fatureAziendaliMy);
				fatureAziendaliMy.click();
				Thread.sleep(100000);
				
				
				

			}

		}

	}

}
