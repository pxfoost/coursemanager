package com.kth.groups.coursemanager;

import android.content.Intent;
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
import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.dao.CourseDao;
import com.kth.groups.coursemanager.database.table.CourseEntity;

import java.util.List;


public class CourseFragment extends Fragment {

    private CourseDao courseDao = AppDatabase.getsInstance().getCourseDao();
    private static String student_ID;
    private CourseAdapter courseAdapter;
    private List<CourseEntity> list;
    private ListView list_item_course;
    FloatingActionButton fab;


    public static CourseFragment newInstance(String stuId) {

        student_ID = stuId;
        Log.d("student_ID:",student_ID);

        return new CourseFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        //点击课程界面的添加按钮是时，跳转到添加页面
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CourseAddActivity.class);
                intent.putExtra("student_ID", student_ID);
                startActivity(intent);
            }
        });

        //从数据库读取课程信息，并显示
        list = courseDao.getAllByStudentID(student_ID);
        //list = courseDao.getAll();

        for(int i=0;i<list.size();i++){
            CourseEntity a = list.get(i);
            Log.d("CourseEntity:",a.getCourse_name());
        }

        courseAdapter = new CourseAdapter(requireContext(), list);
        ListView listView = view.findViewById(R.id.list_item_course);
        listView.setAdapter(courseAdapter);


        //点击列表的一行，跳转到课程详细信息显示界面
        list_item_course = view.findViewById(R.id.list_item_course);
        list_item_course.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseEntity courseEntity = list.get(position);

                Bundle bundle = new Bundle();
                bundle.putLong("id",courseEntity.getId());
                bundle.putString("student_ID",courseEntity.getStudent_ID());
                bundle.putString("course_ID",courseEntity.getCourse_ID());
                bundle.putString("course_name",courseEntity.getCourse_name());
                bundle.putString("teacher",courseEntity.getTeacher());
                bundle.putInt("start_time",courseEntity.getStart_time());
                bundle.putInt("end_time",courseEntity.getEnd_time());
                bundle.putInt("remind_method",courseEntity.getRemind_method());

                Intent intent = new Intent(getActivity(),CourseDetailActivity.class);
                intent.putExtra("courseEntity",bundle);
                startActivity(intent);

            }
        });

    }



}
