package ru.gb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.model.Student;

import java.util.List;


public class StudentDao {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        runStudentDao();
    }

    public static void runStudentDao() {
        try {
            init();
            findAll();
            saveStudent("Student_4", 88);
            findById(4L);
            updateStudent(1L, "Student_Vasya", 55);
            findAll();
            deleteStudent(2L);
            findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void init() {
        sessionFactory = new Configuration()
                .configure("config/crud/hibernate.cfg.xml" )
                .buildSessionFactory();
    }

    public static void shutdown() {
        sessionFactory.close();
    }

    public static void saveStudent(String name, int mark) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = new Student(/*id, */name, mark);
            session.save(student);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void deleteStudent(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void updateStudent(Long id, String name, int mark) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setName(name);
            student.setMark(mark);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void findById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            System.out.println(student.toString());
            session.close();
        }
    }

    public static void findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            System.out.println(students + "\n");
            session.getTransaction().commit();
        }
    }
}
