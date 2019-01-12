package com.kth.groups.coursemanager.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_UserMsg")
public class UserEntity {
    @PrimaryKey
    public long studentID;

    public String password;

    public String name;

    public String sex;

    public String school;

    public String department;

    public String major;

    public String grade;

}
