package com.intexsoft.bookservice.utill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyWorker  {

    private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private Properties prop;


    public PropertyWorker()
    {
        try (FileReader reader = new FileReader("/home/INTEXSOFT/roman.asanovich/intexsoftStudying/bookservice/src/main/resources/filePath.properties")) {
            prop = new Properties();
            prop.load(reader);
        }
        catch (IOException ex){
            logger.error("Error:", ex);
        }
    }

    public String getProperty(String propName){
        return prop.getProperty(propName);
    }
}
