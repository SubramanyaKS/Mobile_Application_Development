package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnStart,btnStop;
    int count=1;

    Handler custHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=findViewById(R.id.cValue);
        btnStart=findViewById(R.id.start);
        btnStop=findViewById(R.id.stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                custHandler.postDelayed(updateTimerThread,0);

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                custHandler.removeCallbacks(updateTimerThread);

            }
        });
    }
    private final Runnable updateTimerThread = new Runnable()
    {
        @Override
                public void run()
        {
            tvResult.setText(""+count);
            custHandler.postDelayed(updateTimerThread,1000);
            count++;
        }
    };
}