package com.example.screenshotapplication;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private View main;
    private ImageView image;
    private Bitmap a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        EditText editText6 = (EditText) findViewById(R.id.editText6);
        EditText editText7 = (EditText) findViewById(R.id.editText7);
        EditText editText8 = (EditText) findViewById(R.id.editText8);
        EditText editText9 = (EditText) findViewById(R.id.editText9);
        EditText editText10 = (EditText) findViewById(R.id.editText10);


        main = findViewById(R.id.main);
        image = (ImageView) findViewById(R.id.imageView);
        Button screenshot_button = (Button) findViewById(R.id.screenshot_button);
        screenshot_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                a = Screenshot.takescreenshotofRootView(image);
                image.setImageBitmap(a);
                main.setBackgroundColor(Color.parseColor("#997000"));

                String filename = "Screenshots_from_app"
                String path = Environment.getExternalStorageDirectory().toString() + "/" + filename;
                File save_spot = new File(path + "/Screenshots_from_Screenshot_app/");
                save_spot.mkdir();
                File filename1 = new File(save_spot, "screenshot.jpg");
                OutputStream out = null;
                Toast.makeText(getApplicationContext(), "Screenshot Saved!", Toast.LENGTH_SHORT).show();
                try {
                    out = new FileOutputStream(filename1);
                    // choose JPEG format
                    a.compress(Bitmap.CompressFormat.JPEG, 40, out);
                    out.flush();
                    out.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /*ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                a.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
                File f = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "test.jpg");
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileOutputStream fo = null;
                try {
                    fo = new FileOutputStream(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fo.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }
}



