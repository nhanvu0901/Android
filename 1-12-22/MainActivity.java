package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText firstName ,lastName,birthday,address,email;
    private Button registerBtn;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        firstName = (EditText) findViewById(R.id.idEdtUserFirstName);
        lastName = (EditText) findViewById(R.id.idEdtUserLastName);
        birthday = (EditText) findViewById(R.id.idEdtUserBirthday);
        address = (EditText) findViewById(R.id.editTextAdress);
        email = (EditText) findViewById(R.id.idEdtUserEmail);

        registerBtn =(Button) findViewById(R.id.idBtnRegister);

//        registerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // on below line we are getting data from our edit text.
//                String firstNameText = firstName.getText().toString();
//                String lastNameText = lastName.getText().toString();
//                String birthdayText = birthday.getText().toString();
//                String addressText = address.getText().toString();
//                String emailText = email.getText().toString();
//
//                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//                // checking if the entered text is empty or not.
//                if (TextUtils.isEmpty(firstNameText) || TextUtils.isEmpty(lastNameText) || TextUtils.isEmpty(birthdayText)||TextUtils.isEmpty(addressText)||TextUtils.isEmpty(emailText) ) {
//                    Toast.makeText(MainActivity.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
//                }
//                else if(!emailText.matches(emailPattern)){
//                    Toast.makeText(MainActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
//                    i.putExtra("username", firstNameText);
//                    startActivity(i);
//                }
//
//
//            }
//        });
    }
    }

