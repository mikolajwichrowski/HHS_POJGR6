package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Interfaces.IFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
// import org.json.simple.JSONParser;

/*
* Entity class
*/ 
public class JsonReader implements IFileReader {
    private File resource;

    // Constructor
    public JsonReader(String filename) 
    {
        this.resource = resourceReader(filename);
    }

    public String getString()
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.resource));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;

            // Read line by line for markup
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // Close reader
            reader.close();

            String content = stringBuilder.toString();
            return content;
        } catch (Exception e) {
            return "";
        }
    }

    public Object getJsonObject() 
    {
        // JSONParser parser = new JSONParser();
        // Object obj = parser.parse(getString());
        return null;
    }

    private File resourceReader(String resourceName)
    {
        return new File(Thread.currentThread().getContextClassLoader().getResource(resourceName).getFile());
    }

}


