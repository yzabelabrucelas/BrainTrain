package com.example.franchette.braintrain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.franchette.braintrain.LoadingScreen.shouldPlay;

public class MainMenu extends AppCompatActivity
{
    final Context context = this;
    ImageButton btn_credits;
    TextView main_menu;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btn_credits=(ImageButton)findViewById(R.id.imgbtn_credits);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //ANIMATION
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        main_menu = (TextView) findViewById(R.id.main);
        main_menu.startAnimation(animation);


    }

    public void TextTwist(View view)
    {
        Intent i = new Intent(this,TextTwist.class);
        startActivity(i);
    }

    public void choice(View view)
    {
        Intent q = new Intent(this,Testy.class);
        startActivity(q);
    }

    public void credits(View view)
    {
        Intent w = new Intent(this,Credits.class);
        startActivity(w);
    }


}
