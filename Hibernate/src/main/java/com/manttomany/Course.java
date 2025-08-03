package com.manttomany;

import java.util.Set;

public class Course {
    private int id;
    private String title;
    private Set<Student> students;

    public Course() {
    }

    public Course(int id, String title, Set<Student> students) {
        this.id = id;
        this.title = title;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
