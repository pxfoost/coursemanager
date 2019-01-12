package com.kth.groups.coursemanager.database.dao;

import com.kth.groups.coursemanager.database.table.CourseEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CourseDao {

    /**
     * 查询所有课程信息
     * @return List<CourseEntity>
     */
    @Query("select * from Table_Course")
    List<CourseEntity> getAll();

    @Insert
    void add(CourseEntity... entities);

    @Delete
    void delete(CourseEntity entity);

    @Update
    void update(CourseEntity entity);

}
