package com.example.triviaapp.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapp.Model.Answers;
import com.example.triviaapp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    public Context context;
    public List<Answers> answersList;

    public RecyclerAdapter(Context context, List<Answers> answersList) {
        this.context = context;
        this.answersList = answersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.textView_name.setText(answersList.get(position).getName());
    holder.textView_cricketer.setText(answersList.get(position).getCricketer_name());
    holder.textView_colors.setText(answersList.get(position).getFlag_color());
    }

    @Override
    public int getItemCount() {
        return answersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name,textView_cricketer,textView_colors;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_name=(TextView)itemView.findViewById(R.id.text_name);
            textView_cricketer=(TextView)itemView.findViewById(R.id.text_cricketer);
            textView_colors=(TextView)itemView.findViewById(R.id.text_colors);


        }
    }
}
