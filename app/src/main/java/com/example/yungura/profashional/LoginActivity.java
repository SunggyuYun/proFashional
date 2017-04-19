package com.example.yungura.profashional;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    TextView tvUserSignIn;

    Typeface typeFace;

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        typeFace = Typeface.createFromAsset(getAssets(), "fonts/ShadedLarch.ttf");
        tvUserSignIn = (TextView) findViewById(R.id.tvUserSignIn);
        tvUserSignIn.setTypeface(typeFace);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.Blogin)
        {
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                Intent i = new Intent(LoginActivity.this, Display.class);
                i.putExtra("Username",str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(LoginActivity.this, "Username and password don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }





        }
        if(v.getId() == R.id.Bsignup)
        {
            Intent i = new Intent(LoginActivity.this, SignUp.class);
            startActivity(i);
        }
    }



}
