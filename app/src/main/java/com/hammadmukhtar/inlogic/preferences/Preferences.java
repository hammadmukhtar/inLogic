package com.hammadmukhtar.inlogic.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hammadmukhtar.inlogic.api.models.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is for Saving and Retrieving data from Shared Preferences
 */
public class Preferences {

	private static final String FILE_NAME_SHARED_PREF = "shared_preference.xml";

	private static Context context;
	private static Map<String, Type> map = new HashMap<>();

	private Preferences() { /* Emptry Constructor */ }
	private Preferences(Context context) {
		Preferences.context = context;
	}
	
	public static void setContext(Context context) {
		Preferences.context = context;
		map.put(CONSTANTS.SERVICES_LIST, new TypeToken<List<Service.Data>>() {}.getType());
	}
	
	/* This method is for update values of String variables if existed else create new variable in Shared Preferences */
	public static void update(String key, String value) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE );
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.commit();

	}

	/* This method is for update values of Boolean variables if existed else create new variable in Shared Preferences */
	public static void update(String key, Boolean value) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(key, value);
		editor.commit();

	}

	/* This method is for update values of Integer variables if existed else create new variable in Shared Preferences */
	public static void update(String key, int value) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(key, value);
		editor.commit();

	}

	public static void update(String key, float value) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putFloat(key, value);
		editor.commit();

	}
	
	public static void update(String key, long value) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	/* This method is for update value of any Object if exisit or create new object variable in Shared Preference */
    public static void update(String key, Object value) {
        SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString(key, json);
        editor.commit();

    }

	/* This method is for get values of String variables if existed otherwise return null */
	public static String getString(String key) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF,  Context.MODE_PRIVATE);
		return settings.getString(key, "");

	}
	public static float getFloat(String key) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, 0);
		return settings.getFloat(key, -1);

	}
	/* This method is for get values of Boolean variables if existed otherwise return null */
	public static Boolean getBoolean(String key) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, 0);
		return settings.getBoolean(key, false);

	}

	/* This method is for get values of Integer variables if existed otherwise return null */
	public static int getInt(String key) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, 0);
		return settings.getInt(key, -1);
	}
	
	public static Long getLong(String key) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, 0);
		return settings.getLong(key, -1);
	}
	
	public static Long getLong(String key, long defaultValue) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, 0);
		return settings.getLong(key, defaultValue);
	}

	public static <T> T getObject(String key, Class<T> objectClass) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF,  Context.MODE_PRIVATE);
		Gson gson = new Gson();
		String json = settings.getString(key, "");
        if(!json.isEmpty()){
            return gson.fromJson(json, objectClass);
        }
        return null;
	}

	/* This method is for update values of String variables if existed else create new variable in Shared Preferences */
	public static void delete(String key) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.remove(key);
		editor.commit();
	}



	public static <T> T getList(String key ) {
		SharedPreferences settings = context.getSharedPreferences(FILE_NAME_SHARED_PREF,  Context.MODE_PRIVATE);
		Gson gson = new Gson();
		String json = settings.getString(key, "");
		if(!json.isEmpty()){
			Type type = map.get(key);
			return gson.fromJson(json, type);
		}
		return null;
	}
}
