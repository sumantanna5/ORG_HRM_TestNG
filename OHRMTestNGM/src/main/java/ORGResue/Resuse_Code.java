package ORGResue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resuse_Code {

	static WebDriver driver;

	public Resuse_Code(WebDriver driver) {
		this.driver = driver;
	}

	public static void WaitForElementToAppear(By findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

}
