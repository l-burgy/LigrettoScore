package ch.lburgy.ligrettoscore.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;

public class PrefManager {
    private static final int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "ch.lburgy.ligrettoscore";

    private static final String KEY_THEME = "theme";

    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    public PrefManager(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setTheme(int theme) {
        editor.putInt(KEY_THEME, theme);
        editor.commit();
    }

    public int getTheme() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return pref.getInt(KEY_THEME, MODE_NIGHT_FOLLOW_SYSTEM);
        } else {
            return pref.getInt(KEY_THEME, MODE_NIGHT_AUTO_BATTERY);
        }
    }
}