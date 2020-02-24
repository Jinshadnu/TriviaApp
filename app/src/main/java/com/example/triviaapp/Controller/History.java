package com.example.triviaapp.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.triviaapp.Adpter.RecyclerAdapter;
import com.example.triviaapp.Model.Answers;
import com.example.triviaapp.R;

import java.util.List;

public class History extends AppCompatActivity {
public RecyclerView recyclerView;
RecyclerAdapter recyclerAdapter;
public List<Answers> answersList;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView=(RecyclerView)findViewById(R.id.reyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        databaseHelper=new DatabaseHelper(this);
        answersList=databaseHelper.getAllData();
        recyclerAdapter=new RecyclerAdapter(this,answersList);
        recyclerView.setAdapter(recyclerAdapter);

    }

}
