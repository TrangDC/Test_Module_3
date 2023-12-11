package com.example.thuchanh_m3.dao;

import com.example.thuchanh_m3.model.Student;

import java.util.List;

public interface IStudentDAO {
    public void addStudent(Student student);
    public Student selectStudent(int id);
    public List<Student> getAllStudent();
    public boolean deleteStudent(int id);
    public boolean updateStudent(Student student);


}
