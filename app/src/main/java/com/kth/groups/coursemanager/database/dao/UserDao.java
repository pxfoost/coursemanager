package com.kth.groups.coursemanager.database.dao;

import com.kth.groups.coursemanager.database.table.UserEntity;

import java.util.List;

import javax.security.auth.Subject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return List<UserEntity>
     */
    @Query("select * from Table_UserMsg")
    List<UserEntity> getAll();

    /**
     * 查询单个用户
     * @param student_ID 待查询用户的学号
     * @return UserEntity的一个实例
     */
    @Query("select * from Table_UserMsg where student_ID = :student_ID")
    UserEntity getOne(String student_ID);

    /**
     * 向数据库添加用户
     * @param entities
     */
    @Insert
    void add(UserEntity... entities);

    @Delete
    void delete(UserEntity entity);

    @Update
    void update(UserEntity entity);

}
