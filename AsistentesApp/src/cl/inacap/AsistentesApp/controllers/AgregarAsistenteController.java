package cl.inacap.AsistentesApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AgregarAsistenteController
 */
@WebServlet("/AgregarAsistenteController.do")
public class AgregarAsistenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private AsistentesDAOLocal asistentesDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarAsistenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/agregarAsistente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errores = new ArrayList<>();

		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {
			errores.add("Debe ingresar un rut");
		}else if(rut.length() != 10) {
			errores.add("el rut debe tener 9 digitos en total");
		}else {
			List<Asistente> p = asistentesDAO.getAll();
			int n,m,v=2,s=0,rutAux;
			String d1;
			String[] rutAu = rut.split("-");
			if(rutAu[1].length()!=1) {
				errores.add("solo puede haber un digito verificador");
			}
				try {
					rutAux = Integer.parseInt(rutAu[0]);
					n = rutAu[0].length();
					
					while(n>=1) {
						m= Integer.parseInt(rut.substring(n-1,n))*v;
						s=s+m;
						++v;
						if(v>7) {
							v=2;
						}
						--n;
					}
					d1 = Integer.toString(11-(s%11));
					switch(d1) {
					case "10": d1="k";
					break;
					case "11": d1="0";
					break;
					
					}
					if(rutAux != 0) {
						boolean contiene =false;

						if(rutAu[1].equals(d1)) {
								contiene = true;
							}
						if(!contiene) {
							errores.add("Digito verificador inválido");
						}
					}
					
					
					for(Asistente i: p) {
						if(i.getRut().equalsIgnoreCase(rut)) {
							errores.add("Asistente ya Registrado");
						}
					}
					
				}catch(Exception ex) {
					errores.add("Rut inválido");
				}
		}
		
		
		String nombre = request.getParameter("nombre-txt").trim();
//		String[] palabras=nombre.split(" ");
		if (nombre.isEmpty()) {
			errores.add("Debe ingresar un Nombre");}
//		else {
//			
//			if(palabras.length< 2) {
//				errores.add("ingrese nombre y apellido separado por un espacio");
//			}
//		}
		String apellido = request.getParameter("apellido-txt").trim();
		if (apellido.isEmpty()) {
			errores.add("Debe ingresar un apellido");
		}
		
		String edadTxt = request.getParameter("edad-txt").trim();
		if(edadTxt.isEmpty()) {
			errores.add("Debe ingresar un precio");
		}else if(Integer.parseInt(edadTxt) < 18){
			errores.add("La edad debe ser igual o mayor a 18 años");
		}
		String empresa = request.getParameter("empresa-txt").trim();
		if (empresa.isEmpty() || empresa.length() < 6) {
			errores.add("Debe ingresar un una empresa (minimo 6 letras)");
		}
		String estado = request.getParameter("estado-select").trim();
		if (estado.isEmpty()) {
			errores.add("Debe ingresar un estado");
		}
		String region = request.getParameter("region-select").trim();
		if (region.isEmpty()) {
			errores.add("Debe ingresar una region");
		}
		
		if (errores.isEmpty()) {
			int edad=Integer.parseInt(edadTxt);
			Asistente asistente = new Asistente();
			asistente.setRut(rut);
			asistente.setNombre(nombre);
			asistente.setApellido(apellido);
			asistente.setEdad(edad);
			asistente.setEmpresa(empresa);
			asistente.setEstado(estado);
			asistente.setRegion(region);
			asistentesDAO.save(asistente);
			request.setAttribute("mensaje", "persona registrada exitosamente");
//			request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitud.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
	}

}
