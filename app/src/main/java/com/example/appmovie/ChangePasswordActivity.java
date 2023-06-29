package com.example.appmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmovie.database.MyDatabaseHelper;
import com.example.appmovie.ui.LoginActivity;

public class ChangePasswordActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private EditText OldPassword;
    private EditText NewPassword;
    private EditText ConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        dbHelper = new MyDatabaseHelper(this);


        OldPassword = findViewById(R.id.old_password_edit_text);
        NewPassword = findViewById(R.id.new_password_edit_text);
        ConfirmPassword = findViewById(R.id.confirm_password_edit_text);


    }

    public void onChangePasswordButtonClick(View view) {
        String oldpassword = OldPassword.getText().toString().trim();
        String newpassword = NewPassword.getText().toString().trim();
        String confirmpassword = ConfirmPassword.getText().toString().trim();


        if(dbHelper.checkOldpassword(oldpassword)){
            if (newpassword.equals(confirmpassword)) {
                // Xử lý đăng ký tại đây nếu mật khẩu và xác nhận mật khẩu trùng khớp
                if (dbHelper.updatePassword(newpassword)){

                    Toast.makeText(this, "thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

                }
                else Toast.makeText(this, "that bai", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Mật khẩu nhập lại không trùng khớp", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "password cũ sai", Toast.LENGTH_SHORT).show();
        }


    }
}