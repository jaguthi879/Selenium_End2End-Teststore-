package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Basepage {
	
	public static WebDriver driver;
	private String url;
	private Properties prop;

	public Basepage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\db.properties");
		prop.load(data);
	
	}

	public WebDriver getDriver() throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\237529\\Browserdriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		return url;
	}
	
	public void takeSnapShot(String name) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\target\\screenshots\\"
				+ timestamp() + ".png");

		FileUtils.copyFile(srcFile, destFile);
	}
	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
