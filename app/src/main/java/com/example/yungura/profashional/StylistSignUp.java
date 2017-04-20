package com.example.yungura.profashional;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.yungura.profashional.R.id.Bssignupbutton;

public class StylistSignUp extends Activity {

    TextView tvUserSignUp;

    Typeface typeFace;
    StylistDatabaseHelper helper = new StylistDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stylistsignup);

        typeFace = Typeface.createFromAsset(getAssets(), "fonts/ShadedLarch.ttf");
        tvUserSignUp = (TextView) findViewById(R.id.tvUserSignUp);
        tvUserSignUp.setTypeface(typeFace);
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == Bssignupbutton)
        {
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText uname = (EditText)findViewById(R.id.TFuname);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                //popup msg
                Toast pass = Toast.makeText(StylistSignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert the details in database
                StylistContact c = new StylistContact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
            }

        }
        if(v.getId() == R.id.Bssignupbutton)
        {
            Intent i = new Intent(StylistSignUp.this, StylistLoginActivity.class);
            startActivity(i);
        }


    }

}
