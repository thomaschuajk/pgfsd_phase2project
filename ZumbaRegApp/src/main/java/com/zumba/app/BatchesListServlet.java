package com.zumba.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BatchesListServlet
 */
public class BatchesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BatchDAO _batchDAO;

    /**
     * Default constructor. 
     */
    public BatchesListServlet() {
        _batchDAO = new BatchDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Batch> batches = this._batchDAO.GetAllBatches();
		System.out.println(batches.size());
		//HttpSession session =  request.getSession(true);
		//session.setAttribute("students", students);
		request.setAttribute("batches", batches);
		request.getRequestDispatcher("batchesList.jsp").forward(request, response);
	}

}
