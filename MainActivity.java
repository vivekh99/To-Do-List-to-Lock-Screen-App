package com.example.screenshotapplication;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private View main;
    private ImageView image;
    private Bitmap a;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedEditor;

    CheckBox checkBox1;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    EditText editText9;
    EditText editText10;
    EditText edittextName;
    Button screenshotbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SET_WALLPAPER}, 1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        edittextName = (EditText) findViewById(R.id.editTextName);
        screenshotbtn = (Button) findViewById(R.id.screenshot_button);
        Button galleryBtn = (Button) findViewById(R.id.galleryBtn);
        //Button lsWallpaper = (Button) findViewById(R.id.LockScreenbtn);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        sharedEditor = sharedPreferences.edit();

        checkSharedPreferences();

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Text has been Saved! Closing out of the app will not delete the input", Toast.LENGTH_LONG).show();
                    //for checkbox
                    sharedEditor.putString(getString(R.string.checkbox), "True");
                    sharedEditor.commit();
                    //for list name
                    String edittextNAME = edittextName.getText().toString();
                    sharedEditor.putString(getString(R.string.editTextname), edittextNAME);
                    sharedEditor.commit();
                    //for task 1
                    String edittext1 = editText1.getText().toString();
                    sharedEditor.putString(getString(R.string.editText1), edittext1);
                    sharedEditor.commit();
                    //for task 2
                    String edittext2 = editText2.getText().toString();
                    sharedEditor.putString(getString(R.string.editText2), edittext2);
                    sharedEditor.commit();
                    //for task 3
                    String edittext3 = editText3.getText().toString();
                    sharedEditor.putString(getString(R.string.editText3), edittext3);
                    sharedEditor.commit();
                    //for task 4
                    String edittext4 = editText4.getText().toString();
                    sharedEditor.putString(getString(R.string.editText4), edittext4);
                    sharedEditor.commit();
                    //for task 5
                    String edittext5 = editText5.getText().toString();
                    sharedEditor.putString(getString(R.string.editText5), edittext5);
                    sharedEditor.commit();
                    //for task 6
                    String edittext6 = editText6.getText().toString();
                    sharedEditor.putString(getString(R.string.editText6), edittext6);
                    sharedEditor.commit();
                    //for task 7
                    String edittext7 = editText7.getText().toString();
                    sharedEditor.putString(getString(R.string.editText7), edittext7);
                    sharedEditor.commit();
                    //for task 8
                    String edittext8 = editText8.getText().toString();
                    sharedEditor.putString(getString(R.string.editText8), edittext8);
                    sharedEditor.commit();
                    //for task 9
                    String edittext9 = editText9.getText().toString();
                    sharedEditor.putString(getString(R.string.editText9), edittext9);
                    sharedEditor.commit();
                    //for task 10
                    String edittext10 = editText10.getText().toString();
                    sharedEditor.putString(getString(R.string.editText10), edittext10);
                    sharedEditor.commit();
                } else {
                    //for checkbox
                    sharedEditor.putString(getString(R.string.checkbox), "False");
                    sharedEditor.commit();
                    //for list name
                    sharedEditor.putString(getString(R.string.editTextname), "");
                    sharedEditor.commit();
                    //for task 1
                    sharedEditor.putString(getString(R.string.editText1), "");
                    sharedEditor.commit();
                    //for task 2
                    sharedEditor.putString(getString(R.string.editText2), "");
                    sharedEditor.commit();
                    //for task 3
                    sharedEditor.putString(getString(R.string.editText3), "");
                    sharedEditor.commit();
                    //for task 4
                    sharedEditor.putString(getString(R.string.editText4), "");
                    sharedEditor.commit();
                    //for task 5
                    sharedEditor.putString(getString(R.string.editText5), "");
                    sharedEditor.commit();
                    //for task 6
                    sharedEditor.putString(getString(R.string.editText6), "");
                    sharedEditor.commit();
                    //for task 7
                    sharedEditor.putString(getString(R.string.editText7), "");
                    sharedEditor.commit();
                    //for task 8
                    sharedEditor.putString(getString(R.string.editText8), "");
                    sharedEditor.commit();
                    //for task 9
                    sharedEditor.putString(getString(R.string.editText9), "");
                    sharedEditor.commit();
                    //for task 10
                    sharedEditor.putString(getString(R.string.editText10), "");
                    sharedEditor.commit();
                }
            }
        });

        main = findViewById(R.id.main);
        image = (ImageView) findViewById(R.id.imageView);
        Button screenshot_button = (Button) findViewById(R.id.screenshot_button);

        screenshot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Screenshot.takescreenshotofRootView(image);
                image.setImageBitmap(a);

                //String filename = "Screenshots_from_app";
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);//.toString() + "/" + filename;
                File save_spot = new File(path + "/Camera/Vivek's_Screenshots");
                save_spot.mkdir();
                File filename = new File(save_spot, "Vivek's Screenshot");
                OutputStream out = null;
                Toast.makeText(getApplicationContext(), "Screenshot Saved! Open Gallery to View", Toast.LENGTH_SHORT).show();
                try {
                    out = new FileOutputStream(filename);
                    a.compress(Bitmap.CompressFormat.JPEG, 60, out);
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                MediaScannerConnection.scanFile(getApplicationContext(), new String[]{filename.getPath()}, new String[]{"image/jpeg"}, null);
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_gallery = new Intent(Intent.ACTION_VIEW);
                open_gallery.setType("image/*");
                startActivity(open_gallery);
            }
        });
    }

    public void checkSharedPreferences() {
        String checkbox = sharedPreferences.getString(getString(R.string.checkbox), "False");
        String txtName = sharedPreferences.getString(getString(R.string.editTextname), "");
        String text1 = sharedPreferences.getString(getString(R.string.editText1), "");
        String text2 = sharedPreferences.getString(getString(R.string.editText2), "");
        String text3 = sharedPreferences.getString(getString(R.string.editText3), "");
        String text4 = sharedPreferences.getString(getString(R.string.editText4), "");
        String text5 = sharedPreferences.getString(getString(R.string.editText5), "");
        String text6 = sharedPreferences.getString(getString(R.string.editText6), "");
        String text7 = sharedPreferences.getString(getString(R.string.editText7), "");
        String text8 = sharedPreferences.getString(getString(R.string.editText8), "");
        String text9 = sharedPreferences.getString(getString(R.string.editText9), "");
        String text10 = sharedPreferences.getString(getString(R.string.editText10), "");

        edittextName.setText(txtName);
        editText1.setText(text1);
        editText2.setText(text2);
        editText3.setText(text3);
        editText4.setText(text4);
        editText5.setText(text5);
        editText6.setText(text6);
        editText7.setText(text7);
        editText8.setText(text8);
        editText9.setText(text9);
        editText10.setText(text10);

        if (checkBox1.equals("True")) {
            checkBox1.setChecked(true);
        } else {
            checkBox1.setChecked(false);
        }
    }
}



