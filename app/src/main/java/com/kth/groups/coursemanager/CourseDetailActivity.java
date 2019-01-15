package com.kth.groups.coursemanager;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.dao.CourseDao;
import com.kth.groups.coursemanager.database.table.CourseEntity;

import static com.google.android.material.bottomnavigation.BottomNavigationView.*;

public class CourseDetailActivity extends AppCompatActivity {

    private CourseDao courseDao = AppDatabase.getsInstance().getCourseDao();
    private BottomNavigationView bottomNavigationView;
    private Bundle bundle;



    EditText editText_course_name1;
    EditText editText_course_id1;
    EditText editText_teacher1;
    EditText editText_start_time1;
    EditText editText_end_time1;

    RadioButton radioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        final Intent intent = getIntent();
        bundle = intent.getBundleExtra("courseEntity");


        show();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view_course_detail);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.course_edit:
                        courseDao.update(updateCourseEntity());
                        Toast.makeText(CourseDetailActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case R.id.course_delete:
                        courseDao.delete(deleteCourseEntity());
                        Toast.makeText(CourseDetailActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    private void show(){
        editText_course_name1 = findViewById(R.id.editText_course_name1);
        editText_course_name1.setText(bundle.getString("course_name"));

        editText_course_id1 = findViewById(R.id.editText_course_id1);
        editText_course_id1.setText(bundle.getString("course_ID"));

        editText_teacher1 = findViewById(R.id.editText_teacher1);
        editText_teacher1.setText(bundle.getString("teacher"));

        editText_start_time1 = findViewById(R.id.editText_start_time1);
        int start_time = bundle.getInt("start_time");
        editText_start_time1.setText(String.valueOf(start_time));

        editText_end_time1 = findViewById(R.id.editText_end_time1);
        int end_time = bundle.getInt("end_time");
        editText_end_time1.setText(String.valueOf(end_time));

       //TODO 显示提醒方式
        Log.d("show",String.valueOf(bundle.getInt("remind_method")));

    }

    private CourseEntity updateCourseEntity(){

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(bundle.getLong("id"));
        courseEntity.setStudent_ID(bundle.getString("student_ID"));

        courseEntity.setCourse_ID(editText_course_id1.getText().toString());
        courseEntity.setCourse_name(editText_course_name1.getText().toString());
        courseEntity.setTeacher(editText_teacher1.getText().toString());
        courseEntity.setStart_time(Integer.valueOf(editText_start_time1.getText().toString()));
        courseEntity.setEnd_time(Integer.valueOf(editText_end_time1.getText().toString()));

        courseEntity.setRemind_method(1); //TODO 固定了提醒方式

        return courseEntity;
    }

    private  CourseEntity deleteCourseEntity(){
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId(bundle.getLong("id"));
        courseEntity.setStudent_ID(bundle.getString("student_ID"));
        courseEntity.setCourse_ID(bundle.getString("course_ID"));
        courseEntity.setCourse_name(bundle.getString("course_name"));
        courseEntity.setTeacher(bundle.getString("teacher"));
        courseEntity.setStart_time(bundle.getInt("start_time"));
        courseEntity.setEnd_time(bundle.getInt("end_time"));
        courseEntity.setRemind_method(bundle.getInt("remind_method"));

        return courseEntity;
    }
}
