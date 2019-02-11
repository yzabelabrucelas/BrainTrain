package com.example.franchette.braintrain;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class LoadingScreen extends AppCompatActivity
{

    TextView tvstart;

    MediaPlayer mp;


    public static boolean shouldPlay = false;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //FULL SCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading_screen);

        //SPLASH SCREEN
        tvstart = (TextView)findViewById(R.id.tvStart);

            mp = MediaPlayer.create(LoadingScreen.this, R.raw.music);
            mp.setLooping(true);
            mp.start();

//START NEW INTENT AUTOMATICALLY
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {


                Intent mainIntent = new Intent(LoadingScreen.this, MainMenu.class);
                startActivity(mainIntent);
                finish();
            }
        }, 6000);

    }

    @Override
public void onStop()
{
    super.onStop();
    if (!shouldPlay)
    {
        mp.pause();
        mp = null;
    }
}

    public void onPause(){
        super.onPause();
        mp.pause();
    }
    @Override
    public void onResume()
    {
        super.onResume();
        mp.start();

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //ANIMATION
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        tvstart = (TextView) findViewById(R.id.tvStart);
        tvstart.startAnimation(animation);


    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        MediaPlayer mp = new MediaPlayer();
        mp.stop();
    }

}
