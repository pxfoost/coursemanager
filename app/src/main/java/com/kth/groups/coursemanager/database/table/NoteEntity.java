package com.kth.groups.coursemanager.database.table;

import android.widget.TableRow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Table_notes")
public class NoteEntity {

    @PrimaryKey(autoGenerate = true)
    private long note_ID;
    @ColumnInfo
    private String student_ID;
    @ColumnInfo
    private String note_name;
    @ColumnInfo
    private String course_name;
    @ColumnInfo
    private String note_text;

    public long getNote_ID() {
        return note_ID;
    }

    public void setNote_ID(long note_ID) {
        this.note_ID = note_ID;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getNote_text() {
        return note_text;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }
}
