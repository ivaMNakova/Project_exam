package com.example.project_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView catName;
    private TextView catBreed;
    private TextView startBtn;
    private TextView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        String catNameText = getIntent().getStringExtra("cat_name");
        String catBreedText = getIntent().getStringExtra("cat_breed");

        catName = findViewById(R.id.cat_name);
        catBreed = findViewById(R.id.cat_breed);
        startBtn = findViewById(R.id.start);
        backBtn = findViewById(R.id.back);

        catName.setText(catNameText);
        catBreed.setText(catBreedText);

        startBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
