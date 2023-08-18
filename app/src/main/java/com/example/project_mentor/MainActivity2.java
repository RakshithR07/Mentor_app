package com.example.project_mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    Button badd,bv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        badd=(Button) findViewById(R.id.btnadd);
        bv=(Button) findViewById(R.id.btnview1);
        badd.setOnClickListener(this);
        bv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(badd))
        {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }
        if(v.equals(bv))
        {
            Intent intent = new Intent(this, ViewStudent.class);
            startActivity(intent);
        }

    }
}