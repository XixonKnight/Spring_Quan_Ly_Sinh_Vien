package application.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "dbo_student")
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_student")
    private int id_student;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "dob")
    private Date dob;


    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
