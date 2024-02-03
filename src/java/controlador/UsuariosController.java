package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuarios;
import modelo.UsuariosDAO;

/**
 *
 * @author blablabla
 */
@WebServlet(name = "ClientsController", urlPatterns = {"/ClientsController"})
public class UsuariosController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		UsuariosDAO usuariosDAO = new UsuariosDAO();
		String accion;
		RequestDispatcher dispatcher = null;

		accion = request.getParameter("accion");

		if (accion == null || accion.isEmpty()) {
			dispatcher = request.getRequestDispatcher("Clients/index.jsp");
			List<Usuarios> listaUsuarios = usuariosDAO.listarUsuarios();
			request.setAttribute("lista", listaUsuarios);
		}

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
