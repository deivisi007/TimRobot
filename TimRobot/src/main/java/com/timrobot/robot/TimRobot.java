package com.timrobot.robot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.timrobot.variables.MyVariables;

public class TimRobot {

	public static void main(String[] args) throws IOException, InterruptedException {

//		String urlTim = "https://www.timbusiness.it/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\devi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		
		//Kjo pjese ketu eshte per te percaktuar ku eshte folderi i downloadit
		/************************************************************************/
		String downloadFilepath = "C:\\Users\\devi\\Desktop\\PUNA\\FTP";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(cap);
		/***********************************************************************/
		
//		WebDriver driver = new ChromeDriver();

		driver.get(MyVariables.urlTim);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement cookieTim = driver.findElement(MyVariables.cookieTim);
		cookieTim.click();
		Thread.sleep(2000);

		CSVReader reader = new CSVReader(new FileReader(MyVariables.csvfileT));
		String cell[];

		reader.readNext();
		while ((cell = reader.readNext()) != null) {

			for (int i = 0; i < cell.length + 1; i++) {

				String name = cell[0];
				String password = cell[1];

				cell = reader.readNext();

				WebElement areaClientiTim = driver.findElement(MyVariables.areaClientiTim);
				areaClientiTim.click();
				Thread.sleep(2000);

				if (driver.findElement(MyVariables.cookieTim).isDisplayed()) {
					if (!driver.findElement(MyVariables.cookieTim).isSelected()) {
						WebElement cookieTim2 = driver.findElement(MyVariables.cookieTim);
						cookieTim2.click();
						Thread.sleep(2000);
					}
				}

				
				//LOGIN
				
				WebElement usernameTim = driver.findElement(MyVariables.usernameTim);
				usernameTim.sendKeys(name);
				Thread.sleep(2000);

				WebElement passwordTim = driver.findElement(MyVariables.passwordTim);
				passwordTim.sendKeys(password);
				Thread.sleep(2000);

				WebElement checkBoxTim = driver.findElement(MyVariables.checkBoxTim);
				checkBoxTim.click();
				Thread.sleep(2000);

				WebElement vaiButtonTim = driver.findElement(MyVariables.vaiButtonTim);
				vaiButtonTim.click();
				Thread.sleep(30000);
				
				
				//dropdown navigation bar
				if (driver.findElement(MyVariables.dropDownMenuTim).isDisplayed()) {
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(MyVariables.dropDownMenuTim)).perform();
					driver.findElement(MyVariables.consumiReportTim).click();
				}
				Thread.sleep(10000);
			
			    
				WebElement vaiAlReportTim = driver.findElement(MyVariables.vaiAlReportTim);
				vaiAlReportTim.click();
				Thread.sleep(30000);
				
				
				
				//************************************************************************************//
				//ketu duhet te zgjidhet pjesa qe kalojme tek tabi tjeter
				
				String parent = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();

				int count = allWindows.size();

				for (String child : allWindows) {
					if (!parent.equalsIgnoreCase(child)) {
						driver.switchTo().window(child);
						WebElement fatureTim = driver.findElement(MyVariables.fatureTim);
						fatureTim.click();
						Thread.sleep(30000);
						
						WebElement leMieFatureTim = driver.findElement(MyVariables.leMieFatureTim);
						leMieFatureTim.click();
						Thread.sleep(30000);
						
						
						Select selezionaAccNr = new Select(driver.findElement(MyVariables.selezionaAccNr));
						selezionaAccNr.selectByIndex(1);
						Thread.sleep(30000);
						
						
						//pastaj ketu duhet pjesa e shkarkimit te dokumentave
						
						
						/************************************************************************************/
						
						//documenti del traffico - FATTURATO
						
						
						WebElement documDelTraffico = driver.findElement(MyVariables.documDelTraffico);
						documDelTraffico.click();
						Thread.sleep(30000);
						
						
						WebElement fatturato = driver.findElement(MyVariables.fatturato);
						fatturato.click();
						Thread.sleep(30000);
						
						WebElement analitico = driver.findElement(MyVariables.analitico);
						analitico.click();
						Thread.sleep(30000);
						
						//pastaj ketu duhet pjesa e shkarkimit te dokumentave
						
						/************************************************************************************/
						
						//documenti del traffico - RICARICABILE BUSINESS
						
						WebElement documDelTraffico1 = driver.findElement(MyVariables.documDelTraffico);
						documDelTraffico1.click();
						Thread.sleep(30000);
						
						WebElement ricaricaBussines = driver.findElement(MyVariables.ricaricaBussines);
						ricaricaBussines.click();
						Thread.sleep(30000);
						
						WebElement ricaricaBussinesAnalitic = driver.findElement(MyVariables.ricaricaBussinesAnalitic);
						ricaricaBussinesAnalitic.click();
						Thread.sleep(30000);
						
						//pastaj ketu duhet pjesa e shkarkimit te dokumentave
						
						
						
						
						//ky rrjeshti eshte per te mbyllur tabin aktual
//						driver.close();

					}
				}
				
				//ky rrjeshti eshte per tu kthyer tek tabi i pare
				driver.switchTo().window(parent);
				//************************************************************************************//
				

				
				
				
				
				
//				//LOGOUT FATURE TIM
//				WebElement logoutFatureTim = driver.findElement(MyVariables.logoutFatureTim);
//				logoutFatureTim.click();
//				Thread.sleep(2000);
//				
//				//LOGOUT TIM
//				WebElement logoutTim = driver.findElement(MyVariables.logoutTim);
//				logoutTim.click();
//				Thread.sleep(200000);

//				Thread.sleep(5000);
//				driver.close();
//				driver.quit();
//				driver = null;

			}

		}
	}
}
