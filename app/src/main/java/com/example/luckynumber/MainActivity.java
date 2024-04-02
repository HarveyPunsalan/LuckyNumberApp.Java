package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit_Text;
    Button btn;
    TextView text_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_Text = findViewById(R.id.edit_Text);
        btn = findViewById(R.id.btn);
        text_View = findViewById(R.id.text_View);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edit_Text.getText().toString();

                // Explicit Intent
                Intent i = new Intent(
                        getApplicationContext(),
                        SecondActivity.class
                );

                // Passing the name to Second Activity
                i.putExtra("name",userName);

                startActivity(i);
            }
        });
    }
}