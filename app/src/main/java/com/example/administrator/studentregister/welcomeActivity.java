package com.example.administrator.studentregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomeActivity extends AppCompatActivity {
    TextView tv;
    Button editAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        editAct=(Button)findViewById(R.id.profile);
        tv=(TextView)findViewById(R.id.textdisp);
        SharedPreferences preferences=getSharedPreferences("mydata",MODE_PRIVATE);
        String data=preferences.getString("username",null);
        tv.setText("welcome "+data);
        editAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),searchActivity.class);
                startActivity(i);
            }
        });
    }
}
