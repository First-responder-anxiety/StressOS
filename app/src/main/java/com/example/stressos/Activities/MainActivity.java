package com.example.stressos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.stressos.R;
import com.example.stressos.data.LoggedInUser;

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

    public void startHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        LoggedInUser.setUserName("JANE DOE");
        startActivity(intent);
    }

    public void killMain(){
        finish();
    }
}
