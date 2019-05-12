package com.example.stressos.Activities;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.stressos.R;

public class QuestionnaireActivity extends AppCompatActivity {

    private ImageButton badMood;
    private ImageButton goodMood;
    private ImageButton indifference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        addListenerToButtons();

    }

    public void addListenerToButtons(){
        badMood = (ImageButton) findViewById(R.id.badMood);
        goodMood = (ImageButton) findViewById(R.id.goodMood);
        indifference = (ImageButton) findViewById(R.id.neutralMood);

        badMood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
            }
        });
    }

}
