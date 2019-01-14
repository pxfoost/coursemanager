package com.kth.groups.coursemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText_account;
    EditText editText_password;
    String account;
    String password;
    private Button btw_login;
    private Button btw_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btw_login = (Button) findViewById(R.id.btw_login);
        btw_register = (Button) findViewById(R.id.btw_register);

        btw_login.setOnClickListener(this);


        btw_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btw_login:
                editText_account = (EditText) findViewById(R.id.editText_account);
                editText_password = (EditText) findViewById(R.id.editText_password);
                account = editText_account.getText().toString();
                password = editText_password.getText().toString();

                Log.d("LoginActivity:",account);
                Log.d("LoginActivity",password);

                if("admin".equals(account) && "123456".equals(password)){


                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra("student_ID",account);


                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"account or password error",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btw_register:
                break;

                default:break;
        }

    }

    public void login(){
        //TODO
    }

    public void register(){
        //TODO
    }
}