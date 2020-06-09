package com.example.project_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Cat> cats = new ArrayList<>();

        cats.add(new Cat("Tom", "Persian", true));
        cats.add(new Cat("Pesho", "Bengal", true));
        cats.add(new Cat("Dori", "Siamese", false));
        cats.add(new Cat("Moris", "Persian", false));
        cats.add(new Cat("Cat", "Bengal", true));

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(cats);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
