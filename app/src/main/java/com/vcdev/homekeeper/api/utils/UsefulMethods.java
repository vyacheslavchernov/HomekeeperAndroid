package com.vcdev.homekeeper.api.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.vcdev.homekeeper.R;

public class UsefulMethods {
    public static void setStatusBar(Window window, Context context) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(ContextCompat.getColor(context, com.google.android.material.R.color.abc_background_cache_hint_selector_material_light));
    }
}
