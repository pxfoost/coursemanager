package com.kth.groups.coursemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.dao.NoteDao;
import com.kth.groups.coursemanager.database.table.NoteEntity;

public class NoteAddActivity extends AppCompatActivity {

    private NoteDao noteDao = AppDatabase.getsInstance().getNoteDao();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        Toast.makeText(NoteAddActivity.this,"NoteAddActivity",Toast.LENGTH_SHORT).show();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view_note_add1);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.note_save:
                        addNoteEntity();
                        Toast.makeText(NoteAddActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    private void addNoteEntity(){

        NoteEntity noteEntity = new NoteEntity();

        EditText editText = findViewById(R.id.editText_note_name);
        EditText editText1 = findViewById(R.id.editText_note_course_name);
        EditText editText2 = findViewById(R.id.editText_note_text);

        Intent intent = getIntent();
        String student_ID = intent.getStringExtra("student_ID");

        noteEntity.setStudent_ID(student_ID);
        noteEntity.setNote_name(editText.getText().toString());
        noteEntity.setCourse_name(editText1.getText().toString());
        noteEntity.setNote_text(editText2.getText().toString());

        Log.d("student_ID",student_ID);
        Log.d("note_name",editText.getText().toString());
        Log.d("course_name",editText1.getText().toString());
        Log.d("text",editText2.getText().toString());

        noteDao.add(noteEntity);
        finish();

    }
}
