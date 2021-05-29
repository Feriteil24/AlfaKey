package com.alfabank.alfakey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences credentials;
    private Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainIntent = new Intent(this, FindDevice.class);
        credentials = getSharedPreferences("credentials", MODE_PRIVATE);
        if (credentials.contains("login") && credentials.contains("password")) {
            this.startActivity(mainIntent);
            this.finish();
        }
        setContentView(R.layout.activity_login);
    }

    public void inputCredentials (View view){
        TextInputLayout password_layout = findViewById(R.id.InputPasswordLayout);
        TextInputLayout login_layout = findViewById(R.id.InputloginLayout);
        EditText login_view = findViewById(R.id.input_login);
        EditText password_view = findViewById(R.id.input_password);
        boolean check_fields = true;
        if (login_view.getText().toString().length() > 5) {
            login_layout.setErrorEnabled(false);
            credentials.edit().putString("login", login_view.getText().toString()).commit();
        } else {
            login_layout.setErrorEnabled(true);
            login_layout.setError("Длина логина должна быть не мение пяти символов");
            check_fields = false;
        }
        if (password_view.getText().toString().length() > 5) {
            password_layout.setErrorEnabled(false);
            credentials.edit().putString("password", password_view.getText().toString()).commit();
        } else {
            password_layout.setErrorEnabled(true);
            password_layout.setError("Длина пароля должна быть не мение пяти символов");
            check_fields = false;
        }
        if (check_fields == true) {
            this.startActivity(mainIntent);
            this.finish();
        }
    }
}