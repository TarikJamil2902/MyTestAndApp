package com.tj.mytestapp;





import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tj.mytestapp.dbUtill.Database;

public class Login extends AppCompatActivity {


    EditText username, password;
    Button loginButton;
    TextView signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextLoginUsername);
        password = findViewById(R.id.editTextLoginPassword);

        loginButton = findViewById(R.id.buttonLogin);
        signUp = findViewById(R.id.textViewNewUser);


        loginButton.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            // Validate fields
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(Login.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
//                Database db = new Database(getApplicationContext(), "DB_NAME", null, DB_VERSION);
                Database db = new Database(getApplicationContext());
                int val = db.loginUser(user, pass);

                if (val < 1) {
                    Toast.makeText(Login.this, "Invalid User name and Password!!!", Toast.LENGTH_LONG).show();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, MainActivity.class));  // Assume HomeActivity is your landing page
        });

        // Handle Login button click (navigate to login page)
        signUp.setOnClickListener(v -> {

            startActivity(new Intent(Login.this, SignUp.class));
     });


}
}