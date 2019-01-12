package com.kth.groups.coursemanager.database.dao;

import com.kth.groups.coursemanager.database.table.CourseEntity;
import com.kth.groups.coursemanager.database.table.NoteEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface NoteDao {

    /**
     * 查询所有笔记
     * @return
     */
    @Query("select * from Table_notes")
    List<NoteEntity> getAll();

    /**
     * 添加笔记
     * @param entities
     */
    @Insert
    void add(CourseEntity... entities);
}
