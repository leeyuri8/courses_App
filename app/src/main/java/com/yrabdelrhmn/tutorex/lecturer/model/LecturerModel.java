package com.yrabdelrhmn.tutorex.lecturer.model;

public class LecturerModel {
    public String lectureremail;
    public String lecturername;
    public String lecturermobile;

    public LecturerModel(String email, String name , String mobile) {
        this.lectureremail = email;
        this.lecturername = name;
        this.lecturermobile = mobile;
    }

    public LecturerModel() {

    }

    public String getLecturername() {
        return lecturername;
    }

    public void setLecturername(String lecturername) {
        this.lecturername = lecturername;
    }
    //    public String lecturerpass;

//    public LecturerModel(String email) {
////        this.lecturername = name;
//        this.lectureremail = email;
//    }


    public String getLectureremail() {
        return lectureremail;
    }

    public void setLectureremail(String lectureremail) {
        this.lectureremail = lectureremail;
    }
}