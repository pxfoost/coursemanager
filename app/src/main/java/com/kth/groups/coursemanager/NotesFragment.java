package com.kth.groups.coursemanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kth.groups.coursemanager.app.App;
import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.dao.CourseDao;
import com.kth.groups.coursemanager.database.dao.NoteDao;
import com.kth.groups.coursemanager.database.table.NoteEntity;

import java.util.ArrayList;
import java.util.List;


public class NotesFragment extends Fragment {

    private NoteDao noteDao = AppDatabase.getsInstance().getNoteDao();
    private static String student_ID;
    private FloatingActionButton fab;
    private NoteAdapter noteAdapter;
    private ListView listView;
    private List<NoteEntity> list;

    public static NotesFragment newInstance(String stuId) {

        student_ID = stuId;
        Log.d("student_ID",student_ID);

        return new NotesFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //点击添加跳转到笔记添加界面
        fab = view.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NoteAddActivity.class);
                intent.putExtra("student_ID",student_ID);
                startActivity(intent);
        }
        });

//       list = new ArrayList<NoteEntity>();
//        init();

        //从数据库读取数据，并显示
        list = noteDao.getAll();
        noteAdapter = new NoteAdapter(requireContext(),list);
        listView = view.findViewById(R.id.list_item_note);
        listView.setAdapter(noteAdapter);

        //点击列表的对应行跳转到笔记详细页面显示
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoteEntity noteEntity = list.get(position);

                Bundle bundle = new Bundle();
                bundle.putLong("note_ID",noteEntity.getNote_ID());
                bundle.putString("student_ID",noteEntity.getStudent_ID());
                bundle.putString("note_name",noteEntity.getNote_name());
                bundle.putString("course_name",noteEntity.getCourse_name());
                bundle.putString("text",noteEntity.getNote_text());

                Intent intent = new Intent(getActivity(),NoteDetailActivity.class);
                intent.putExtra("noteEntity",bundle);
                startActivity(intent);

            }
        });
    }

    private void init(){
        for(int i=0;i<20;i++){
            NoteEntity aa = new NoteEntity();

            aa.setNote_ID(i);
            aa.setStudent_ID(student_ID);
            aa.setNote_name("笔记");
            aa.setCourse_name("课程");
            aa.setNote_text("111111111111111111111111112345555555555555555555555");
            list.add(aa);
        }
    }

}
