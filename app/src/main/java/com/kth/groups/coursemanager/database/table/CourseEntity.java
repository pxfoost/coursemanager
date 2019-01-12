package com.kth.groups.coursemanager.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_Course")
public class CourseEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "student_id")
    public String studentID;

    @ColumnInfo(name = "course_id")
    public String courseID;

    @ColumnInfo(name = "course_name")
    public String courseName;

    public String teacher;

    @ColumnInfo(name = "start_time")
    public int startTime;

    @ColumnInfo(name = "end_time")
    public int endTime;

    @ColumnInfo(name = "remind_method")
    public int remindMethod;
}
