package com.hibernate.hibernateex;

import com.hibernate.hibernateex.dao.StudentDAO;
import com.hibernate.hibernateex.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateexApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateexApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsForLastName(studentDAO);
//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("deleted row count:" +numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=7;
		System.out.println("deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrive the student based on id
		int studentid=1;
		System.out.println("getting the student with" + studentid);
		Student myStudent=studentDAO.findById(studentid);

		//change the first name to abhi
		myStudent.setFirstname("abhinay");


		//update the student
		studentDAO.update(myStudent);

		//display the student
		System.out.println(myStudent);
	}

	private void queryForStudentsForLastName(StudentDAO studentDAO) {
		//get the list of student
		List<Student>theStudents=studentDAO.findByFirstName("joseph");
		//display all students
		for(Student theStudent:theStudents){
			System.out.println(theStudent);
		}
		int size=theStudents.size();
		if(size==0){
			System.out.println("the database empty or check the studentDaoimpl");
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get the list of students

		List<Student> theStudents=studentDAO.findAll();
		//display the list of students
		for(Student thestudent:theStudents){
			System.out.println(thestudent);
		}
		System.out.println("and the number of students in the table is " +theStudents.size());
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("creating the new student standby....");
		Student student1=new Student("sofia","jetti","sofia@gmail.com");

//		save the student
		System.out.println("saving the student standby.....");
		studentDAO.save(student1);

//		display id for the saved student
		int id= student1.getId();
		System.out.println(id);

//		retrieve student based on the id :primary key
		System.out.println("retreving the student with id:"+id);
		Student myStudent=studentDAO.findById(id);

//		display the student
		System.out.println("found the student:"+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating...standby....");
		Student student1=new Student("sravanthi","jetti","sravanthi@gmail.com");
		Student student2=new Student("suja","jetti","suja@gmail.com");
		Student student3=new Student("lakshmana rao","jetti","lakshmanaRao@gmail.com");

		//saving the student
		System.out.println("saving students standby...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		//display id of the saved student
		System.out.println("saved student.Genrated id: "+student1.getId());
		System.out.println("saved student.Genrated id: "+student2.getId());
		System.out.println("saved student.Genrated id: "+student3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("creating new student object");

		Student tempStudent=new Student("abhinay","jetti","abhinay@gmail.com");



		//save the student object
		System.out.println("saving the student object");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student.Genrated id: "+tempStudent.getId());

	}
}
