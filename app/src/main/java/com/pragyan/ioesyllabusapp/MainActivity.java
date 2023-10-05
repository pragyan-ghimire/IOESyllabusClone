package com.pragyan.ioesyllabusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ItemStructure> mArrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.appBar);
        recyclerView=findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        RecyclerItemAdapter adapter=new RecyclerItemAdapter(this,mArrayList);
        recyclerView.setAdapter(adapter);

        initializeArrayList();
        mArrayList.size();


    }

    public void initializeArrayList(){
        int[] img={R.drawable.first,R.drawable.second,R.drawable.third};
        for (int i = 0; i < img.length; i++) {
            mArrayList.add(new ItemStructure(img[i],getString(R.string.title),
                    getString(R.string.description)));
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
                    case R.id.day_mode:

                        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                        switch (nightModeFlags) {
                            case Configuration.UI_MODE_NIGHT_YES:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                Toast.makeText(MainActivity.this, "Day mode on", Toast.LENGTH_SHORT).show();
                                break;

                            case Configuration.UI_MODE_NIGHT_NO:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                Toast.makeText(MainActivity.this, "Night mode on", Toast.LENGTH_SHORT).show();
                                break;

                            case Configuration.UI_MODE_NIGHT_UNDEFINED:
//                                doStuff();
                                break;
                        }


                        break;
                    case R.id.notification:
                        Toast.makeText(MainActivity.this, "Clicked Notification", Toast.LENGTH_SHORT).show();
                        break;
                }
        return super.onOptionsItemSelected(item);
    }

    public void startSyllabusActivity(View view) {
        Intent intent=new Intent(this,SyllabusActivity.class);
        startActivity(intent);
    }
}