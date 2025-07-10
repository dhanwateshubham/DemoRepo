package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class BaseClass {
	
	public Logger logger;
	public Properties pop;
	Faker faker;
	public WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{	
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		default : System.out.println("Browser name is Invalid.");return;
		}
		
		logger = LogManager.getLogger(this.getClass());
		
		faker = new Faker();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
		pop = new Properties();
		pop.load(fi);
		driver.get(pop.getProperty("url"));
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	public String randomName()
	{
		String name = faker.name().fullName();
		return name;	
	}
	public String randomEmail()
	{
		String email = faker.internet().emailAddress();
		
//		String name = faker.name().fullName();
//		String phoneNumber = faker.phoneNumber().cellPhone();
//		String company = faker.company().name();
		
		return email;
	}
	
	public String randomCellPhone()
	{
		String phone = faker.phoneNumber().cellPhone();
		return phone;	
	}
	
	public String randomPassword()
	{
		String password = faker.internet().password(); // Default length and settings;
		return password;
	}
	
	
	
	
	
	
	
	
	
	
}
