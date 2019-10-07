package HHS_PROJGR6.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * ResourceReader
 */
public class ResourceReader {

    /**
     * 
     * @param fileName
     * @return
     */
    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    /**
     * 
     * @param resourceName
     * @return
     */
    public static File resourceReader(String resourceName) {
        return new ResourceReader().getFileFromResources(resourceName);
    }
}