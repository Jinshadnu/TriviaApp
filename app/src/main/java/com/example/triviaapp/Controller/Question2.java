package com.example.triviaapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.triviaapp.R;

public class Question2 extends AppCompatActivity {
    public Button button_next;
    public RadioGroup radioGroup;
    public RadioButton option1,option2,option3,option4;
    public String selectedRadioButtonText;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_cricketer);
        button_next=(Button)findViewById(R.id.button_next);
        radioGroup=(RadioGroup)findViewById(R.id.options);
        Bundle bundle=getIntent().getExtras();
        final String name=bundle.getString("name");
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the checked Radio Button ID from Radio Grou[
                int selectedRadioButtonID = radioGroup.getCheckedRadioButtonId();
               // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID != -1) {

                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    selectedRadioButtonText = selectedRadioButton.getText().toString();

                }
                else{

                }
                Intent intent=new Intent(Question2.this,Question3.class);
                intent.putExtra("name",name);
                intent.putExtra("answer1",selectedRadioButtonText);
                startActivity(intent);
            }
        });


    }
}
