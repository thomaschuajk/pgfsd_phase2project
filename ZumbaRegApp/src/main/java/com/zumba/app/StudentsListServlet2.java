package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class StudentsListServlet2
 */
public class StudentsListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO _studentDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsListServlet2() {        
        // TODO Auto-generated constructor stub
    	this._studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Pair> pairs = this._studentDAO.GetAllStudentsWithBatchDetail();
		
		//HttpSession session =  request.getSession(true);
		//session.setAttribute("students", students);
		request.setAttribute("pairs", pairs);
		request.getRequestDispatcher("studentsList3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
