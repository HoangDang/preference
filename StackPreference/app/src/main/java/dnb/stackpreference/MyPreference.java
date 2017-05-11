package dnb.stackpreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ngodung on 5/11/17.
 */

public class MyPreference {

    private static MyPreference instance;
    private static SharedPreferences preferences;

    private static String KEY_PREFERENCE_FILE = "preference.file.keys";
    private static String KEY_PREFERENCE_RING = "preference.file.keys.ring";
    private static String KEY_PREFERENCE_GREEN = "preference.file.keys.green";
    private static String KEY_PREFERENCE_TOTAL = "preference.file.keys.total";


    public MyPreference(Context baseApplicationContext) {
        preferences = baseApplicationContext.getSharedPreferences(KEY_PREFERENCE_FILE, Context.MODE_PRIVATE);
    }

    public static synchronized MyPreference getInstance(Context baseApplicationContext) {
        if (instance == null) {
            instance = new MyPreference(baseApplicationContext);
        }
        return instance;
    }

    public static synchronized void saveRing(int ring) {
        if (preferences != null) {
            preferences.edit().putInt(KEY_PREFERENCE_RING, ring).commit();
        }
    }

    public static synchronized void saveGreen(int green) {
        if (preferences != null) {
            preferences.edit().putInt(KEY_PREFERENCE_GREEN, green).commit();
        }
    }

    public static synchronized void saveTotal(int total) {
        if (preferences != null) {
            preferences.edit().putInt(KEY_PREFERENCE_TOTAL, total).commit();
        }
    }

    public static synchronized int getRing() {
        if (preferences != null) {
            return preferences.getInt(KEY_PREFERENCE_RING, 0);
        }
        return 0;
    }

    public static synchronized int getGreen() {
        if (preferences != null) {
            return preferences.getInt(KEY_PREFERENCE_GREEN, 0);
        }
        return 0;
    }

    public static synchronized int getTotal() {
        if (preferences != null) {
            return preferences.getInt(KEY_PREFERENCE_TOTAL, 0);
        }
        return 0;
    }

}
