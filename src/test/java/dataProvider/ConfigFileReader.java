package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;

    public ConfigFileReader(){
        BufferedReader reader;
        String propertyFilePath = "configs/configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("webDriverPath");
        if (driverPath != null){
            return driverPath;
        }else {
            throw new RuntimeException("WebdriverPath not specified in the Configuration.properties file");
        }
    }

    public long getImplicitlyWait(){
        String implicitlyWait = properties.getProperty("wait");
        if (implicitlyWait != null){
            return Long.parseLong(implicitlyWait);
        }else {
            throw new RuntimeException("Wait not specified in the Configuration.properties file.");
        }
    }

    public String getApplicationUrl(){
        String url = properties.getProperty("baseURL");
        if (url != null){
            return url;
        }else {
            throw new RuntimeException("baseURL not specified in the Configuration.properties file.");
        }
    }
}
