package com.yrabdelrhmn.tutorex.student;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.yrabdelrhmn.tutorex.R;
import com.yrabdelrhmn.tutorex.User.fragments.Chat;
import com.yrabdelrhmn.tutorex.User.fragments.Courses;
import com.yrabdelrhmn.tutorex.User.fragments.MyCourses;
import com.yrabdelrhmn.tutorex.User.fragments.Profile;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Button joinBtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bottomNavigationView = findViewById(R.id.bottomNavigationView);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
       bottomNavigationView.setSelectedItemId(R.id.courses);
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


