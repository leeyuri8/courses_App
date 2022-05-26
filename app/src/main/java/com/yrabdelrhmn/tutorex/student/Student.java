package com.yrabdelrhmn.tutorex.student;

public class Student {
    public String email;
    public String name;
    public String mobile;

    public Student(String email, String name, String mobile) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
//public class Student implements Serializable {
//    public String Firstname,Middlename,Familyname,Address,MobileNum,image,email,token,id;
//
//    public String getFirstname() {
//        return Firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        Firstname = firstname;
//    }
//
//    public String getMiddlename() {
//        return Middlename;
//    }
//
//    public void setMiddlename(String middlename) {
//        Middlename = middlename;
//    }
//
//    public String getFamilyname() {
//        return Familyname;
//    }
//
//    public void setFamilyname(String familyname) {
//        Familyname = familyname;
//    }
//
//    public String getAddress() {
//        return Address;
//    }
//
//    public void setAddress(String address) {
//        Address = address;
//    }
//
//    public String getMobileNum() {
//        return MobileNum;
//    }
//
//    public void setMobileNum(String mobileNum) {
//        MobileNum = mobileNum;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//}
