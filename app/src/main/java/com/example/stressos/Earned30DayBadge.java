package com.example.stressos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Earned30DayBadge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earned30_day_badge);
    }

    public void startBadges(View view) {
        Intent intent = new Intent(this, BadgeActivity.class);
        startActivity(intent);
    }
}
