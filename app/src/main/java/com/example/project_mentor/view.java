package com.example.project_mentor;

import androidx.appcompat.app.AppCompatActivity;


//import android.annotation.SuppressLint;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class view extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button clear,back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textView = findViewById(R.id.content1);
        clear=(Button)findViewById(R.id.clr);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFileContents();
            }
        });
        back=(Button)findViewById(R.id.bck);
        back.setOnClickListener(this);

        retrieveData();
    }


    private void clearFileContents() {
        String editTextFilename = "edittext_data.txt";

        try {
            // Delete the file
            File file = new File(getFilesDir(), editTextFilename);
            if (file.exists()) {
                file.delete();
            }

            // Create a new empty file
            file.createNewFile();

            // Clear the display text
            textView.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void retrieveData() {
        String editTextFilename = "edittext_data.txt";


        try {
            FileInputStream fis1 = openFileInput(editTextFilename);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(fis1));
            StringBuilder editTextData = new StringBuilder();
            String line;
            while ((line = br1.readLine()) != null) {
                editTextData.append(line).append("\n");
            }
            br1.close();

            String[] records = editTextData.toString().split("\n");

            StringBuilder displayText = new StringBuilder();
            for (String record : records) {
                // Split the record into separate values
                String[] editTextValues = record.split(",");

                // Access the values using editTextValues array
                String usn = editTextValues[0];
                String name = editTextValues[1];
                String sec = editTextValues[2];
                String mob = editTextValues[3];
                String sub1 = editTextValues[4];
                String sub2 = editTextValues[5];
                String sub3 = editTextValues[6];
                String sub4 = editTextValues[7];
                String sub5 = editTextValues[8];
                String sub6 = editTextValues[9];
                String sub11 = editTextValues[10];
                String sub21 = editTextValues[11];
                String sub31 = editTextValues[12];
                String sub41 = editTextValues[13];
                String sub51 = editTextValues[14];
                String sub61 = editTextValues[15];
                String sub12 = editTextValues[16];
                String sub22 = editTextValues[17];
                String sub32 = editTextValues[18];
                String sub42 = editTextValues[19];
                String sub52 = editTextValues[20];
                String sub62 = editTextValues[21];

                // Append the retrieved EditText values to the displayText
                displayText.append("USN: ").append(usn).append("\nName: ").append(name).append("\nSection: ").append(sec).append("\nMobile: ").append(mob)
                        .append("\nIA1:\n SUB1 ").append(sub1).append("\n SUB2 ").append(sub2).append("\n SUB3 ").append(sub3).append("\n SUB4 ").append(sub4).append("\n SUB5 ").append(sub5).append("\n SUB6 ").append(sub6)
                        .append("\nIA2:\n SUB1 ").append(sub11).append("\n SUB2 ").append(sub21).append("\n SUB3 ").append(sub31).append("\n SUB4 ").append(sub41).append("\n SUB5 ").append(sub51).append("\n SUB6 ").append(sub61)
                        .append("\nIA3:\n SUB1 ").append(sub12).append("\n SUB2 ").append(sub22).append("\n SUB3 ").append(sub32).append("\n SUB4 ").append(sub42).append("\n SUB5 ").append(sub52).append("\n SUB6 ").append(sub62)
                        .append("\n\n");
            }

            // Set the displayText to the textView
            textView.setText(displayText.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.equals(back))
        {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }
}
