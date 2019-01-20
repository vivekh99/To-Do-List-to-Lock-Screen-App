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
    public static Bitmap takescreenshot(View v) {
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache(true);
        Bitmap b = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        return b;
    }

    public static Bitmap takescreenshotofRootView(View v) {
        return takescreenshot(v.getRootView());
    }
}


    /*File path = Environment.getExternalStorageDirectory();// + "/Screenshots_from_Screenshot_app/";
    File dir = new File(path + "/Screenshots_from_Screenshot_app/");
                dir.mkdir();
                        File filename = new File(dir, "screenshot.jpg");
                        OutputStream out = null;
                        try {
                        out = new FileOutputStream(filename);
                        // choose JPEG format
                        a.compress(Bitmap.CompressFormat.JPEG, 40, out);
                        out.flush();
                        out.close();

                        } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        } catch (IOException e) {
                        e.printStackTrace();
                        }
*/


