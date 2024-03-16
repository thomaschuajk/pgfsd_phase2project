package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BatchEditServlet
 */
public class BatchEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BatchDAO _batchDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchEditServlet() {
        
        this._batchDAO = new BatchDAO();      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int batchId = Integer.parseInt(request.getParameter("id"));
		Batch batch = this._batchDAO.GetBatchById(batchId);
		request.setAttribute("batch", batch);
		request.getRequestDispatcher("batchEditForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
