package fr.themode.utils.file;

import java.io.*;

public class FileUtils {

    private static Class clazz;

    public static void setClass(Class clazz) {
        FileUtils.clazz = clazz;
    }

    public static InputStream getInternalFile(String path) {
        return clazz.getResourceAsStream(path);
    }

    public static File getExternalFile(String path) {
        return new File(path);
    }

    public static String getInternalFileString(String path) {
        String value = "";
        try {
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(FileUtils.getInternalFile(path)));
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
