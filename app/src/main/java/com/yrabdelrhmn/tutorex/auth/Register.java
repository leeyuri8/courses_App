package com.yrabdelrhmn.tutorex.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yrabdelrhmn.tutorex.R;
import com.yrabdelrhmn.tutorex.lecturer.HomePage;
import com.yrabdelrhmn.tutorex.lecturer.model.LecturerModel;
import com.yrabdelrhmn.tutorex.student.MainActivity;
import com.yrabdelrhmn.tutorex.student.Student;

import org.jetbrains.annotations.NotNull;

public class Register extends AppCompatActivity  {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    Button registerBtn , loginBtn;
    EditText email,pass, name , mobile;
    RadioButton lecturer, student;
    RadioGroup radioGroup;
//    String lecturerid , studentid;
    String userEmail,userPass, userName ,  userMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        //  loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        email = findViewById(R.id.editTextTextEmailAddress);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RGroup);

        pass = findViewById(R.id.editTextTextPassword);
        name = findViewById(R.id.editTextTextName);
        mobile = findViewById(R.id.editTextTextMobile);

        lecturer = findViewById(R.id.radio1);
        student = findViewById(R.id.radio2);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == R.id.radio1) {
                    registerBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            registerLecturer();
                        }
                    });

                } if (id == R.id.radio2) {
                    registerBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            registerStudent();
                        }
                    });

                }
            }
        });
    }

   private void registerLecturer(){
       userEmail = email.getText().toString();
       userPass = pass.getText().toString();
       userName = name.getText().toString();
       userMobile = mobile.getText().toString();

       if (TextUtils.isEmpty(userEmail)) {
           Toast.makeText(getApplicationContext(),
                   "Please enter email!!",
                   Toast.LENGTH_LONG)
                   .show();
           return;
       }
       if (TextUtils.isEmpty(userPass)) {
           Toast.makeText(getApplicationContext(),
                   "Please enter password!!",
                   Toast.LENGTH_LONG)
                   .show();
           return;
       }
       firebaseAuth.createUserWithEmailAndPassword(userEmail,userPass)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete( @NotNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Toast.makeText(Register.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                           addDataLecturer(userEmail,userName,userMobile);
                           startActivity(new Intent(Register.this, HomePage.class));
                  }
                       Toast.makeText(Register.this, "Failure", Toast.LENGTH_SHORT).show();


                   }
               });
   }
    private void registerStudent(){
        userEmail = email.getText().toString();
        userPass = pass.getText().toString();
        userName = name.getText().toString();
        userMobile = mobile.getText().toString();

        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(userPass)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            addDataStudent(userEmail,userName,userMobile);
                            startActivity(new Intent(Register.this,MainActivity.class));
                        }
                    }
                });
    }
   private void addDataLecturer(String email, String name, String mobile){
       CollectionReference dbRef = firebaseFirestore.collection("lecturers");
       LecturerModel model = new LecturerModel(email,name,mobile);
       dbRef.add(model).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
           @Override
           public void onSuccess(DocumentReference documentReference) {
               Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();

           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull @NotNull Exception e) {
               Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
           }
       });
   }
    private void addDataStudent(String email, String name, String mobile) {
        CollectionReference dbRef = firebaseFirestore.collection("students");
        Student student = new Student(email,name, mobile);
        dbRef.add(student).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }




}