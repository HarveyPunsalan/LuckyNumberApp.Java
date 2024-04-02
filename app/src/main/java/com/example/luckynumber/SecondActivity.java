package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView text_View2, lucky_NumberText;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_View2 = findViewById(R.id.text_View2);
        lucky_NumberText = findViewById(R.id.lucky_NumberText);
        shareBtn = findViewById(R.id.shareBtn);

        // Receiving data from Main Activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        // Generating Random Numbers
        int random_num = generatorNumber();
        lucky_NumberText.setText(""+random_num);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_num);
            }
        });
    }

    public int generatorNumber () {
        Random random = new Random();
        int upperLimit = 1000;

        int randomGenerated = random.nextInt(upperLimit);
        return randomGenerated;
    }

    public void shareData(String userName, int random_num) {
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i .setType("text/plain");

        i .putExtra(Intent.EXTRA_SUBJECT, userName + "Lucky Number");
        i .putExtra(Intent.EXTRA_TEXT, "His lucky number is:  " +random_num);

        startActivity(Intent.createChooser(i,"Choose A Platform"));
    }
}