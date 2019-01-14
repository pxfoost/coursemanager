package com.kth.groups.coursemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.dao.CourseDao;
import com.kth.groups.coursemanager.database.table.CourseEntity;

public class CourseModifyActivity extends AppCompatActivity {

    private CourseDao courseDao = AppDatabase.getsInstance().getCourseDao();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_modify);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view1);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.course_save:
                        addCourse();
                        Toast.makeText(CourseModifyActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }

    public void addCourse(){

        EditText editText_course_name = findViewById(R.id.editText_course_name);
        EditText editText_course_id = findViewById(R.id.editText_course_id);
        EditText editText_teacher = findViewById(R.id.editText_teacher);
        EditText editText_start_time = findViewById(R.id.editText_start_time);
        EditText editText_end_time = findViewById(R.id.editText_end_time);
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        Intent intent = getIntent();
        String student_ID = intent.getStringExtra("student_ID");
        String course_id = editText_course_id.getText().toString();
        String course_name = editText_course_name.getText().toString();
        String teacher = editText_teacher.getText().toString();
        int start_time =  Integer.valueOf(editText_start_time.getText().toString());
        int end_time = Integer.valueOf(editText_end_time.getText().toString());


        int remind_method;
// 有问题
//        int count = radioGroup.getChildCount();
//        int i;
//        for(i=0;i<count;i++){
//            RadioButton rbt = (RadioButton) radioGroup.getChildAt(i);
//            if(rbt.isChecked()) break;
//        }
        remind_method = 1;

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setStudent_ID(student_ID);
        courseEntity.setCourse_ID(course_id);
        courseEntity.setCourse_name(course_name);
        courseEntity.setTeacher(teacher);
        courseEntity.setStart_time(start_time);
        courseEntity.setEnd_time(end_time);
        courseEntity.setRemind_method(remind_method);

        Log.d("student_ID:",student_ID);
        Log.d("course_ID:",course_id);
        Log.d("course_name:",course_name);
        Log.d("teacher:",teacher);
        Log.d("start_time:",editText_start_time.getText().toString());
        Log.d("end_time:",editText_end_time.getText().toString());
        Log.d("remind_method:",String.valueOf(remind_method));


        courseDao.add(courseEntity);
        finish();

    }
}
