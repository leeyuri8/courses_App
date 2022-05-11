package com.yrabdelrhmn.tutorex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yrabdelrhmn.tutorex.R;
import com.yrabdelrhmn.tutorex.fragments.Chat;
import com.yrabdelrhmn.tutorex.fragments.Courses;
import com.yrabdelrhmn.tutorex.fragments.MyCourses;
import com.yrabdelrhmn.tutorex.fragments.Profile;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Button joinBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bottomNavigationView = findViewById(R.id.bottomNavigationView);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
       bottomNavigationView.setSelectedItemId(R.id.courses);



    }
    Courses courses = new Courses();
    MyCourses myCourses = new MyCourses();
    Chat chat = new Chat();
    Profile profile = new Profile();

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected( @NotNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.courses:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, courses).commit();
                return true;

            case R.id.my_courses:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, myCourses).commit();
                return true;

            case R.id.chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, chat).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profile).commit();
                return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}


