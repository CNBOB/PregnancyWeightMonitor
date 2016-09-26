package com.namilili.pregnancyweightmonitor;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesEdit
{

	public static final String SP_FILENAME = "PregnacyWeightMonitor"; // 文件名称
	public static final String SP_UUID = "UUID";

	public static String fileName(Context context)
	{
		return SP_FILENAME;
	}

	public static boolean updateSharedPreferencesString(Context context,
			String fileName, String key, String value)
	{
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			settings.edit().putString(key, value == null ? "" : value).commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean updateSharedPreferencesInteger(Context context,
			String fileName, String key, int value)
	{
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			settings.edit().putInt(key, value).commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean updateSharedPreferencesBoolean(Context context,
			String fileName, String key, boolean value)
	{
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			settings.edit().putBoolean(key, value).commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean updateSharedPreferencesLong(Context context,
			String fileName, String key, long value)
	{
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			settings.edit().putLong(key, value).commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean updateSharedPreferencesFloat(Context context,
			String fileName, String key, float value)
	{
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			settings.edit().putFloat(key, value).commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean initSharedPreferences(Context context,
			String fileName, String key)
	{
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			settings.edit().putString(key, "").commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static String querySharedPreferencesString(Context context,
			String fileName, String key)
	{
		String value = "";
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			value = settings.getString(key, "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
		return value;
	}

	public static Boolean querySharedPreferencesBoolean(Context context,
			String fileName, String key)
	{
		Boolean value = true;
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			value = settings.getBoolean(key, true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return value;
	}

	public static Integer querySharedPreferencesInt(Context context,
			String fileName, String key)
	{
		int value = 0;
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			value = settings.getInt(key, 0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		return value;
	}

	public static Long querySharedPreferencesLong(Context context,
			String fileName, String key)
	{
		long value = 0;
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			value = settings.getLong(key, 0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return value;
		}
		return value;
	}

	public static Float querySharedPreferencesFloat(Context context,
			String fileName, String key)
	{
		float value = 0;
		try
		{
			SharedPreferences settings = context.getSharedPreferences(fileName,
					Context.MODE_PRIVATE);
			value = settings.getFloat(key, 0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return value;
		}
		return value;
	}
}
