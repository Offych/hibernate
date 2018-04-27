package by.itacademy.hibernate.demo;

import by.itacademy.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try { //use the session object to save Java object
            //create 3 student objects

            System.out.println("Creating 3 students object...");
            Student tempStudent2 = new Student("alex", "POff", "of2f@tut.by");
            Student tempStudent3 = new Student("polya", "Offyc", "of3f@tut.by");
            Student tempStudent4 = new Student("Kolya", "ivanov", "of4f@tut.by");


            //start a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.save(tempStudent4);
            //commit transactions
            session.getTransaction().commit();

            System.out.println("Done!!!");

        }finally {
            factory.close();
        }
    }
}
