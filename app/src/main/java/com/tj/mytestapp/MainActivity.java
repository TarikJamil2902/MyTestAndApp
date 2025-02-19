package com.tj.mytestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



import com.tj.mytestapp.adapters.UserAdapter;
import com.tj.mytestapp.databinding.ActivityMainBinding;
import com.tj.mytestapp.dbUtill.Database;
import com.tj.mytestapp.entity.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
private Button signupButton;
private Button loginButton;
    ArrayList<Users> dataArrayList = new ArrayList<>();
    UserAdapter listAdapter;
    Users listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Database db = new Database(getApplicationContext());
        dataArrayList= db.getAllUsers();

        listAdapter = new UserAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, dataArrayList.get(i).toString(), Toast.LENGTH_LONG).show();

//                Intent intent = new Intent(MainActivity.this, Detailed.class);
//                intent.putExtra("name", nameList[i]);
//                intent.putExtra("time", timeList[i]);
//                intent.putExtra("ingredients", ingredientList[i]);
//                intent.putExtra("desc", descList[i]);
//                intent.putExtra("image", imageList[i]);
//                startActivity(intent);
            }
        });
        signupButton = findViewById(R.id.onno_namtoo);
        loginButton = findViewById(R.id.onno_nam);

        loginButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Login.class));

        });
        signupButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SignUp.class));

        });
    }
}