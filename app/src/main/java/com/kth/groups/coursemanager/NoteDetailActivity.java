package com.kth.groups.coursemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.dao.NoteDao;
import com.kth.groups.coursemanager.database.table.NoteEntity;

public class NoteDetailActivity extends AppCompatActivity {

    private NoteDao noteDao = AppDatabase.getsInstance().getNoteDao();
    private BottomNavigationView bottomNavigationView;
    private Bundle bundle;

    private TextView textView_note_name1;
    private TextView textView_note_course_name1;
    private TextView textView_text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        Intent intent = getIntent();
        bundle = intent.getBundleExtra("noteEntity");

        show();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view2);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch (item.getItemId()){
                    case R.id.note_delete:
                        noteDao.delete(deleteNoteEntity());
                        Toast.makeText(NoteDetailActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    private void show(){
        textView_note_name1 = findViewById(R.id.textView_note_name1);
        textView_note_name1.setText(bundle.getString("note_name"));
        textView_note_course_name1 = findViewById(R.id.textView_note_course_name1);
        textView_note_course_name1.setText(bundle.getString("course_name"));
        textView_text1 = findViewById(R.id.textView_text1);
        textView_text1.setText(bundle.getString("text"));

    }

    private NoteEntity deleteNoteEntity(){
        NoteEntity noteEntity = new NoteEntity();

        noteEntity.setNote_ID(bundle.getLong("note_ID"));
        noteEntity.setStudent_ID(bundle.getString("student_ID"));
        noteEntity.setNote_name(bundle.getString("note_name"));
        noteEntity.setCourse_name(bundle.getString("course_name"));
        noteEntity.setText(bundle.getString("text"));

        return noteEntity;
    }
}
