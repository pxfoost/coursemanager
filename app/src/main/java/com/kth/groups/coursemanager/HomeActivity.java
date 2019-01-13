package com.kth.groups.coursemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.notes:
                        Toast.makeText(HomeActivity.this,"note note note",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.course:
                        Toast.makeText(HomeActivity.this,"course course course ",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.mine:
                        Toast.makeText(HomeActivity.this,"it is mine",Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }
}
