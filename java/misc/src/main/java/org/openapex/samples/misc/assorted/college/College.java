package org.openapex.samples.misc.assorted.college;

import java.util.List;

public class College {
    private List<Department> depart  ;
    private List<Course> cours ;
    private List<Professor> prof  ;
    private List<Student> student;

    public List<Department> getDepart() {
        return depart;
    }

    public void setDepart(List<Department> depart) {
        this.depart = depart;
    }

    public List<Course> getCours() {
        return cours;
    }

    public void setCours(List<Course> cours) {
        this.cours = cours;
    }

    public List<Professor> getProf() {
        return prof;
    }

    public void setProf(List<Professor> prof) {
        this.prof = prof;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}