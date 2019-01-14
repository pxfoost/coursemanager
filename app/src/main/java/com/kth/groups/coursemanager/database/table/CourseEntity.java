package com.kth.groups.coursemanager.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_Course")
public class CourseEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String student_ID;
    @ColumnInfo
    private String course_ID;
    @ColumnInfo
    private String course_name;
    @ColumnInfo
    private String teacher;
    @ColumnInfo
    private int start_time;
    @ColumnInfo
    private int end_time;
    @ColumnInfo
    private int remind_method;  // 0——静音 1——震动 2——闹铃 3——震动+闹铃

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.course_ID = course_ID;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getRemind_method() {
        return remind_method;
    }

    public void setRemind_method(int remind_method) {
        this.remind_method = remind_method;
    }
}
