package model;


import java.util.Date;

public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String photoPath;

    private Date birthday;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String firstname) {
        this.firstName = firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void getInfo(){
        System.out.printf("Person info [  " + " Name: " + firstName + ", Last Name: " + lastName + ", birthday: " +birthday +"   ]"+"\n");
    }

}
