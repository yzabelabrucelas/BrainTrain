package com.example.franchette.braintrain;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.franchette.braintrain.LoadingScreen.shouldPlay;

public class TextTwist extends AppCompatActivity implements View.OnClickListener
{

    TextView wordTv;
    EditText wordEnteredTv;
    Button validate, newGame;
    String wordToFind;
    ImageButton shuffle,btn_back;

    MediaPlayer mp,ring;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_twist);


        wordTv = (TextView) findViewById(R.id.wordTv);
        wordEnteredTv = (EditText) findViewById(R.id.wordEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
        newGame = (Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(this);
        shuffle = (ImageButton) findViewById(R.id.shuffle);
        btn_back=(ImageButton)findViewById(R.id.imgbtn_back);
        shuffle.setOnClickListener(this);


        newGame();

        //BACKGROUND MUSIC
        ring = MediaPlayer.create(TextTwist.this, R.raw.music_2);
        ring.start();
        ring.setLooping(true);
    }


    @Override
    public void onClick(View view)
    {
        if (view == validate)
        {
            validate();
        }
        else if(view == shuffle)
        {
            shuffle();
        }
        else if (view == newGame)
        {
            newGame();
        }
    }

    public void main(View view)
    {
        Intent y=new Intent(this,MainMenu.class);
        startActivity(y);
        finish();
    }

    private void validate()
    {
        String w = wordEnteredTv.getText().toString();

        if(w.equals(""))
        {
           // Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();

            mp = MediaPlayer.create(TextTwist.this, R.raw.wrong);
            mp.setLooping(false);
            mp.start();
        }
        else
        {
            if (wordToFind.equals(w))
            {

               // Toast.makeText(this, "Congratulations! You found the word " + wordToFind, Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(TextTwist.this, R.raw.correct);
                //music won't loop if false
                mp.setLooping(false);
                mp.start();
                newGame();
            }
            else
            {
              //  Toast.makeText(this, "Retry!", Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(TextTwist.this, R.raw.wrong);
                mp.setLooping(false);
                mp.start();
            }
        }
        }


    private void newGame()
    {
        wordToFind = Anagram.randomWord();
        String wordShuffled = Anagram.shuffleWord(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");
    }

    private void shuffle()
    {
        String wordShuffled = Anagram.shuffleWord(wordToFind);
       wordTv.setText(wordShuffled);
    }
/*
    public void exit(View view)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Quit Game");
        builder.setMessage("Are you sure you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                //finish();
                Intent we=new Intent(TextTwist.this,MainMenu.class);
                startActivity(we);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent h=new Intent(TextTwist.this,TextTwist.class);
                startActivity(h);

            }
        });
        builder.create().show();
    }
*/

   /* //EXIT ALERT DIALOG
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this,"Back clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(this,"Quit clicked",Toast.LENGTH_SHORT).show();
                break;


        }
        return true;

    }
*/
    @Override
    public void onStop()
    {
        super.onStop();
        if (!shouldPlay)
        {
            ring.pause();
            ring = null;
        }
    }



}
