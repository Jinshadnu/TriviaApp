package com.example.triviaapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.triviaapp.R;

public class Summary extends AppCompatActivity {
public TextView textView_name,textView_answer1,textView_answer2;
Button button_finish,button_history;
public DatabaseHelper databaseHelper;
    String name,answer1,answer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper=new DatabaseHelper(this);
        setContentView(R.layout.activity_summary);
        button_finish=(Button)findViewById(R.id.button_finish);
        button_history=(Button)findViewById(R.id.button_history);
        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("name");
        answer1=bundle.getString("answer");
        answer2=bundle.getString("color");
        textView_name=(TextView)findViewById(R.id.text_name);
        textView_answer1=(TextView)findViewById(R.id.answer1);
        textView_answer2=(TextView)findViewById(R.id.answer2);
        textView_name.setText("Hello " + name);
        textView_answer1.setText("Answer: " + answer1);
        textView_answer2.setText("Answer: " + answer2);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),History.class);
                startActivity(intent);
            }
        });




    }
    //To insert data into Database
    public void addUser(){
        long id=databaseHelper.insert(name,answer1,answer2);
    }
}
