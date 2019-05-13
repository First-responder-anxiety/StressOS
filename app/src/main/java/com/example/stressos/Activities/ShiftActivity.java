package com.example.stressos.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stressos.Api.RetroFitClient;
import com.example.stressos.R;
import com.example.stressos.data.LoggedInUser;
import com.example.stressos.responses.MultipleParentResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShiftActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);
        spinner = findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("Louise");
        categories.add("Harold");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void getUserParents() {
        String userName = LoggedInUser.getUserName();
        Call<MultipleParentResponse> call = RetroFitClient
                .getInstance()
                .getApi()
                .getuserparents(userName);

        call.enqueue(new Callback<MultipleParentResponse>() {
            @Override
            public void onResponse(Call<MultipleParentResponse> call, Response<MultipleParentResponse> response) {

            }

            @Override
            public void onFailure(Call<MultipleParentResponse> call, Throwable t) {

            }
        });
    }
}
