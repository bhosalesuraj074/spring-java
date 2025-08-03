package com.hibernate;

import com.address.TableNamingStrategy;
import com.billing.BankDetails;
import com.billing.CreditCard;
import com.manttomany.Course;
import com.manttomany.Student;
import com.onetomany.Department;
import com.onetomany.Employee;
import com.onetoone.Address;
import com.onetoone.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

       /* Configuration cfg = new Configuration().addResource("vehicle-hbm.xml");
        cfg.configure("hibernate-cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
*/

        /*
        //inserting the data into the table
        Message message = new Message();
        message.setMessage("This is the example of the hibernate ORM mapping");
        session.persist(message);*/

        // select from the database
       /* List<Message> list = session.createQuery("from Message", Message.class).getResultList();
        System.out.println(list);*/

        //updating data into the table


        // Vehicle operations
       /* Vehicle vehicle = new Vehicle();
        vehicle.setModel("classic 350");
        vehicle.setVehicleName("Bullet");
        vehicle.setYear(LocalDateTime.now().toString());
        vehicle.setPrice(3);
        session.persist(vehicle);

        //update the record into the database
       *//* Vehicle vehicle = session.find(Vehicle.class, 2);
        vehicle.setPrice(69);*//*
        transaction.commit();
        System.out.println("Record inserted successfully ... ");*/


        //  user address related operation

         /*SessionFactory factory = new Configuration()
                 .addResource("emp-address.orm.xml")
                 .setPhysicalNamingStrategy(new TableNamingStrategy())
                 .buildSessionFactory();
         Session session =  factory.openSession();
         Transaction transaction =  session.beginTransaction();

            User user = new User();
            user.setFirstName("Jalindar");
            user.setLastName("Bhosale");
            user.setUsername("bhosalejalindar");
            user.setPassword("jbhosale");

            Address homeAddress = new Address();
            homeAddress.setStreet("Jay-ram vasti");
            homeAddress.setZipcode(413306);
            homeAddress.setCity("sangola");
            user.setHomeAddress(homeAddress);

            Address officeAddress =  new Address();
            officeAddress.setStreet("Rajkot Aarya Nagar ");
            officeAddress.setZipcode(235534);
            officeAddress.setCity("Rajkot");
            user.setOfficeAddress(officeAddress);

            session.persist(user);
            transaction.commit();
        System.out.println("Record Added Successfully");*/

   /*     SessionFactory sessionFactory = new Configuration()
//                .addResource("Bank_Account.orm.xml")
                .addResource("Billing_pk-fk.orm.xml")
               // .setPhysicalNamingStrategy(new TableNamingStrategy())
                .buildSessionFactory();*/

       /* Session session  =   sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/

        /*BankDetails bankDetails = new BankDetails();
        bankDetails.setOwner("Suraj Bhosale");
        bankDetails.setNumber("1234567890");
        bankDetails.setDate(LocalDate.now());
        bankDetails.setBankName("HDFC bank");
        bankDetails.setAccountNumber("HDFC1234567890");
        session.persist(bankDetails);*/

       /* CreditCard cc = new CreditCard();
        cc.setOwner("Vidhya Bhosale");
        cc.setMobileNumber("987987779");
        cc.setDate(LocalDate.now());
        cc.setType("Merchant Payment");
        cc.setExpMonth("feb");
        cc.setExpYear("2022");


        BankDetails bankDetails = new BankDetails();
        bankDetails.setOwner("Jalindar Bhosale");
        bankDetails.setMobileNumber("9011655409");
        bankDetails.setDate(LocalDate.now());
        bankDetails.setBankName("IDFC BANK");
        bankDetails.setAccountNumber("IDFCBK1345");

        session.persist(bankDetails);
        session.persist(cc);
        transaction.commit();*/

        // Table Association : oto, otm, mto, mtm

        SessionFactory sessionFactory = new Configuration()
                .addResource("student-mtm.orm.xml")
                .addResource("courses-mtm.orm.xml")
                //.setPhysicalNamingStrategy(new TableNamingStrategy())
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        1. one to one example
        /*User user = new User();
        user.setUserName("Sujal Bhosale");
        Address address = new Address();
        address.setCity("Rajkot");
        address.setState("Gujrat");
        user.setAddress(address);
        session.persist(user);
        transaction.commit();*/

//       2. many to one employees

        /*Department  department  = new Department();
        department.setDepartmentName("IT Department");

        Department department2 = new Department();
        department2.setDepartmentName("Marketing");

        Employee emp1 = new Employee();
        emp1.setEmpName("Suraj");
        emp1.setDepartment(department);

        Employee emp2 = new Employee();
        emp2.setEmpName("Sujal");
        emp2.setDepartment(department);

        Employee employee3 = new Employee();
        employee3.setEmpName("Bhosale sarkar");
        employee3.setDepartment(department2);
        session.persist(emp1);
        session.persist(emp2);
        session.persist(employee3);
        transaction.commit();*/

//        3. many to one


//        4. many to many

        Student student1 = new Student();
        student1.setName("Suraj");

        Student student2 = new Student();
        student2.setName("Ganesh");

        Course course1  = new Course();
        course1.setTitle("Java");

        Course course2 = new Course();
        course2.setTitle("Spring Boot");

        Course course3 = new Course();
        course3.setTitle("Hibernate");

        student1.setCourses(Set.of(course1,course2, course3));
        student2.setCourses(Set.of(course1, course2));

        course1.setStudents(Set.of(student1, student2));
        course2.setStudents(Set.of(student1, student2));
        course3.setStudents(Set.of(student1, student2));

        session.persist(course1);
        session.persist(course2);
        session.persist(course3);
        transaction.commit();

        System.out.println("Data inserted successfully");


    }
}