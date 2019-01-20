package com.example.screenshotapplication;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Screenshot {
    public static Bitmap takescreenshot(View vivek) {
        vivek.setDrawingCacheEnabled(true);
        vivek.buildDrawingCache(true);
        Bitmap c = Bitmap.createBitmap(v.getDrawingCache());
        vivek.setDrawingCacheEnabled(false);
        return c;
    }

    public static Bitmap takescreenshotofRootView(View vivek) {
        return takescreenshot(vivek.getRootView());
    }
}



