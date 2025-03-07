package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String TakeSS(WebDriver driver, String file)

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Test_Result_ScreenShot\\" + file + ".png";

		File destinatiom = new File(path);
		try {
			FileUtils.copyFile(source, destinatiom);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
