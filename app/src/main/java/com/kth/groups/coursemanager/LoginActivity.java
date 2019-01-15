package com.kth.groups.coursemanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.table.UserEntity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    private EditText nAaccountEditText;
    private EditText nPasswordEditText;
    private AppDatabase mAppDatabase;
    private Button register;
    private Button login;
    private UserEntity user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //查询界面属性ID
        register = findViewById(R.id.resiger);
        login = findViewById(R.id.login);
        nAaccountEditText = findViewById(R.id.account);
        nPasswordEditText = findViewById(R.id.password);

        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
        pref=PreferenceManager.getDefaultSharedPreferences(this);
        //连接数据库
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "DBCourse")
                .allowMainThreadQueries()//通过主线？查询
                .build();

        boolean isRemember=pref.getBoolean("remember_password",false);
        if(isRemember){
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            nAaccountEditText.setText(account);
            nPasswordEditText.setText(password);
            rememberPass.setChecked(true);
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册跳转
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录点击事件
                String account = nAaccountEditText.getText().toString();
                String password = nPasswordEditText.getText().toString();
                if(account.equals("")|| password.equals("")){
                    //判断为空
                    Toast.makeText(LoginActivity.this,"账户或者密码输入错误",Toast.LENGTH_SHORT).show();
                }
                else{
                    //数据库查询
                    user = new UserEntity();
                    user = mAppDatabase.userDao().findById(account);
                    if(user!=null){
                        if(password.equals(user.getPassword())){
                            editor = pref.edit();
                            if(rememberPass.isChecked()){//记住密码
                                editor.putBoolean("remember_password",true);
                                editor.putString("account",account);
                                editor.putString("password",password);
                            }
                            else {
                                editor.clear();
                            }
                            editor.apply();
                            //存在密码正确跳转
                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            intent.putExtra("extra_data",account);//向下一活动传数据
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this,"Login success！",Toast.LENGTH_SHORT).show();
                            finish();

//                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"不存在该用户",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}