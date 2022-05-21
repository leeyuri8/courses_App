package com.yrabdelrhmn.tutorex.lecturer;//package com.yrabdelrhmn.tutorex.lecturer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yrabdelrhmn.tutorex.R;
import com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment.Analytics;
import com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment.LecturerCourses;
import com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment.LecturerProfile;

import org.jetbrains.annotations.NotNull;

public class HomePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bottomNavigationView = findViewById(R.id.lectbottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.courses_lecturer);


    }


    LecturerCourses lecturerCourses = new LecturerCourses();
    LecturerProfile lecturerProfile = new LecturerProfile();
    Analytics analytics = new Analytics();
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()) {

            case R.id.courses_lecturer:
                getSupportFragmentManager().beginTransaction().replace(R.id.lect_fragment, lecturerCourses).commit();
                return true;

            case R.id.analytics:
                getSupportFragmentManager().beginTransaction().replace(R.id.lect_fragment, analytics).commit();
                return true;

            case R.id.lecturer_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.lect_fragment, lecturerProfile).commit();
                return true;
        }
        return false;

}


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}