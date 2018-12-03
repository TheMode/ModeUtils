package fr.themode.utils.file;

import java.io.*;

public class FileUtils {

    public static InputStream getInternalFile(Class clazz, String path) {
        return clazz.getResourceAsStream(path);
    }

    public static File getExternalFile(String path) {
        return new File(path);
    }

    public static String getInternalFileString(Class clazz, String path) {
        String value = "";
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(FileUtils.getInternalFile(clazz, path)));
            while ((line = reader.readLine()) != null) {
                value += line + "\n";
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String getExternalFileString(String path) {

        String value = "";
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getExternalFile(path)));
            while ((line = reader.readLine()) != null) {
                value += line + "\n";
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
