package com.example.whackingmolesgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    TextView scoreInfo;
    Button returnToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        scoreInfo = findViewById(R.id.textView2);
        returnToHome = findViewById(R.id.button2);
        Bundle getGameActValues = getIntent().getExtras();
        scoreInfo.setText("You Scored: " + getGameActValues.getInt("score"));

        returnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });





    }
}