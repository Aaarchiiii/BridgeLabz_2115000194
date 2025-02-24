package D_24_02_25.Reflextion;

import java.lang.reflect.Field;
class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";
    public static String getApiKey() {
        return API_KEY;
    }
}
public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Field field = Configuration.class.getDeclaredField("API_KEY");
            field.setAccessible(true);
            field.set(null, "NEW_SECRET_KEY");
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
