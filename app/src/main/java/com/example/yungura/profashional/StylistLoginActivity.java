package com.example.yungura.profashional;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class StylistLoginActivity extends AppCompatActivity {

    TextView tvStylistSignIn;

    Typeface typeFace;

    StylistDatabaseHelper helper = new StylistDatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stylistlogin);

        typeFace = Typeface.createFromAsset(getAssets(), "fonts/ShadedLarch.ttf");
        tvStylistSignIn = (TextView) findViewById(R.id.tvStylistSignIn);
        tvStylistSignIn.setTypeface(typeFace);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.Bslogin)
        {
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                Intent i = new Intent(StylistLoginActivity.this, StylistDisplay.class);
                i.putExtra("Username",str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(StylistLoginActivity.this, "Username and password don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }





        }
        if(v.getId() == R.id.Bssignup)
        {
            Intent i = new Intent(StylistLoginActivity.this, StylistSignUp.class);
            startActivity(i);
        }
    }



}
