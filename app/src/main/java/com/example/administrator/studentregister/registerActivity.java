package com.example.administrator.studentregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    EditText a1,a2,a3,a4,a5;
    Button b1,b2;
    String s1,s2,s3,s4,s5;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        a1=(EditText)findViewById(R.id.name);
        a2=(EditText)findViewById(R.id.email);
        a3=(EditText)findViewById(R.id.mob);
        a4=(EditText)findViewById(R.id.uname);
        a5=(EditText)findViewById(R.id.password);
        b1=(Button) findViewById(R.id.register);
        b2=(Button) findViewById(R.id.alregister);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1=a1.getText().toString();
                s2=a2.getText().toString();
                s3=a3.getText().toString();
                s4=a4.getText().toString();
                s5=a5.getText().toString();

                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),s5,Toast.LENGTH_LONG).show();


                boolean status=databaseHelper.insertdata(s1,s2,s3,s4,s5);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"insert succesfully",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"insert error",Toast.LENGTH_LONG).show();
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
