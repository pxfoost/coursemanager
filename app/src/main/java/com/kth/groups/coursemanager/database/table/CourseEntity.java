package com.kth.groups.coursemanager.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_Course")
public class CourseEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    //@ColumnInfo(name = "student_id")
    public String student_ID;

    //@ColumnInfo(name = "course_id")
    public String course_ID;

    //@ColumnInfo(name = "course_name")
    public String course_name;

    public String teacher;

    //@ColumnInfo(name = "start_time")
    public int start_time;

    //@ColumnInfo(name = "end_time")
    public int end_time;

    //@ColumnInfo(name = "remind_method")
    public int remind_method;  // 0——无 1——静音 2——震动 3——闹铃 4——震动+闹铃
}
