package com.pgq.simpleweather.Utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
	private final static int LONG  = Toast.LENGTH_LONG;
	private final static int SHORT = Toast.LENGTH_SHORT;

	/**
	 * 消息 String
	 *
	 * @param context
	 * @param msg
	 */
	public static void info(Context context, String msg) {
		Toast.makeText(context, msg, SHORT).show();
	}

	/**
	 * 消息 int
	 *
	 * @param context
	 * @param msg
	 */
	public static void info(Context context, int msg) {
		Toast.makeText(context, msg, SHORT).show();
	}
}
