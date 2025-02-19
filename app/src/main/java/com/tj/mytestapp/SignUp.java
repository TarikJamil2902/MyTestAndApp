package com.tj.mytestapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import com.tj.mytestapp.dbUtill.Database;
import com.tj.mytestapp.entity.Users;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    private EditText username, email, password, dob;
    private Button signupButton, loginButton;
//    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username_signup);
        email = findViewById(R.id.email_signup);
        password = findViewById(R.id.password_signup);
        dob = findViewById(R.id.dob_signup);

        signupButton = findViewById(R.id.onno_namtoo);
        loginButton = findViewById(R.id.onno_nam);
//        radioGroup.clearCheck();

        dob.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            // Open the DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(SignUp.this,
                    (view, selectedYear, selectedMonth, selectedDayOfMonth) -> {
                        // Set the selected date in the EditText
                        String selectedDate = selectedDayOfMonth + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        dob.setText(selectedDate);
                    }, year, month, dayOfMonth);
            datePickerDialog.show();
        });

//        radioGroup.setOnCheckedChangeListener(
//                new RadioGroup
//                        .OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(RadioGroup group,
//                                                 int checkedId) {
//
//                        // Get the selected Radio Button
//                        RadioButton
//                                radioButton
//                                = (RadioButton) group
//                                .findViewById(checkedId);
//                        Toast.makeText(getApplicationContext(),
//                                        radioButton.getText(),
//                                        Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                });

        // Handle SignUp button click
        signupButton.setOnClickListener(v -> {

            String user = username.getText().toString();
            String mail = email.getText().toString();
            String pass = password.getText().toString();
            String dateOfBirth = dob.getText().toString();
            String sub = "";

//            int selectedId = radioGroup.getCheckedRadioButtonId();
//            if (selectedId == -1) {
//                Toast.makeText(getApplicationContext(),
//                                "No answer has been selected",
//                                Toast.LENGTH_SHORT)
//                        .show();
//            } else {
//                RadioButton radioButton
//                        = (RadioButton) radioGroup
//                        .findViewById(selectedId);
//                sub = radioButton.getText().toString();
//            }

            // Validate fields
            if (user.isEmpty() || mail.isEmpty() || pass.isEmpty() || dateOfBirth.isEmpty()) {
                Toast.makeText(SignUp.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

           try {
//               Database db = new Database(getApplicationContext(), "myDb", null, 1);
               Database db = new Database(getApplicationContext());
               Users users = new Users(user, mail, pass, dateOfBirth);
                       db.insertUser(users);
           } catch (Exception e){
               e.printStackTrace();
           }

            // Example: After sign up is successful, move to login screen or home screen
            Toast.makeText(SignUp.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUp.this, MainActivity.class));  // Assume HomeActivity is your landing page
        });

        // Handle Login button click (navigate to login page)
        loginButton.setOnClickListener(v -> {
            startActivity(new Intent(SignUp.this, Login.class));

});
}
}