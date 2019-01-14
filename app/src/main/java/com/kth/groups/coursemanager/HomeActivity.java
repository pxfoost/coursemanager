package com.kth.groups.coursemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private String student_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //从LoginActivity中获得student_ID
        Intent intent = getIntent();
        student_ID = intent.getStringExtra("student_ID");

        Log.d("student_ID",student_ID);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectedFragment(item.getItemId());
                return false;
            }
        });
    }


    public void selectedFragment(int id){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(String.valueOf(id));
        if(fragment == null){
            fragment = createFragment(id);
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_container,fragment,String.valueOf(id));
        transaction.commitAllowingStateLoss();
    }

    /**
     * 创建对应第id的fragment实例
     * @param id
     * @return
     */
    private Fragment createFragment(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.notes:
               fragment = NotesFragment.newInstance(student_ID);
                Toast.makeText(HomeActivity.this,"note note note",Toast.LENGTH_SHORT).show();
                break;
            case R.id.course:
                fragment = CourseFragment.newInstance(student_ID);
                Toast.makeText(HomeActivity.this,"course course course",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine:
                fragment = UserFragment.newInstance(student_ID);
                Toast.makeText(HomeActivity.this,"it it mine",Toast.LENGTH_SHORT).show();
                break;
        }

        return fragment;
    }

}
