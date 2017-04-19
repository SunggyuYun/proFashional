package com.example.yungura.profashional;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Hompage extends AppCompatActivity {

    TextView tvTitle;

    Typeface typeFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hompage);

        typeFace = Typeface.createFromAsset(getAssets(), "fonts/ShadedLarch.ttf");
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setTypeface(typeFace);
    }
    public void onUserClick(View v)
    {
        if(v.getId() == R.id.bUser)
        {
            Intent i = new Intent(Hompage.this, LoginActivity.class);
            startActivity(i);
        }
    }


}

