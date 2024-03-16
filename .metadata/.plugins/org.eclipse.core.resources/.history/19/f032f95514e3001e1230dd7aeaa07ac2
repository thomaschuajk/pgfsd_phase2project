package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class BatchFormServlet
 */
public class BatchFormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private BatchDAO _batchDAO;

    /**
     * Default constructor. 
     */
    public BatchFormServlet() {
        // TODO Auto-generated constructor stub
    	_batchDAO = new BatchDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("batchForm.jsp").forward(request,response);
		response.sendRedirect("batcheslist");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Retrieve data from form
		String startDate = request.getParameter("startdate");
		String endDate = request.getParameter("enddate");
		String sessionTime = request.getParameter("sessiontime");
		
		//Create a Batch Object
		Batch batch = new Batch();
		batch.setStartDate(startDate);
		batch.setEndDate(endDate);
		batch.setSessionTime(sessionTime);
		
		//Update Batches database
		_batchDAO.AddBatch(batch);
		
		//Redirect to the batches list page after adding
		response.sendRedirect("batcheslist");
		
		
	}

}
