package com.timrobot.robot;


import org.openqa.selenium.By;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.opencsv.CSVReader;
import com.timrobot.variables.MyVariables;

public class Download {
	
	
	static {
		String msg = "ckemi si je";
		System.out.println(msg);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//		chromePrefs.put("download.default_directory",
//		System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
//		//chromePrefs.put("profile.default_content_settings.popups", 0);
//		options.setExperimentalOption("prefs", chromePrefs);
//		options.addArguments("start-maximized"); 
//		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//		WebDriver driver = new ChromeDriver(options);
		
		
		String urlTim = "https://the-internet.herokuapp.com/download";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\devi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
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
		
//		WebDriver driver = new ChromeDriver();

		driver.get(urlTim);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		CSVReader reader = new CSVReader(new FileReader(MyVariables.csvfileT));
		String cell[];

		reader.readNext();
		while ((cell = reader.readNext()) != null) {
			
			for (int i = 1; i < cell.length; i++) {

				String name = cell[0];
				String password = cell[1];

				chromePrefs.put("download.default_directory", downloadFilepath + name);
				
				String home = System.getProperty("user.home");	
				System.out.println(home);
				String file_with_location = home + "\\Desktop\\PUNA\\FTP\\" + name;
				File file = new File(file_with_location);
				// Create one directory
				
				try {
					boolean success = file.mkdir();
					if (success) {
						System.out.println("Directory: " + file + " created");
					}
			    }
			    catch (Exception e){//Catch exception if any
			        System.err.println("Error: " + e.getMessage());
			    }  
				    chromePrefs.put("download.default_directory", downloadFilepath + name);
			        WebElement linkdownload = driver.findElement(By.xpath("//a[@href='download/some-file.txt']"));
					linkdownload.click();
					Thread.sleep(2000);
					
					
					//nqs nuk gjen file brenda direktorise e fshin
//					delete_file(name);
			}
		}
	}
	public static void  delete_file(String filename)
	
	{
		
	    String home = System.getProperty("user.home");	    
	    String file_name = filename;
	    String file_with_location = home + "\\Desktop\\PUNA\\FTP\\" + file_name;
	    System.out.println("Function Name ===========================" + home + "\\Desktop\\PUNA\\FTP\\" + file_name);
	    File file = new File(file_with_location);
	    if (file.exists() && file.isDirectory()) {
	        System.out.println(file_with_location + " is present");
	        if (file.delete()) {
	            System.out.println("file deleted");
	        } else {
	            System.out.println("file not deleted");
	        }
	    } else {
	    	file.mkdir();
	        System.out.println(file_with_location + " is not present");
	    } 
	}
}


