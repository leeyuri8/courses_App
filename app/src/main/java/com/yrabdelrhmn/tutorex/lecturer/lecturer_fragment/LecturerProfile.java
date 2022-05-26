package com.yrabdelrhmn.tutorex.lecturer.lecturer_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;
import com.yrabdelrhmn.tutorex.R;


public class LecturerProfile extends Fragment {

    TextView nameTV, emailTV, mobileTV;
    String name, email, mobile;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    private Context mContext;

    String userId;
    StorageReference storageReference;
    FirebaseFirestore firebaseFirestore;
    CollectionReference collectionReference;
    ImageView logout;

    public LecturerProfile() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lecturer_profile, container, false);

        emailTV = root.findViewById(R.id.profileEmail);
        nameTV = root.findViewById(R.id.userName);
        mobileTV = root.findViewById(R.id.profilePhone);
        logout = root.findViewById(R.id.logout);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseUser = firebaseAuth.getCurrentUser();
//        assert firebaseUser != null;
//        String uId = firebaseUser.getUid();
//        LecturerModel model = new LecturerModel();
//
//
//        firebaseFirestore = FirebaseFirestore.getInstance();
//        collectionReference = firebaseFirestore.collection("lecturers");
//
//        DocumentReference documentReference = firebaseFirestore.collection("lecturers").document(uId);
//        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                assert value != null;
//                if (value.exists()){
//                   emailTV.setText(model.lectureremail);
//                   nameTV.setText(model.lecturername);
//                   mobileTV.setText(model.lecturermobile);
//                } else {
//                    Log.d("tag", "onEvent: Document do not exists");
//                }
//            }
//        });
//
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getActivity(), Register.class);
//
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//            }
//        });
//
//
//
//    }
    }
}