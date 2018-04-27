package by.itacademy.hibernate.demo;

import by.itacademy.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try { //use the session object to save Java object
             //create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Sasha", "Off", "off@tut.by");

            //start a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);
            //commit transactions
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }finally {
            factory.close();
        }
    }
}
