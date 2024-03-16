package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class StudentFormServlet
 */
//@WebServlet("/studentform")
public class StudentFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

    /**
     * Default constructor. 
     */
    public StudentFormServlet() {
        // TODO Auto-generated constructor stub
    	studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("studentForm.jsp").forward(request,response);
		response.sendRedirect("studentslist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve form parameters
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String batchid = request.getParameter("batchid");
		
		//Create a Student Object
		Student student = new Student();
		student.setFName(fname);
		student.setLName(lname);
		student.setEMail(email);
		student.setBatchId(Integer.parseInt(batchid));
		System.out.println(student.getBatchId());
		
		//Add the student to the database
		studentDAO.AddStudent(student);
		
		//Redirect to the student list page after adding
		response.sendRedirect("studentslist");
				
	}

}