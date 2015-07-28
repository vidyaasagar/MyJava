package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dto.StudentDTO;

public class StudentDAO {
	
	public boolean addStudent(StudentDTO studentDTO){
		Connection connection = null;
		try{
			connection = DBUtil.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			pstmt.setInt(1, studentDTO.getSno());
			pstmt.setString(2, studentDTO.getSname());
			pstmt.setString(3, studentDTO.getCourse());
			pstmt.setInt(4, studentDTO.getFee());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("Something went wrong while adding student Record in the DB."+studentDTO);
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		return false;
	}
	
	public boolean updateStudent(StudentDTO studentDTO){
		Connection connection = null;
		try{
			connection = DBUtil.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement("UPDATE STUDENT SET SNAME= ?,COURSE=?,FEE=? where Sno = ?");
			pstmt.setInt(4, studentDTO.getSno());
			pstmt.setString(1, studentDTO.getSname());
			pstmt.setString(2, studentDTO.getCourse());
			pstmt.setInt(3, studentDTO.getFee());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("Something went wrong while updaing student Record in the DB." + studentDTO);
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		return false;
	}
	
	public boolean deleteStudent(int sno){
		Connection connection = null;
		try{
			connection = DBUtil.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM STUDENT  where Sno = ?");
			pstmt.setInt(1, sno);
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("Something went wrong while Deleteing student Record in the DB." + sno);
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		return false;
	}
	
	public StudentDTO getStudent(int sno){
		Connection connection = null;
		try{
			connection = DBUtil.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * from STUDENT where Sno = ?");
			pstmt.setInt(1, sno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setSno(rs.getInt("Sno"));
				studentDTO.setSname(rs.getString("Sname"));
				studentDTO.setCourse(rs.getString("Course"));
				studentDTO.setFee(rs.getInt("Fee"));
				return studentDTO;
			}
		}catch(Exception ex){
			System.out.println("Something went wrong while Reding student Record in the DB." + sno);
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		System.out.println("Student Not Found    .");
		return null;
	}
	
	public List<StudentDTO> getAllStudents(){
		Connection connection = null;
		List<StudentDTO> stuList = new ArrayList<StudentDTO>();
		try{
			connection = DBUtilV1.getDBConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * from STUDENT");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setSno(rs.getInt("Sno"));
				studentDTO.setSname(rs.getString("Sname"));
				studentDTO.setCourse(rs.getString("Course"));
				studentDTO.setFee(rs.getInt("Fee"));
				stuList.add(studentDTO);
			}
		}catch(Exception ex){
			System.out.println("Something went wrong while Reding student Record in the DB.");
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		return stuList;
	}

}
