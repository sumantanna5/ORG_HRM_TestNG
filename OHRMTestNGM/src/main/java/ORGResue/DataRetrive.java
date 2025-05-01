package ORGResue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataRetrive {

	public static String getDataGlobal(String Data) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src/main/java/Gloabal.properties");
		prop.load(file);
		String Value = prop.getProperty(Data);
		System.out.println(Value);
		return Value;
	}

}
