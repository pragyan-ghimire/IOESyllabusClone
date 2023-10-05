package com.pragyan.ioesyllabusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SyllabusActivity extends AppCompatActivity {
    ArrayList<SyllabusStructure> sArrayList=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        recyclerView=findViewById(R.id.recyclerViewSyllabus);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerSyllabusAdapter adapter=new RecyclerSyllabusAdapter(this,sArrayList);
        recyclerView.setAdapter(adapter);
        initialize();
    }
    public void initialize(){
        String[] syllabusArray= getResources().getStringArray(R.array.department_list);
        for (int i = 0; i < syllabusArray.length; i++) {
            sArrayList.add(new SyllabusStructure(syllabusArray[i]));
        }
    }
}