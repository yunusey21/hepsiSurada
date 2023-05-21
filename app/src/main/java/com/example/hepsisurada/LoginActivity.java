package com.example.hepsisurada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hepsisurada.dataBase.DBHelper;
import com.example.hepsisurada.dataBase.userDBO;
import com.example.hepsisurada.databinding.ActivityLogInBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLogInBinding logInBinding;
    private String pass_text="";
    private DBHelper vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vt = new DBHelper(getApplicationContext());
        logInBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in);
        logInBinding.setLoginNesnesi(this);
    }


    public void regist() {
        UserO user = new UserO(logInBinding.logScreenUsername.getText().toString(),logInBinding.logScreenPassword.getText().toString());
        new userDBO().Add(vt,user);
    }

    public void isTrue() {
        UserO user = new UserO(logInBinding.logScreenUsername.getText().toString(),logInBinding.logScreenPassword.getText().toString());

        if (new userDBO().LogIn(vt, user)) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        } else {
            Toast.makeText(getApplicationContext(),"Hatalı giriş",Toast.LENGTH_SHORT).show();
        }
    }



}