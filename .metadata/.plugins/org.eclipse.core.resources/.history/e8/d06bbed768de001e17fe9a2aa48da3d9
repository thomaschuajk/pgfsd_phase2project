package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class StudentDeletionServlet
 */
public class StudentDeletionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private StudentDAO _studentDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeletionServlet() {
       this._studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.parseInt(request.getParameter("id"));
		this._studentDAO.DeleteStudent(studentId);
		
		//Redirect to the student list page after deletion
		response.sendRedirect("studentslist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
