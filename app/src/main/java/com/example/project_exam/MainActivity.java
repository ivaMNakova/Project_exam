package com.example.project_exam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Cat> cats = new ArrayList<>();
    private MyRecyclerViewAdapter adapter;

    private static final int REQUEST_CODE = 99;

    private Cat selectedCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =  findViewById(R.id.recyclerView);


        cats.add(new Cat("Tom", "Persian", true));
        cats.add(new Cat("Pesho", "Bengal", true));
        cats.add(new Cat("Dori", "Siamese", false));
        cats.add(new Cat("Moris", "Persian", false));
        cats.add(new Cat("Cat", "Bengal", false));

        adapter = new MyRecyclerViewAdapter(cats);
        adapter.setClickListener(new MyRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedCat = cats.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("cat_name", selectedCat.getName());
                intent.putExtra("cat_breed", selectedCat.getBreed());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            selectedCat.setStatus(true);
            adapter.notifyDataSetChanged();
        }
    }
}
