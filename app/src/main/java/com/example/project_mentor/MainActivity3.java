package com.example.project_mentor;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button submit;
    Button sendmsg;
    EditText tusn, tname, tsec, tmob;
    EditText S1, S2, S3, S4, S5, S6;
    EditText S11, S21, S31, S41, S51, S61;
    EditText S12, S22, S32, S42, S52, S62;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tusn = findViewById(R.id.usn);
        tname = findViewById(R.id.name);
        tsec = findViewById(R.id.sec);
        tmob = findViewById(R.id.phone);
        S1 = findViewById(R.id.m1);
        S2 = findViewById(R.id.m2);
        S3 = findViewById(R.id.m3);
        S4 = findViewById(R.id.m4);
        S5 = findViewById(R.id.m5);
        S6 = findViewById(R.id.m6);
        S11 = findViewById(R.id.m11);
        S21 = findViewById(R.id.m21);
        S31 = findViewById(R.id.m31);
        S41 = findViewById(R.id.m41);
        S51 = findViewById(R.id.m51);
        S61 = findViewById(R.id.m61);
        S12 = findViewById(R.id.m12);
        S22 = findViewById(R.id.m22);
        S32 = findViewById(R.id.m32);
        S42 = findViewById(R.id.m42);
        S52 = findViewById(R.id.m52);
        S62 = findViewById(R.id.m62);

        submit = findViewById(R.id.sub);
        submit.setOnClickListener(this);
        sendmsg = findViewById(R.id.send);
        sendmsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(submit)) {
            saveData();
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        } else if (v.equals(sendmsg)) {
            sendMessage();
        }
    }

    private void saveData() {
        String usn = tusn.getText().toString();
        String name = tname.getText().toString();
        String sec = tsec.getText().toString();
        String mob = tmob.getText().toString();
        String sub1 = S1.getText().toString();
        String sub2 = S2.getText().toString();
        String sub3 = S3.getText().toString();
        String sub4 = S4.getText().toString();
        String sub5 = S5.getText().toString();
        String sub6 = S6.getText().toString();
        String sub11 = S11.getText().toString();
        String sub21 = S21.getText().toString();
        String sub31 = S31.getText().toString();
        String sub41 = S41.getText().toString();
        String sub51 = S51.getText().toString();
        String sub61 = S61.getText().toString();
        String sub12 = S12.getText().toString();
        String sub22 = S22.getText().toString();
        String sub32 = S32.getText().toString();
        String sub42 = S42.getText().toString();
        String sub52 = S52.getText().toString();
        String sub62 = S62.getText().toString();

        saveEditTextData(usn, name, sec, mob, sub1, sub2, sub3, sub4, sub5, sub6, sub11, sub21, sub31, sub41, sub51, sub61, sub12, sub22, sub32, sub42, sub52, sub62);
    }

    private void saveEditTextData(String usn, String name, String sec, String mob, String sub1, String sub2, String sub3, String sub4, String sub5, String sub6, String sub11, String sub21, String sub31, String sub41, String sub51, String sub61, String sub12, String sub22, String sub32, String sub42, String sub52, String sub62) {
        String filename = "edittext_data.txt";
        String data = usn + "," + name + "," + sec + "," + mob + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + "," + sub6 + "," + sub11 + "," + sub21 + "," + sub31 + "," + sub41 + "," + sub51 + "," + sub61 + "," + sub12 + "," + sub22 + "," + sub32 + "," + sub42 + "," + sub52 + "," + sub62 + "\n";

        try {
            FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
            fos.write(data.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String mob = tmob.getText().toString();
        String data = "USN:"+tusn.getText().toString() + "\n" +
                "NAME:"+ tname.getText().toString() + "\n" +
                "CLASS:"+  tsec.getText().toString() + "\n" + "IA1:\nS1:"+
                S1.getText().toString() + "\nS2:"+
                S2.getText().toString() + "\nS3:"+
                S3.getText().toString() + "\nS4:"+
                S4.getText().toString() + "\nS5:"+
                S5.getText().toString() + "\nS6:"+
                S6.getText().toString() + "\nIA2:\nS1:"+
                S11.getText().toString() + "\nS2:"+
                S21.getText().toString() + "\nS3:"+
                S31.getText().toString() + "\nS4:"+
                S41.getText().toString() + "\nS5:"+
                S51.getText().toString() + "\nS6:"+
                S61.getText().toString() + "\nIA3:\nS1:"+
                S12.getText().toString() + "\nS2:"+
                S22.getText().toString() + "\nS3:"+
                S32.getText().toString() + "\nS4:"+
                S42.getText().toString() + "\nS5:"+
                S52.getText().toString() + "\nS6:"+
                S62.getText().toString()+ "\n";

        try {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
            } else {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(mob, null, data, null, null);
                Toast.makeText(this, "Message sent successfully", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Failed to send message", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
