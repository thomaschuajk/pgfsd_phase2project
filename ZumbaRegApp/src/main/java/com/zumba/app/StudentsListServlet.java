package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class StudentsListServlet
 */
public class StudentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDAO _studentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsListServlet() {
    	
        this._studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		List<Student> students = this._studentDAO.GetAllStudents();
		System.out.println(students.size());
		//HttpSession session =  request.getSession(true);
		//session.setAttribute("students", students);
		request.setAttribute("students", students);
		request.getRequestDispatcher("studentsList2.jsp").forward(request, response);
		
	}

}