package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class StudentEditServlet
 */
public class StudentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDAO _studentDAO;
	private Student _student;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditServlet() {
        this._studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(request.getParameter("id"));
		this._student = this._studentDAO.GetStudentById(studentId);
		request.setAttribute("student", this._student);
		request.getRequestDispatcher("studentEditForm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve form parameters		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		int batchid = Integer.parseInt(request.getParameter("batchid"));
		
		//Update Student object
		this._student.setFName(fname);
		this._student.setLName(lname);
		this._student.setEMail(email);
		this._student.setBatchId(batchid);
		
		//Send to StudentDAO to update database
		this._studentDAO.UpdateStudent(this._student);
		
		response.sendRedirect("studentslist2");
		
		
	}

}
