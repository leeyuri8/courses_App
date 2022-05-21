package com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.yrabdelrhmn.tutorex.lecturer.AddCourse;
import com.yrabdelrhmn.tutorex.adapter.LecturerCourseAdapter;
import com.yrabdelrhmn.tutorex.model.CourseInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class LecturerCourses extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    private Context mContext;
    private ArrayList<CourseInfo> coursesList;
    private LecturerCourseAdapter courseAdapter = null;
    CourseInfo model;
    SearchView searchView;
    FloatingActionButton addBtn;
    String text;
    public LecturerCourses() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_lecturer_courses, container, false);
        mContext = container.getContext();
         recyclerView = root.findViewById(R.id.lect_coursesRv);
        addBtn = root.findViewById(R.id.addCourse);
        FirebaseApp.initializeApp(mContext);


        addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddCourse.class));
            }
        });

        return root;

    }
    @Override
    public void onStart() {
        super.onStart();
        getCourses();
    }

            private void getCourses() {
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
                    courseAdapter = new LecturerCourseAdapter(mContext,(ArrayList<CourseInfo>) coursesList);
                    recyclerView.setAdapter(courseAdapter);
                    courseAdapter.notifyDataSetChanged();

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