package com.example.stressos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.stressos.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void startRegistration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    // Temporary Code to Try out the Badges Page
    // Make sure to remove the extra button from the activity_main.xml file too.
    public void startBadges(View view) {
        Intent intent = new Intent(this, Earned30DayBadge.class);
        startActivity(intent);
    }

    public void killMain(){
        finish();
    }
}
