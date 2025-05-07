package com.example.a3_l215819;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeUtil {
    public static int getSavedTheme(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        boolean isDark = prefs.getBoolean("dark_mode", false);
        return isDark ? R.style.Theme_AppCompat : R.style.Theme_AppCompat_Light;
    }
}
