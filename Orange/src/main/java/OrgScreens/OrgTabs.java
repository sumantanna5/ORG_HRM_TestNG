package OrgScreens;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class OrgTabs {

//	static Login lo = new Login();
	static WebDriver driver;

	public OrgTabs(WebDriver driver) {
		OrgTabs.driver = driver;
	}

	public void Menu(String TabName) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src/main/java/OrgScreens/utility.properties");
		prop.load(file);
		String side_menu = prop.getProperty("Side_menu");
		List<WebElement> Menu_options = (List<WebElement>) driver.findElements(By.xpath(side_menu));
		int i = 1;
		for (WebElement list_names : Menu_options) {
			System.out.println("********************************************");
			System.out.println(i + " Value in Menu List :" + list_names.getText());
			i++;
		}

		for (WebElement list_names : Menu_options) {

			if (list_names.getText().equalsIgnoreCase(TabName)) {
				driver.findElement(By.xpath("//*[text()='" + TabName + "']")).click();
				break;
			}

		}

		String Menu = prop.getProperty("Menu_Header_text");
		WebElement Menu_Val = driver.findElement(By.xpath(Menu));

		if (Menu_Val.getText().contains("Admin")) {
//			String Value = "Admin User Management";
			System.out.println(Menu_Val.getText());
			
			System.out.println("Succefully Entered Admin Page");
		} else if (TabName == "My Info") {
			if (Menu_Val.getText().contains("PIM")) {
				String Value = "PIM";
				Assert.assertEquals(Value, Menu_Val.getText());
				System.out.println("Succefully Entered My Info Page");
				
			}
		} else if (Menu_Val.getText().contains("PIM")) {
			String Value = "PIM";
			Assert.assertEquals(Value, Menu_Val.getText());
			System.out.println("Succefully Entered PIM Page");
			
		} else if (Menu_Val.getText().contains("Performance")) {
//			String Value = "Performance";
			System.out.println("Succefully Entered Performance Page");
			
		} else if (Menu_Val.getText().contains("Leave")) {
			String Value = "Leave";
			Assert.assertEquals(Value, Menu_Val.getText());
			System.out.println("Succefully Entered Leave Page");
			
		} else if (Menu_Val.getText().contains("Time")) {
//			String Value = "Time";
			System.out.println("Succefully Entered Time Page");
			
		} else if (Menu_Val.getText().contains("Recruitment")) {
			String Value = "Recruitment";
			Assert.assertEquals(Value, Menu_Val.getText());
			System.out.println("Succefully Entered Recruitment Page");
			
		} else if (Menu_Val.getText().contains("Directory")) {
			String Value = "Directory";
			Assert.assertEquals(Value, Menu_Val.getText());
			System.out.println("Succefully Entered Directory Page");
			
		} else if (Menu_Val.getText().contains("Claim")) {
			String Value = "Claim";
			Assert.assertEquals(Value, Menu_Val.getText());
			System.out.println("Succefully Entered Claim Page");
			
		} else if (Menu_Val.getText().contains("Buzz")) {
			String Value = "Buzz";
			Assert.assertEquals(Value, Menu_Val.getText());
			System.out.println("Succefully Entered Buzz Page");
			
		} else {
			System.out.println("Failed to Enter Screen :" + TabName);
		}

	}

}
