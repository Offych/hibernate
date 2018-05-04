package by.itacademy.hibernate.demo;

import by.itacademy.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {

        try (
                // create session factory
                SessionFactory factory = new Configuration()
                        .configure()
                        // .addAnnotatedClass(Student.class) -->
                        // в конфигурационном файле замапен <mapping class="by.itacademy.hibernate.demo.entity.Student" />
                        .buildSessionFactory();
                //create session
                Session session = factory.openSession()) {
            int studentId = 1;
            //start a transaction
            session.beginTransaction();
            System.out.println("\nGetting student with Id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
//            System.out.println("Updating Student: " );
//            //update object
//            myStudent.setFirstName("Scooby");

            //NEW CODEupdate email for all students
            session.createQuery("update Student set email='foo@tut.com'")
                    .executeUpdate();
            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done...");
        }
    }
}
