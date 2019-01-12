package com.kth.groups.coursemanager.database.table;

import android.widget.TableRow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_notes")
public class NoteEntity {

    @PrimaryKey(autoGenerate = true)
    public long note_ID;

    public String student_ID;

    //@ColumnInfo(name = "course_name")
    public String course_name;

    public String text;
}
