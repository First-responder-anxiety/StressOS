package com.example.stressos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText editTextUserName, editTextPassword, editTextPasswordConfirm, editTextFirstName, editTextLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextFirstName = findViewById(R.id.reg_first_name);
        editTextLastName = findViewById(R.id.reg_last_name);
        editTextUserName = findViewById(R.id.reg_username);
        editTextPassword = findViewById(R.id.reg_password);
        editTextPasswordConfirm = findViewById(R.id.reg_con_password);
    }

    /**
     * Called when the user presses the sign up button
     * Called when the user presses the sign up button
     * Checks the user has entered all required fields and then sends a POST request to our database
     * @param view
     */
    public void signUp(View view) {
        String userName = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();
        String passwordConfirm = editTextPasswordConfirm.getText().toString();
        String fName = editTextFirstName.getText().toString();
        String lName = editTextLastName.getText().toString();

        // Error checking
        if (fieldError(userName, editTextUserName, "Username") || fieldError(password, editTextPassword, "Password") ||
                fieldError(passwordConfirm, editTextPasswordConfirm, "confirm password") ||
                fieldError(fName, editTextFirstName, "First name") || fieldError(lName, editTextLastName, "Last name"))
            return;

        if (!password.equals(passwordConfirm)) {
            Toast.makeText(RegistrationActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
            return;
        }

        Call<DefaultResponse> call = RetroFitClient
                .getInstance()
                .getApi()
                .createUser(userName, password, fName, lName);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse defaultResponse = response.body();
                if (response.code() == 201) {
                    Toast.makeText(RegistrationActivity.this, defaultResponse.getMessage(), Toast.LENGTH_LONG).show();
                } else if (response.code() == 401) {
                    editTextUserName.setError("User name already exists");
                    editTextUserName.requestFocus();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Another error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean fieldError(String fieldContent, EditText editText, String fieldName) {
        if (fieldContent.isEmpty()) {
            editText.setError(fieldName + " is required");
            editText.requestFocus();
        }
        return false;
    }

}
