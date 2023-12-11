package com.example.thuchanh_m3.controller;

import com.example.thuchanh_m3.dao.StudentDAO;
import com.example.thuchanh_m3.model.Classroom;
import com.example.thuchanh_m3.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    @Override
    public void init() throws ServletException {
        this.studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormAdd(req, resp);
            case "update":
                showFormEdit(req,resp);
                break;
            case "delete":
                deleteStudent(req,resp);
                break;
            default:
                showListStudent(req,resp);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("/student/update.jsp");
        view.forward(req,resp);
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Classroom> classrooms = this.studentDAO.getAllClassrooms();
        req.setAttribute("classrooms", classrooms);
        RequestDispatcher view = req.getRequestDispatcher("/student/add.jsp");
        view.forward(req,resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentDAO.deleteStudent(id);
        List<Student> students = studentDAO.getAllStudent();
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/liststudent.jsp");
        dispatcher.forward(req, resp);
    }

    private void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = new ArrayList<Student>();
        students = this.studentDAO.getAllStudent();
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/liststudent.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertStudent(req, resp);
                break;
            case "update":
//                try {
//                    updateStudent(req, resp);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
            default:
                break;
        }
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dateofbirth = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int phone = Integer.parseInt(req.getParameter("phone"));
        String classroom = req.getParameter("class");

        Student newStudent = new Student(name, dateofbirth, email, address, phone, classroom);
        this.studentDAO.addStudent(newStudent);
        req.setAttribute("message","Da them thanh cong !");
        RequestDispatcher view = req.getRequestDispatcher("/student/add.jsp");
        view.forward(req,resp);

    }
}
