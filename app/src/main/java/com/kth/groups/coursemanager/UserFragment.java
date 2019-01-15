package com.kth.groups.coursemanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kth.groups.coursemanager.database.AppDatabase;
import com.kth.groups.coursemanager.database.table.UserEntity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;


public class UserFragment extends Fragment {

    private TextView NameTextView;
    private TextView SexTextView;
    private TextView IDTextView;
    private TextView SchoolTextView;
    private TextView DepartmentTextView;
    private TextView MajorTextView;
    private TextView GradeTextView;
    private AppDatabase mAppDatabase;
    private UserEntity user;
    private static String LoginID;

    public static UserFragment newInstance(String loginID) {
        //数据传递>登录用户的ID
        LoginID = loginID;
        return new UserFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        //用界面ID
        NameTextView = view.findViewById(R.id.name);
        SexTextView = view.findViewById(R.id.sex);
        IDTextView = view.findViewById(R.id.studentID);
        SchoolTextView = view.findViewById(R.id.school);
        DepartmentTextView = view.findViewById(R.id.department);
        MajorTextView = view.findViewById(R.id.major);
        GradeTextView = view.findViewById(R.id.grade);
        //数据库
        mAppDatabase = Room.databaseBuilder(getContext(),
                AppDatabase.class, "DBCourse")
                .allowMainThreadQueries()
                .build();

        //调用
        user = new UserEntity();
        user = mAppDatabase.userDao().findById(LoginID);
        //文本框赋值
        NameTextView.setText(user.getName());
        SexTextView.setText(user.getSex());
        IDTextView.setText(user.getStudent_ID());
        SchoolTextView.setText(user.getSchool());
        DepartmentTextView.setText(user.getDepartment());
        MajorTextView.setText(user.getMajor());
        GradeTextView.setText(user.getGrade());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //用界面ID
        NameTextView = view.findViewById(R.id.name);
        SexTextView = view.findViewById(R.id.sex);
        IDTextView = view.findViewById(R.id.studentID);
        SchoolTextView = view.findViewById(R.id.school);
        DepartmentTextView = view.findViewById(R.id.department);
        MajorTextView = view.findViewById(R.id.major);
        GradeTextView = view.findViewById(R.id.grade);
        //数据库
        mAppDatabase = Room.databaseBuilder(getContext(),
                AppDatabase.class, "DBCourse")
                .allowMainThreadQueries()
                .build();

        //调用
        user = new UserEntity();
        user = mAppDatabase.userDao().findById(LoginID);
        //文本框赋值
        NameTextView.setText(user.getName());
        SexTextView.setText(user.getSex());
        IDTextView.setText(user.getStudent_ID());
        SchoolTextView.setText(user.getSchool());
        DepartmentTextView.setText(user.getDepartment());
        MajorTextView.setText(user.getMajor());
        GradeTextView.setText(user.getGrade());
    }
}