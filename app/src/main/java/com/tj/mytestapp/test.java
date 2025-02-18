package com.tj.mytestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class test extends AppCompatActivity {

    Button btnAdd, btnClear;
    TextView tvShow;
    ImageView iv;

Integer val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);


        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);

        tvShow = findViewById(R.id.countView);
        iv = findViewById(R.id.imageView1);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val++;
                tvShow.setText("" +val);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val = 0;
                tvShow.setText("" +val);
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(test.this, "Image clicked!", Toast.LENGTH_SHORT).show();
            }
        });


//        Button btnAdd = findViewById(R.id.buttonAdd);
//        Button btnClear = findViewById(R.id.buttonClear);
    }
}