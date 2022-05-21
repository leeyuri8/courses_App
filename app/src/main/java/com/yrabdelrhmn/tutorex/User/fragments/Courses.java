package com.yrabdelrhmn.tutorex.User.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yrabdelrhmn.tutorex.R;
import com.yrabdelrhmn.tutorex.adapter.UserCourseAdapter;
import com.yrabdelrhmn.tutorex.model.CourseInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Courses extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    private Fragment mFragment;
    private Context mContext;
    private Button joinBtn;
    private ArrayList<CourseInfo> coursesList;
    private UserCourseAdapter userCourseAdapter = null;
    CourseInfo model;
    SearchView searchView;
    FloatingActionButton addBtn;
     String text;
    public Courses newInstance() {
        return new Courses();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses, container, false);

       recyclerView = root.findViewById(R.id.coursesRv);
       searchView = root.findViewById(R.id.search);

        mContext = container.getContext();
        addBtn = root.findViewById(R.id.addCourse);
        text = searchView.getQuery().toString();
        FirebaseApp.initializeApp(mContext);

//
//        addBtn.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), AddCourse.class));
//            }
//        });

        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
          getCourses();

        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }


    private void search(String newText) {
        ArrayList<CourseInfo> mylist = new ArrayList<>();
        for (CourseInfo object : coursesList){
            if (object.getCourseName().toLowerCase().contains(newText.toLowerCase())){
                        mylist.add(object);
            }
            UserCourseAdapter userCourseAdapter = new UserCourseAdapter(mContext,mylist);
            recyclerView.setAdapter(userCourseAdapter);
        }

    }

    private void getCourses(){
        coursesList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setNestedScrollingEnabled(false);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("courses");
        DatabaseReference myCourses = FirebaseDatabase.getInstance().getReference().child("mycourses");

        databaseReference.addValueEventListener(new ValueEventListener() {
        @Override

        public void onDataChange( @NotNull DataSnapshot snapshot) {
        coursesList.clear();
        for (DataSnapshot dataSnapshot : snapshot.getChildren()){
        CourseInfo courseInfo = dataSnapshot.getValue(CourseInfo.class);
        coursesList.add(courseInfo);
        userCourseAdapter = new UserCourseAdapter(mContext,(ArrayList<CourseInfo>) coursesList);
        recyclerView.setAdapter(userCourseAdapter);
        userCourseAdapter.notifyDataSetChanged();

        }
        }

        @Override
        public void onCancelled( @NotNull DatabaseError error) {
            Toast.makeText(getContext(),"Error: "+error.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

        );
    }



}
