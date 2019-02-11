package com.example.franchette.braintrain;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import static com.example.franchette.braintrain.LoadingScreen.shouldPlay;

public class Testy extends AppCompatActivity
{
    MediaPlayer mp,ring;

     ImageView iv_picture;
    RadioGroup rg_choices;
    RadioButton rb_selected;

   RadioButton rb_choiceA;
    RadioButton rb_choiceB;
    RadioButton rb_choiceC;
    RadioButton rb_choiceD;

    Button b_submit;
    private int currentQuestionIndex;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testy);
        this.initialize();


        //BACKGROUND MUSIC
        ring = MediaPlayer.create(Testy.this, R.raw.music_3);
        ring.start();
        ring.setLooping(true);


    }

    private void initialize()
    {
        iv_picture = (ImageView) findViewById(R.id.image);
        rg_choices = (RadioGroup) findViewById(R.id.choices);

        rb_choiceA = (RadioButton) findViewById(R.id.a_rb);
        rb_choiceB = (RadioButton) findViewById(R.id.b_rb);
       rb_choiceC = (RadioButton) findViewById(R.id.c_rb);
       rb_choiceD = (RadioButton) findViewById(R.id.d_rb);
        b_submit = (Button) findViewById(R.id.btn_submit);

        currentQuestionIndex = 0;
        questions = new ArrayList<Question>();

        questions.add(new Question(R.mipmap.android,"Android Studio",
                "Visual Studio", "NetBeans", "Xcode","a"));

        questions.add(new Question(R.mipmap.elephant,
                "Java", "C Sharp", "PHP", "SQL","c"));

        questions.add(new Question(R.mipmap.visualstudio,"Microsoft Visual Studio", "Android Studio",
                "Xcode", "NetBeans","a"));

        questions.add(new Question(R.mipmap.javalogo, "Swift", "Java",
                "C++", "SQL", "b"));

        questions.add(new Question(R.mipmap.swift, "C++", "Java",
                "Swift", "SQL", "c"));

        questions.add(new Question(R.mipmap.xcode,"Xcode", "NetBeans",
                "Microsoft Visual Studio", "Android Studio","a"));

        questions.add(new Question(R.mipmap.python,"C Sharp", "Python",
                "Java", "SQL","b"));

        questions.add(new Question(R.mipmap.mascotjava,"C Sharp", "Turbo Pascal",
                "Java", "Python","c"));


        this.displayQuestion(currentQuestionIndex);
    }

    private void displayQuestion(int currentQuestionIndex)
    {
        iv_picture.setImageResource(questions.get(currentQuestionIndex).getPictureID());
        rb_choiceA.setText(questions.get(currentQuestionIndex).getChoiceA());
        rb_choiceB.setText(questions.get(currentQuestionIndex).getChoiceB());
        rb_choiceC.setText(questions.get(currentQuestionIndex).getChoiceC());
        rb_choiceD.setText(questions.get(currentQuestionIndex).getChoiceD());
       // rg_choices.clearCheck();
    }

    public void next(View v)
    {
        if (this.answerIsRight())
        {
            //Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(Testy.this, R.raw.correct);
            //music won't loop if false
            mp.setLooping(false);
            mp.start();
            advance();
        } else
        {
           // Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(Testy.this, R.raw.wrong);
            mp.setLooping(false);
            mp.start();
        }
    }

    private void advance()
    {
        currentQuestionIndex=(currentQuestionIndex+1)%questions.size();
        displayQuestion(currentQuestionIndex);
    }


    private boolean answerIsRight()
    {
        String answer = "x";

        int id = rg_choices.getCheckedRadioButtonId();
        rb_selected = (RadioButton) findViewById(id);
        if (rb_selected == rb_choiceA) answer = "a";
        if (rb_selected == rb_choiceB) answer = "b";
        if (rb_selected == rb_choiceC) answer = "c";
        if (rb_selected == rb_choiceD) answer = "d";



        return questions.get(currentQuestionIndex).isCorrectAnswer(answer);
    }

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

    public void main(View view)
    {
        Intent y=new Intent(this,MainMenu.class);
        startActivity(y);
        finish();
    }

}
