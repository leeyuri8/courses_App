package com.yrabdelrhmn.tutorex.lecturer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.yrabdelrhmn.tutorex.R;
import com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment.LecturerCourses;
import com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment.LecturerProfile;
import com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment.Students;

public class HomePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bottomNavigationView = findViewById(R.id.lectbottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.courses_lecturer);

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            // User is signed in
//            Intent i = new Intent(getApplicationContext(), Register.class);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(i);
//        } else {
//            // User is signed out
//            Log.d(TAG, "onAuthStateChanged:signed_out");
//        }

    }


    LecturerCourses lecturerCourses = new LecturerCourses();
    LecturerProfile lecturerProfile = new LecturerProfile();
    Students students = new Students();
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()) {

            case R.id.courses_lecturer:
                getSupportFragmentManager().beginTransaction().replace(R.id.lect_fragment, lecturerCourses).commit();
                return true;

            case R.id.Students:
                getSupportFragmentManager().beginTransaction().replace(R.id.lect_fragment, students).commit();
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