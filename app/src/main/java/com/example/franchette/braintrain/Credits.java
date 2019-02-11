package com.example.franchette.braintrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Credits extends AppCompatActivity
{
Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        b=(Button)findViewById(R.id.back);
    }

    public void back(View view)
    {
        Intent intent=new Intent(this,MainMenu.class);
        startActivity(intent);
        finish();
    }
}
