package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Framework {

    private static Properties p = new Properties();

    public static String get(String propertyKey) {
        String path = "app.properties";
            try {
                FileInputStream file = new FileInputStream(path);
                p.load(file);
                file.close();
            } catch (IOException e) {
                System.out.println("Properties file not found");
            }


        if (System.getProperty("env") == null) {
            if (p.get("env") == null) {
                System.setProperty("env", "qa");//default is qa
            } else {
                System.setProperty("env", p.getProperty("env"));
            }
        }
        String prefix = "";
        switch (System.getProperty("env")) {
            case "qa":
                prefix += "qa.";
                break;
            case "nonprod":
                prefix += "nonprod.";
                break;
            case "prod":
                prefix += "prod.";
                break;
        }

        if (p.getProperty(prefix + propertyKey) != null) {
            return p.getProperty(prefix + propertyKey);
        } else {
            System.out.println("No such property : " + p.getProperty(prefix + propertyKey));
            return null;
        }

    }
}
