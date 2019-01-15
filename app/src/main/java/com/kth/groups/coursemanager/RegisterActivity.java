package com.kth.groups.coursemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.table.UserEntity;

public class RegisterActivity extends AppCompatActivity {

    private EditText IDEditText;
    private EditText UserNameEditText;
    private EditText SexEditText;
    private EditText SchoolEditText;
    private EditText DepartmentEditText;
    private EditText MajorEditText;
    private EditText GradeEditText;
    private EditText PasswordEditText;
    private UserEntity mUser;
    private UserEntity user;
    private AppDatabase mAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //查询界面ID
        Button reGister = findViewById(R.id.registered);
        IDEditText = findViewById(R.id.ID);
        UserNameEditText = findViewById(R.id.nAccount);
        SexEditText = findViewById(R.id.sex);
        SchoolEditText = findViewById(R.id.school);
        DepartmentEditText = findViewById(R.id.department);
        MajorEditText = findViewById(R.id.major);
        GradeEditText = findViewById(R.id.grade);
        PasswordEditText = findViewById(R.id.nPassword);
        //连接数据库
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"DBCourse")
                .allowMainThreadQueries()
                .build();

        reGister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new UserEntity();
                String account = IDEditText.getText().toString();
                user = mAppDatabase.userDao().findById(account);
                if(user==null){
                    if(IDEditText.getText().toString().equals("")||PasswordEditText.getText().toString().equals("")
                            ||UserNameEditText.getText().toString().equals("")
                            ||SexEditText.getText().toString().equals("")
                            ||SchoolEditText.getText().toString().equals("")
                            ||DepartmentEditText.getText().toString().equals("")
                            ||MajorEditText.getText().toString().equals("")
                            ||GradeEditText.getText().toString().equals("")) {
                        Toast.makeText(RegisterActivity.this,"输入信息不能有空!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(SexEditText.getText().toString().equals("man") || SexEditText.getText().toString().equals("woman")){
                            mUser = new UserEntity();//创建实例
                            //实例赋值
                            mUser.setStudent_ID(IDEditText.getText().toString());
                            mUser.setName(UserNameEditText.getText().toString());
                            mUser.setSex(SexEditText.getText().toString());
                            mUser.setSchool(SchoolEditText.getText().toString());
                            mUser.setDepartment(DepartmentEditText.getText().toString());
                            mUser.setMajor(MajorEditText.getText().toString());
                            mUser.setGrade(GradeEditText.getText().toString());
                            mUser.setPassword(PasswordEditText.getText().toString());
                            mAppDatabase.userDao().insert(mUser);//存储数据
                            Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"请正确输入性别！",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this,"已存在该用户！",Toast.LENGTH_SHORT).show();
                }
//                Intent intent = new Intent(RegsiterActivity.this,LoginActivity.class);
//                startActivity(intent);
//                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);
            }
        });
    }
}