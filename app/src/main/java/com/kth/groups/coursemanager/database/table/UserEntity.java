package com.kth.groups.coursemanager.database.table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_UserMsg")
public class UserEntity {

    @PrimaryKey
    @NonNull private String student_ID;
    @ColumnInfo
    private String password;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String sex;
    @ColumnInfo
    private String school;
    @ColumnInfo
    private String department;
    @ColumnInfo
    private String major;
    @ColumnInfo
    private String grade;

    @NonNull
    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(@NonNull String student_ID) {
        this.student_ID = student_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
