package com.example.thuchanh_m3.dao;

import com.example.thuchanh_m3.model.Classroom;
import com.example.thuchanh_m3.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class StudentDAO implements IStudentDAO {

    String url = "jdbc:mysql://localhost:3306/student?userSSL=false";
    String username = "root";
    String password = "kiseki99!!";

    protected Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void addStudent(Student student) {
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO student (name, dateofbirth, email, address, phone, class_id)\n" +
                     "VALUES (?, ?, ?, ?, ?, (SELECT id FROM classroom WHERE name = ?));\n")) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getDateofbirth());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getPhone());
            statement.setString(6, student.getClassroom());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("SELECT student.name, student.Email, student.DateOfBirth, student.phone, student.address, classroom.name\n" +
                     "FROM student\n" +
                     "         JOIN classroom ON student.class_id = classroom.id\n" +
                     "WHERE student.id = ?");
        ) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String dateofbirth = rs.getString("dateofbirth");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String classroom = rs.getString("classroom.name");
                student = new Student(id, name, dateofbirth, email, address, phone, classroom);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("SELECT student.id, student.name, student.Email, student.DateOfBirth, student.phone, student.address, classroom.name\n" +
                     "FROM student\n" +
                     "         JOIN classroom ON student.class_id = classroom.id;")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateofbirth = rs.getString("dateofbirth");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String classroom = rs.getString("classroom.name");

                students.add(new Student(id, name, dateofbirth, email, address, phone, classroom));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean rowDeleted;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE id = ?");
        ) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean rowUpdated;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("UPDATE student\n" +
                     "SET\n" +
                     "    name = ?,\n" +
                     "    email = ?,\n" +
                     "    dateofbirth = ?,\n" +
                     "    phone = ?,\n" +
                     "    address = ?,\n" +
                     "    class_id = (SELECT id FROM classroom WHERE name = ?)\n" +
                     "WHERE\n" +
                     "    id = ?;")) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDateofbirth());
            statement.setInt(4, student.getPhone());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getClassroom());
            statement.setInt(7, student.getId());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    public List<Classroom> getAllClassrooms() {
        List<Classroom> classrooms = new ArrayList<>();

        // Assume you have a method to get a database connection
        try (Connection connection = getConnect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT name FROM classroom")) {

            while (resultSet.next()) {
                Classroom classroom = new Classroom(resultSet.getString("name"));
                classrooms.add(classroom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception as needed
        }
        return classrooms;
    }

    public List<Student> getStudentbySearch(String searchName) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT student.id, student.name, student.Email, student.DateOfBirth, student.phone, student.address, classroom.name\n" +
                "FROM student\n" +
                "         JOIN classroom ON student.class_id = classroom.id\n" +
                "WHERE student.name LIKE ?;";
        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + searchName + "%");

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String dateofbirth = rs.getString("dateofbirth");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    int phone = rs.getInt("phone");
                    String classroom = rs.getString("classroom.name");

                    students.add(new Student(id, name, dateofbirth, email, address, phone, classroom));
                    System.out.println(preparedStatement);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkInfor(String email, int phone) throws SQLException {

        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM student WHERE email = '" + email + "' OR phone ='" + phone + "'");) {
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


}
