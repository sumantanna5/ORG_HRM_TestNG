package Practice;

import org.openqa.selenium.WebDriver;

public class ConstructorPractice {

	static int a;
	static String b;
	static WebDriver driver;

	public ConstructorPractice(int aa, String bb, WebDriver driver) {
		a = aa;
		b = bb;
		this.driver = driver;

		System.out.println("Print Constructor Input :" + a + " " + b);
	}

	public static void main(String[] args) {
		ConstructorPractice cp = new ConstructorPractice(101, "Sumant", driver);

	}

}
