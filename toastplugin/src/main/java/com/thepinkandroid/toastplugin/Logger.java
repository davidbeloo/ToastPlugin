package com.thepinkandroid.toastplugin;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by david beloosesky on 1/17/2017.
 */

public class Logger {
    public static final String LOG_TAG = Logger.class.getSimpleName();
    protected Activity mCurrentActivity;

    public void setActivity(Activity activity)
    {
        mCurrentActivity = activity;
    }

    // Displays a Toast message and log an event
    public void logEvent(final String message)
    {
        if (mCurrentActivity == null) {
            Log.e(LOG_TAG, "Android Activity not set in plugin");
            return;
        }

        Log.d(LOG_TAG, "Event info: " + message);

        mCurrentActivity.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(mCurrentActivity, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
