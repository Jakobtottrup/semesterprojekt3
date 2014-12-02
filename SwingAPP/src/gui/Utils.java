package gui;

/**
 * Created by Jakob on 06-11-2014.
 */
public class Utils {
    public static String getFileExtension(String name) {
        int pointIndex = name.lastIndexOf(".");
        if (pointIndex == -1) {
            return null;
        }
        if (pointIndex == name.length() - 1) {
            return null;
        }
        return name.substring(pointIndex + 1, name.length());
    }
}
