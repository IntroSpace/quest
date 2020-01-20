package com.zodiac33.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public Story story;
    public Character player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        story = new Story();
        player = new Character(getIntent().getStringExtra("name"));
        info();
    }

    private void go(int id) {
        try {story.go(id+1);}
        catch (Exception e) {
            Toast.makeText(this, "ОШИБКА", Toast.LENGTH_SHORT).show();
        }
        info();

        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }

    private void info () {
        player.A += story.current_situation.dA;
        player.K += story.current_situation.dK;
        player.R += story.current_situation.dR;
        TextView status = (TextView) findViewById(R.id.status);
        status.setText(player.name+": карьера("+player.K+") состояние("+player.A+") опыт("+player.R+")");
        TextView title = (TextView) findViewById(R.id.title);
        TextView desc = (TextView) findViewById(R.id.desc);
        title.setText(story.current_situation.subject);
        desc.setText(story.current_situation.text);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();
        for (int i = 0; i < story.current_situation.direction.length; i++) {
            Button b = new Button(this);
            b.setText(Integer.toString(i + 1));
            final int buttonId = i;
            // Внимание! в анонимных классах
            // можно использовать только те переменные метода,
            // которые объявлены как final.
            // Создаем объект анонимного класса и устанавливаем его
            // обработчиком нажатия на кнопку
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    go(buttonId);
                }
            });
            // добавляем готовую кнопку на разметку
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }
}
