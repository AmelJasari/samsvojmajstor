package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.util.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

import pageObjects.LoginObjekti;
import pageObjects.NaslovnaObjekti;

public class base {
	
	
	//ako zelimo da pustimo testove paralelno webDriver driver ne sme da bude static
	public static WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	
	
	
	public WebDriver initializeDriver() throws IOException
	
	{
			
		prop = new Properties();
		//FileInputStream fis = new FileInputStream("C:\\Users\\Amel\\eclipse-workspace-kurs\\samsvojmajstor\\src\\main\\java\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//ovako direktno iz mvn komande
		//String browser =System.getProperty("browser");
		
		//ovako upisujemo u test, tj u property file
		String browser = prop.getProperty("browser");
		
		
		if (browser.contains("chrome"))
		{
			
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amel\\eclipse-workspace-kurs\\samsvojmajstor\\src\\main\\java\\resources\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");		
		
	
		//HEADLESS NE RADI - mozda zbog verzije selenijuma
		
		//headless je izvrsavanje coda bez pokretanja browsera
		ChromeOptions option = new ChromeOptions();
		
		if (browser.contains("headless"))
		{
			option.addArguments("headless");
			
		}
		
		driver = new ChromeDriver(option);
			
		}
		
		else if (browser.contains("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Amel\\eclipse-workspace-kurs\\samsvojmajstor\\src\\main\\java\\resources\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	
}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		//FileUtils.copyFile(src, new File("C:\\Users\\Amel\\eclipse-workspace-kurs\\samsvojmajstor\\testPrtScr\\"+result+" scrError.png"));
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\testPrtScr\\"+result+" scrError.png"));
		
		
		
		
	}
	
	
	
	
		
	
}
