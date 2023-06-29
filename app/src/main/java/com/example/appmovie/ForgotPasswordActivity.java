package com.example.appmovie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmovie.database.MyDatabaseHelper;
import com.example.appmovie.ui.LoginActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private EditText editTextEmail , edtUsername;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        dbHelper = new MyDatabaseHelper(this);

        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSend = findViewById(R.id.buttonSend);
        edtUsername = findViewById(R.id.edtUsername);
    }
    public void onSendClick(View view){
        String email = editTextEmail.getText().toString().trim();
        String name = edtUsername.getText().toString().trim();
        //xu ly dang nhap tai day
        if(!dbHelper.checkEmail(name , email).equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Lay lai mat khau");
            builder.setMessage("Mat khau cua ban: " + dbHelper.checkEmail(name,email));
            builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton("Đăng nhập", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(ForgotPasswordActivity.this , LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            });
            builder.create().show();
        }
        else {
            Toast.makeText(this, "email không đúng", Toast.LENGTH_SHORT).show();
        }
    }
}