package com.kth.groups.coursemanager.database;

import android.app.Application;

import com.kth.groups.coursemanager.database.dao.CourseDao;
import com.kth.groups.coursemanager.database.dao.NoteDao;
import com.kth.groups.coursemanager.database.dao.UserDao;
import com.kth.groups.coursemanager.database.table.CourseEntity;
import com.kth.groups.coursemanager.database.table.NoteEntity;
import com.kth.groups.coursemanager.database.table.UserEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class,CourseEntity.class,NoteEntity.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    /**
     * database name
     */
    private static final String DB_NAME = "DBCourse";

    /**
     * 单例
     */
    private static AppDatabase sInstance;

    /**
     * 在Application中做初始化操作
     *
     * @param application
     */
    public static void init(Application application){
        if(sInstance == null){
            synchronized (Application.class){
                if(sInstance == null){
                    sInstance = Room.databaseBuilder(application,AppDatabase.class,DB_NAME).build();
                }
            }
        }
    }

    /**
     * 获取实例
     * @return 没有初始化抛出异常
     */
    public static AppDatabase getsInstance(){
        synchronized (AppDatabase.class){
            if(sInstance == null){
                throw new NullPointerException("database == null");
            }
        }
        return sInstance;
    }

    /**
     * 获取SubjectDao的实例
     *
     * @return SubjectDao实例
     */
    public abstract UserDao getUserDao();

    /**
     * 获取CourseDao的实例
     * @return
     */
    public abstract CourseDao getCourseDao();

    /**
     * 获取NoteDao的实例
     * @return
     */
    public abstract NoteDao getNoteDao();

}
