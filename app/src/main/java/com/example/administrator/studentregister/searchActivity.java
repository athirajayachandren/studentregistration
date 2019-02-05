package com.example.administrator.studentregister;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class searchActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button editBut;
    String s1,s2,s3,s4,s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.email);
        ed3=(EditText)findViewById(R.id.mob);
        ed4=(EditText)findViewById(R.id.uname);
        ed5=(EditText)findViewById(R.id.password);
        editBut=(Button)findViewById(R.id.edit);
        SharedPreferences preferences=getSharedPreferences("mydata",MODE_PRIVATE);
        s1=preferences.getString("name",null);
        s2=preferences.getString("email",null);
        s3=preferences.getString("mobile",null);
        s4=preferences.getString("username",null);
        s5=preferences.getString("password",null);
        ed1.setText(s1);
        ed2.setText(s2);
        ed3.setText(s3);
        ed4.setText(s4);
        ed5.setText(s5);

        editBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
