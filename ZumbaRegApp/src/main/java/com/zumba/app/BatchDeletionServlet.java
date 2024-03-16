package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BatchDeletionServlet
 */
public class BatchDeletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BatchDAO _batchDAO;

    /**
     * Default constructor. 
     */
    public BatchDeletionServlet() {
        this._batchDAO = new BatchDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int batchId = Integer.parseInt(request.getParameter("id"));
		this._batchDAO.DeleteStudent(batchId);
		
		//Redirect to the student list page after deletion
		response.sendRedirect("batcheslist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
