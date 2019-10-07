package HHS_PROJGR6.Utils;

import HHS_PROJGR6.Interfaces.IFileReader;
import HHS_PROJGR6.Utils.ResourceReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
* Entity class
*/
public class JsonReader implements IFileReader {
    private File resource;

    // Constructor
    public JsonReader(String filename) {
        this.resource = ResourceReader.resourceReader(filename);
    }

    private String getString() {
        try {
            // Declare content variable and reader
            String content = "";
            BufferedReader reader = new BufferedReader(new FileReader(this.resource));

            // Read line by line for markup
            String line = null;
            while ((line = reader.readLine()) != null) {
                content += line;
            }

            // Close reader
            reader.close();

            // Return string
            return content;
        } catch (Exception e) {
            return "";
        }
    }

    public Iterator getIterable() {
        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(getString());
            return jsonArray.iterator();
        } catch (Exception exceptionOnParsingArray) {
            try {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = (JSONObject) parser.parse(getString());
                jsonArray.add(jsonObject);
                return jsonArray.iterator();
            } catch (Exception exceptionOnParsingObject) {
                return null;
            }
        }
    }
}
