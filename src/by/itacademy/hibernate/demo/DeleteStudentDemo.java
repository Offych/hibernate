package by.itacademy.hibernate.demo;

import by.itacademy.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
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
    //        int studentId = 1;
            //start a transaction
            session.beginTransaction();
//            System.out.println("\nGetting student with Id: " + studentId);
//            Student myStudent = session.get(Student.class, studentId);

            //delete the student with id=1
//            System.out.println("Deleting student: " + myStudent);
//            session.delete(myStudent);

            //delete student with id=2 без указания id
            session.createQuery("delete from Student where id=2")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done...");
        }
    }
}
