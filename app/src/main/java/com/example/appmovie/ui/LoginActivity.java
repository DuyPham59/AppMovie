package com.example.appmovie.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmovie.ForgotPasswordActivity;
import com.example.appmovie.database.MyDatabaseHelper;
import com.example.appmovie.R;
import com.example.appmovie.RegisterActivity;
import com.example.appmovie.WacthTheMovie;

public class LoginActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new MyDatabaseHelper(this);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

    }
    public void onLoginClick(View view){
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        //xu ly dang nhap tai day
        if(dbHelper.checkLogin(username,password)){
            Intent intent = new Intent(this, WacthTheMovie.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "that bai", Toast.LENGTH_SHORT).show();
        }
    }
    public void onRegisterClick(View view){
        // Chuyen sang man hinh dang ki tai day
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onForgotPasswordClick(View view){
        // Chuyen sang man hinh dang ki tai day
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }


}