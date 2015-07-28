 package com.test.jdbc;


import java.util.List;

import com.test.dto.StudentDTO;

public class DAOAppDemo {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		List<StudentDTO> studentList = studentDAO.getAllStudents();
		
		for(StudentDTO studentDTO : studentList){
			System.out.println(studentDTO);
		}
		
		
		/*StudentDTO studentDTO = new StudentDTO(45678, "Rama", "MBBS", 6543);
		if(studentDAO.addStudent(studentDTO)){
			System.out.println("Student Added in DB.");
		}else{
			System.out.println("Failed to Add Stduent .. Look into the Logs");
		}
				*/

	}

}

