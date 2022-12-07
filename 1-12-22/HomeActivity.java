package com.example.register;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.register.R;

public class HomeActivity extends AppCompatActivity {

    // creating a variable for our text view..
    private TextView userNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // initializing our variables
        userNameTV = findViewById(R.id.idTVUserName);

        // getting data from intent.
        String name = getIntent().getStringExtra("username");

        // setting data to our text view.
        userNameTV.setText(name);
    }
}