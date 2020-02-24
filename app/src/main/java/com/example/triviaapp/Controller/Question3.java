package com.example.triviaapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.triviaapp.R;

public class Question3 extends AppCompatActivity {
    public Button button_finish;
    public CheckBox checkBox_option1,checkBox_option2,checkBox_option3,checkBox_option4;
    String option1,option2,option3,option4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        checkBox_option1=(CheckBox) findViewById(R.id.option1);
        checkBox_option2=(CheckBox) findViewById(R.id.option2);
        checkBox_option3=(CheckBox) findViewById(R.id.option3);
        checkBox_option4=(CheckBox) findViewById(R.id.option4);
        Bundle bundle=getIntent().getExtras();
        final String user_name=bundle.getString("name");
        final String answer=bundle.getString("answer1");
        button_finish=(Button)findViewById(R.id.button_next);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result=new StringBuilder();
                if(checkBox_option1.isChecked()){
                    result.append("White,");
                }
                if(checkBox_option2.isChecked()){
                    result.append("Yellow,");
                }
                if(checkBox_option3.isChecked()){
                    result.append("Orange,");
                }
                if(checkBox_option4.isChecked()){
                    result.append("Green");
                }
                Intent intent=new Intent(Question3.this,Summary.class);
                intent.putExtra("name",user_name);
                intent.putExtra("answer",answer);
                intent.putExtra("color",result.toString());

                startActivity(intent);
            }
        });
    }
}
