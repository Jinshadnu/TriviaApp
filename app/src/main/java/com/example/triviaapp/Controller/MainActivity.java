package com.example.triviaapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.triviaapp.R;

public class MainActivity extends AppCompatActivity {
public Button button_name;
public EditText editText_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_name=(Button)findViewById(R.id.button_next);
        editText_name=(EditText)findViewById(R.id.name);
        button_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getData();
            }
        });

    }
    public void getData(){
        String name=editText_name.getText().toString();
        Intent intent=new Intent(MainActivity.this,Question2.class);
        intent.putExtra("name",name);
        startActivity(intent);


    }
}
