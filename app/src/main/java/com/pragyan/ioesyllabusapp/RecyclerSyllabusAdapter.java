package com.pragyan.ioesyllabusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerSyllabusAdapter extends RecyclerView.Adapter<RecyclerSyllabusAdapter.ViewHolder> {
    ArrayList<SyllabusStructure> sArrayList;

    Context context;
    LayoutInflater layoutInflater;
    public RecyclerSyllabusAdapter(Context context,ArrayList<SyllabusStructure> sArrayList ) {
        this.sArrayList = sArrayList;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);

    }



    @NonNull
    @Override
    public RecyclerSyllabusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.syllabus_department_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSyllabusAdapter.ViewHolder holder, int position) {
        holder.tv_department.setText(sArrayList.get(position).getDepartment());
    }

    @Override
    public int getItemCount() {
        return sArrayList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_department;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_department=itemView.findViewById(R.id.tv_department);
        }
    }
}
