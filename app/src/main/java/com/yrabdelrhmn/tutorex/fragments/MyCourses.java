package com.yrabdelrhmn.tutorex.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.yrabdelrhmn.tutorex.R;


public class MyCourses extends Fragment {
     RecyclerView rv;
     DatabaseReference databaseReference;
    public MyCourses() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_my_courses, container, false);

       rv = root.findViewById(R.id.mycoursesRv);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();
    }
}