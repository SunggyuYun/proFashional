package com.example.yungura.profashional;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDisplay extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdisplay);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }



}
