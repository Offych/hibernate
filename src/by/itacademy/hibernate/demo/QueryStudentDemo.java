package by.itacademy.hibernate.demo;

import by.itacademy.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {

        try (// create session factory with try with resourses
             SessionFactory factory = new Configuration()
                     .configure()
                     //.addAnnotatedClass(Student.class)  --> map this class in the hibernate.cfg.xml
                     .buildSessionFactory();

             //create session
             Session session = factory.openSession()) {
                 //end of try-with-resoursres block)

            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            displayStudents(theStudents);

            //query students: lastName Off
            theStudents = session.createQuery("from Student s where s.lastName='Off'").getResultList();

            //query students : firstName polya or lastName duck
            System.out.println("Query with 2 parameters");
            theStudents = session.createQuery("from Student s where firstName='polya' or lastName='duck'").getResultList();
            displayStudents(theStudents);



            //display the students
            System.out.println("\n\nThe student who have a lstName of Off");
            displayStudents(theStudents);

            //query students with email ending gmail.com
            System.out.println("\n\nQuery for email");
            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
            System.out.println(theStudents);

            //commit transactions
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }
}
