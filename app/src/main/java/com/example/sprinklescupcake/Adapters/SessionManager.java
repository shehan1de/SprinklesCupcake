package com.example.sprinklescupcake.Adapters;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "YourAppSession";
    private static final String KEY_USER_TYPE = "userType";
    private static final String KEY_USER_ID = "userId";
    private static SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void setLoggedInUser(String userType, String userId) {
        editor.putString(KEY_USER_TYPE, userType);
        editor.putString(KEY_USER_ID, userId);
        editor.apply();
    }

    public String getUserType() {
        return sharedPreferences.getString(KEY_USER_TYPE, null);
    }
    public static String getUserId() {
        return sharedPreferences.getString(KEY_USER_ID, null);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }
}
