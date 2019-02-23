package com.example.troy.flashapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Boolean turnOn = true;

    Handler timerHandler = new Handler();
    Button btn;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.siren);
    btn = findViewById(R.id.button);
    btn2 = findViewById(R.id.button2);


    System.out.println("before the loop");
    timerHandler.postDelayed(timerRunnable, 0); //start stopwatch

    MediaPlayer myMediaPlayer = MediaPlayer.create(this,R.raw.sirennoisekevan);
    myMediaPlayer.setLooping(true);
    myMediaPlayer.start();

    }
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {


            if(turnOn==true){
                btn.setBackgroundColor(Color.RED);
                btn2.setBackgroundColor(Color.BLUE);
                turnOn=false;

            }else{
                btn.setBackgroundColor(Color.BLUE);
                btn2.setBackgroundColor(Color.RED);
                turnOn=true;
            }


            timerHandler.postDelayed(this, 200);
        }
    };

}
