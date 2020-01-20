package com.zodiac33.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_inputer);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit = findViewById(R.id.name);
                String text = edit.getText().toString();
                if (text.length() > 2) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", text);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "СЛИШКОМ КОРОТКОЕ ИМЯ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
