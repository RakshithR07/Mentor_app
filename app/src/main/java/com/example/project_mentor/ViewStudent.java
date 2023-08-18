package com.example.project_mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewStudent extends AppCompatActivity implements View.OnClickListener {

    Button sub1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        sub1=(Button)findViewById(R.id.btnsub1);
        sub1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.equals(sub1))
        {
            Intent intent = new Intent(this, view.class);
            startActivity(intent);
        }

    }
}