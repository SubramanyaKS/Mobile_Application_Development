package com.example.wallpapercangeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Timer myTimer;
    int prev=1;
    Drawable myDrawable;
    WallpaperManager myWallpmgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        myTimer=new Timer();
        myWallpmgr = WallpaperManager.getInstance(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
            }
        });
    }
    private void setWallpaper(){
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1){
                    myDrawable = getResources().getDrawable(R.drawable.one);
                    prev=2;
                }
                else if(prev==2){
                    myDrawable = getResources().getDrawable(R.drawable.two);
                    prev=3;
                }
                else if(prev==3){
                    myDrawable = getResources().getDrawable(R.drawable.three);
                    prev=4;
                }
                else if(prev==4){
                    myDrawable = getResources().getDrawable(R.drawable.four);
                    prev=5;
                }
                else if(prev==5){
                    myDrawable = getResources().getDrawable(R.drawable.five);
                    prev=1;
                }
                Bitmap wallpaper = ((BitmapDrawable)myDrawable).getBitmap();
                try{
                    myWallpmgr.setBitmap(wallpaper);
                }
                catch(IOException e){
                    e.getStackTrace();

                }
            }
        },0,30000);
    }
}