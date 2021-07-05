package cl.inacap.AsistentesApp.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cl.inacap.asistentesModel.dao.AsistentesDAOLocal;
import cl.inacap.asistentesModel.dto.Asistente;

/**
 * Servlet implementation class VerAsistentesController
 */
@WebServlet("/VerAsistentesController.do")
public class VerAsistentesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private AsistentesDAOLocal asistentesDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerAsistentesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		

		List<Asistente> asistentess=  asistentesDAO.getAll();
		request.setAttribute("asistentess", asistentess);
		
		request.getRequestDispatcher("WEB-INF/vistas/verAsistentes.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String estado = request.getParameter("filtro-select").trim();
		List<Asistente> asistentes = asistentesDAO.filterByEstado(estado);
		request.setAttribute("asistentes", asistentes);
		doGet(request, response);
	}

}
