package com.example.administrator.studentregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a1,a2;
    Button b1,b2;
    String s1,s2,getpass,getuname;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref=getSharedPreferences("mydata",MODE_PRIVATE);
        getuname=pref.getString("username",null);
        if(getuname!= null) {
            Intent j = new Intent(getApplicationContext(),welcomeActivity.class);
            startActivity(j);
        }

        a1=(EditText)findViewById(R.id.name);
        a2=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.login);
        b2=(Button)findViewById(R.id.register);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1=a1.getText().toString();
                s2=a2.getText().toString();

                Cursor cur=databaseHelper.searchdata(s1);

                if(cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no name found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {
                        getpass=cur.getString(5);
                        getuname=cur.getString(4);
                        String getemail=cur.getString(2);
                        String getmob=cur.getString(3);
                        String getname=cur.getString(1);

                        SharedPreferences.Editor editor=getSharedPreferences("mydata",MODE_PRIVATE).edit();
                        editor.putString("username",getuname);
                        editor.putString("name",getname);
                        editor.putString("mobile",getmob);
                        editor.putString("email",getemail);
                        editor.putString("password",getpass);


                        editor.apply();

                        if (getpass.equals(s1))
                        {
                            Intent i=new Intent(getApplicationContext(),welcomeActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"wrong password",Toast.LENGTH_LONG).show();
                        }

                    }
                }



//                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),registerActivity.class);
                startActivity(i);

            }
        });
    }
}
