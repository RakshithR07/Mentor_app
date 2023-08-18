package com.example.project_mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, password;
    Button login;
    FloatingActionButton but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.btn);
        login.setOnClickListener(this);
        but = findViewById(R.id.back);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                finish();
            }
        });

    }

    String a="admin";
    String b="admin@123";

    @Override
    public void onClick(View v) {
        String user_name = user.getText().toString();
        String pass_word = password.getText().toString();
        if (user_name.equals(a) && pass_word.equals(b)) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            finish(); // Optional: Close the current LoginActivity
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }

    }
}